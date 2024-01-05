package com.onlinesalesai.evaluateexpression.TestClasses;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.onlinesalesai.evaluateexpression.Controller.EvaluateExpressionController;
import com.onlinesalesai.evaluateexpression.Controller.IExpressionController;
import com.onlinesalesai.evaluateexpression.DTOs.ExpressionRequestDTO;
import com.onlinesalesai.evaluateexpression.DTOs.ExpressionResponseDTO;
import com.onlinesalesai.evaluateexpression.MathJS.MathJSAdapter;
import com.onlinesalesai.evaluateexpression.Services.EvaluateExpressionService;
import com.onlinesalesai.evaluateexpression.Utility.ExpressionUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class TestClass_ExpressionEvaluatorController {

    private IExpressionController expressionController;
@Before
    public void setup(){
        this.expressionController = new EvaluateExpressionController(new EvaluateExpressionService(new MathJSAdapter(new RestTemplateBuilder())));
    }

    @Test
    public void testExpressionOutput(){
        ExpressionRequestDTO requestDTO = new ExpressionRequestDTO();

        requestDTO.getExpressions().add("2 * 4 * 4");
        requestDTO.getExpressions().add("5 / (7 - 5)");
        requestDTO.getExpressions().add("sqrt(5^2 - 4^2)");
        requestDTO.getExpressions().add("sqrt(-3^2 - 4^2)");
        ResponseEntity<ExpressionResponseDTO> responseEntity =  expressionController.evaluateExpression(requestDTO);
        List<String> exprResults = ExpressionUtility.convertResponseEntityToStrings(responseEntity);

        Assert.assertEquals("32",exprResults.get(0));
        Assert.assertEquals("2.5",exprResults.get(1));
        Assert.assertEquals("3",exprResults.get(2));
        Assert.assertEquals("5i",exprResults.get(3));
    }



}
