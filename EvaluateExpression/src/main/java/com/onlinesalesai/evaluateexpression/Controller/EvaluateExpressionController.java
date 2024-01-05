package com.onlinesalesai.evaluateexpression.Controller;

import com.onlinesalesai.evaluateexpression.DTOs.ExpressionRequestDTO;
import com.onlinesalesai.evaluateexpression.DTOs.ExpressionResponseDTO;
import com.onlinesalesai.evaluateexpression.Services.EvaluateExpressionService;
import com.onlinesalesai.evaluateexpression.Services.IExpressionService;
import com.onlinesalesai.evaluateexpression.Utility.ExpressionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/EvaluateExpressions")
@RestController
public class EvaluateExpressionController implements IExpressionController {

    /*
           Either take input from client or from Local host. Endpoint for local host is
           localhost:8080/EvaluateExpressions/evaluate.
           Use post Method with requestBody like this :

                {
                    "expressions" : ["2 * 4 * 4", "sqrt(-3^2 - 4^2)"]
                }
     */

    private IExpressionService expressionService;
    @Autowired
    public EvaluateExpressionController(EvaluateExpressionService expressionService){
        this.expressionService = expressionService;
    }
    @Override
    @PostMapping("/evaluate")
    public ResponseEntity<ExpressionResponseDTO> evaluateExpression(@RequestBody ExpressionRequestDTO requestDTO) {
        List<String> expression = ExpressionUtility.convertRequestDTOToString(requestDTO);
        Optional<List<String>> optionalStrings = expressionService.solveExpression(expression);
        ExpressionResponseDTO responseDTO = ExpressionUtility.convertOptionalStringsToResponseDTO(optionalStrings);
        return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(200));
    }
}
