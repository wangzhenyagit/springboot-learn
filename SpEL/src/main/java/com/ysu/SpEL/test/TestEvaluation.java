package com.ysu.SpEL.test;

import com.ysu.SpEL.bean.Inventor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestEvaluation {
    public static void main(String[] args) {
        Inventor inventor = new Inventor("Nikola Tesla");
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("name");
        EvaluationContext expressionContext = new StandardEvaluationContext(inventor);
        String name1 = (String) expression.getValue(expressionContext);
        String name2 = (String) expression.getValue(inventor);
        System.out.println(name1);
        System.out.println(name2);

        Expression exp = expressionParser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(expressionContext, Boolean.class);
        System.out.println(result);
    }
}
