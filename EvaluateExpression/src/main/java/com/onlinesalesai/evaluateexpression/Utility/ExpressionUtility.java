package com.onlinesalesai.evaluateexpression.Utility;

import com.onlinesalesai.evaluateexpression.DTOs.ExpressionRequestDTO;
import com.onlinesalesai.evaluateexpression.DTOs.ExpressionResponseDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpressionUtility {
    public static List<String> convertRequestDTOToString(ExpressionRequestDTO requestDTO){
        return requestDTO.getExpressions();
    }

    public static ExpressionResponseDTO convertOptionalStringsToResponseDTO(Optional<List<String>> optionalStrings){
        ExpressionResponseDTO responseDTO = new ExpressionResponseDTO();
        if (optionalStrings.isEmpty()){
            String errorMessage = "Something went wrong. Please try again";
            ArrayList<String> expressionResults = new ArrayList<>();
            expressionResults.add(errorMessage);
            responseDTO.setExpressionResult(expressionResults);
        }
        else{
            List<String> expressionResults = optionalStrings.get();
            responseDTO.setExpressionResult(expressionResults);
        }

        return responseDTO;
    }

    public static List<String> convertResponseEntityToStrings(ResponseEntity<ExpressionResponseDTO> responseEntity){
        if (responseEntity.getStatusCode() != HttpStatusCode.valueOf(200)){
            String errorMessage = "Something went wrong. Please try again";
            ArrayList<String> expressionResults = new ArrayList<>();
            expressionResults.add(errorMessage);
            return expressionResults;
        }
        return responseEntity.getBody().getExpressionResult();
    }

}
