package com.onlinesalesai.evaluateexpression.MathJS;

import com.onlinesalesai.evaluateexpression.Adapters.IThirdPartyAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MathJSAdapter implements IThirdPartyAdapter {

    /*
        Adapter class used to convert String equations to RequestBody of third party api and convert response for api to Strings
     */

    private final RestTemplate restTemplate;
    @Autowired
    public MathJSAdapter(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }
    @Override
    public List<String> solveExpression(List<String> expression) {
        MathJSRequestDTO requestDTO = convertStringsToRequestDTO(expression);
        String url = "http://api.mathjs.org/v4/";
        ResponseEntity<MathJSResponseDTO> responseEntity = makePOSTCallout(url,requestDTO);
        return convertResponseEntityToStrings(responseEntity);
    }

    private ResponseEntity<MathJSResponseDTO> makePOSTCallout(String url, MathJSRequestDTO requestDTO){
        ResponseEntity<MathJSResponseDTO> responseEntity;
        try{
            responseEntity = restTemplate.postForEntity(url,requestDTO, MathJSResponseDTO.class);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return responseEntity;
    }

    private MathJSRequestDTO convertStringsToRequestDTO(List<String> exprs){
        MathJSRequestDTO requestDTO = new MathJSRequestDTO();
        String [] arr = new String[exprs.size()];
        int index = 0;
        for (String exp : exprs)
            arr[index++] = exp;
        requestDTO.setExpr(arr);
        return requestDTO;
    }

    private List<String> convertResponseEntityToStrings(ResponseEntity<MathJSResponseDTO> responseEntity){
        if (responseEntity == null || responseEntity.getBody() == null)
            return null;
        else if (responseEntity.getStatusCode() != HttpStatusCode.valueOf(200)){
            ArrayList<String> expressionResults = new ArrayList<>();
            expressionResults.add(responseEntity.getBody().getError());
            return expressionResults;
        }
        return convertResponseDTOToStrings(responseEntity.getBody());
    }

    private List<String> convertResponseDTOToStrings(MathJSResponseDTO responseDTO){
        if (responseDTO.getResult() == null || responseDTO.getResult().length == 0){
            ArrayList<String> expressionResults = new ArrayList<>();
            expressionResults.add(responseDTO.getError());
            return expressionResults;
        }
        ArrayList<String> expressionResults = new ArrayList<>(Arrays.asList(responseDTO.getResult()));
        return expressionResults;
    }
}
