package com.onlinesalesai.evaluateexpression.Controller;

import com.onlinesalesai.evaluateexpression.DTOs.ExpressionRequestDTO;
import com.onlinesalesai.evaluateexpression.DTOs.ExpressionResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IExpressionController {
    @PostMapping("/evaluate")
    public ResponseEntity<ExpressionResponseDTO> evaluateExpression(@RequestBody ExpressionRequestDTO requestDTO);
}
