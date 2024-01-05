package com.onlinesalesai.evaluateexpression.Application;

import com.onlinesalesai.evaluateexpression.Controller.EvaluateExpressionClientController;
import com.onlinesalesai.evaluateexpression.Controller.EvaluateExpressionController;
import com.onlinesalesai.evaluateexpression.MathJS.MathJSAdapter;
import com.onlinesalesai.evaluateexpression.Services.EvaluateExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.onlinesalesai.evaluateexpression")
public class EvaluateExpressionApplication {
	private static EvaluateExpressionClientController clientController;
	public static void main(String[] args) {
		/*
			Use to start Execution Of Code.
		 */
		clientController = new EvaluateExpressionClientController(new EvaluateExpressionController(new EvaluateExpressionService(new MathJSAdapter(new RestTemplateBuilder()))));
		SpringApplication.run(EvaluateExpressionApplication.class, args);
		clientController.getInputFromClient();

	}

}
