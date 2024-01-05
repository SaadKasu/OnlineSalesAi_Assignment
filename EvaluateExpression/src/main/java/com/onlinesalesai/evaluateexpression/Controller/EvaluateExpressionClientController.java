package com.onlinesalesai.evaluateexpression.Controller;

import com.onlinesalesai.evaluateexpression.DTOs.ExpressionRequestDTO;
import com.onlinesalesai.evaluateexpression.DTOs.ExpressionResponseDTO;
import com.onlinesalesai.evaluateexpression.Utility.ExpressionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller
public class EvaluateExpressionClientController {
    private IExpressionController expressionController;
    private Scanner takeInput;
    @Autowired
    public EvaluateExpressionClientController(EvaluateExpressionController expressionController){
        this.expressionController = expressionController;
        takeInput = new Scanner(System.in);
    }
    public void getInputFromClient(){
        /*
            Used to take input from console. Give input equations line by line and to stop put end.
         */
        ExpressionRequestDTO requestDTO = new ExpressionRequestDTO();
        System.out.println("Please enter the input equations and enter end after all equations have been added :");
        while(true){
            String expr = takeInput.nextLine();
            if (expr.equals("end"))
                break;
            requestDTO.getExpressions().add(expr);
        }
        if (requestDTO.getExpressions().size() == 0){
            System.out.println("No input given");
            return;
        }
        ResponseEntity<ExpressionResponseDTO> responseEntity = expressionController.evaluateExpression(requestDTO);
        List<String> strings = ExpressionUtility.convertResponseEntityToStrings(responseEntity);
        if (strings.size() == requestDTO.getExpressions().size()){
            System.out.println("The output of the equations in order is : ");
            for (int i =0;i< strings.size();i++)
                System.out.println(requestDTO.getExpressions().get(i) + " => "+ strings.get(i));
        }
        else {
            for (String str : strings)
                System.out.println(str);
        }
    }
}
