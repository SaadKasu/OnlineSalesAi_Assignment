package com.onlinesalesai.evaluateexpression.DTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExpressionRequestDTO {
    private List<String> expressions;
    public ExpressionRequestDTO(){
        expressions = new ArrayList<>();
    }
}
