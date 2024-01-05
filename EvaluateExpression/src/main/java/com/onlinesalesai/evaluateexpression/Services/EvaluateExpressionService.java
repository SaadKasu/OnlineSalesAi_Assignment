package com.onlinesalesai.evaluateexpression.Services;

import com.onlinesalesai.evaluateexpression.Adapters.IThirdPartyAdapter;
import com.onlinesalesai.evaluateexpression.MathJS.MathJSAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluateExpressionService implements IExpressionService{

    /*
        Service Layer for Application.
        Takes input from client controllers/ client and sends it to third party API. In this case using
        https://api.mathjs.org/
     */

    private IThirdPartyAdapter thirdPartyAdapter;
    @Autowired
    public EvaluateExpressionService(MathJSAdapter thirdPartyAdapter){
        this.thirdPartyAdapter = thirdPartyAdapter;
    }
    @Override
    public Optional<List<String>> solveExpression(List<String> inputExpressions) {
        List<String> expressionOutput = thirdPartyAdapter.solveExpression(inputExpressions);
        return Optional.ofNullable(expressionOutput);
    }
}
