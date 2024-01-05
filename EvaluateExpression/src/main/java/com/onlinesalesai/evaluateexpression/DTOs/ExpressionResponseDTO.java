package com.onlinesalesai.evaluateexpression.DTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExpressionResponseDTO {
    private List<String> expressionResult;
    public ExpressionResponseDTO(){
        expressionResult = new ArrayList<>();
    }
}
