package com.onlinesalesai.evaluateexpression.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IExpressionService {
    public Optional<List<String>> solveExpression(List<String> inputExpression);
}
