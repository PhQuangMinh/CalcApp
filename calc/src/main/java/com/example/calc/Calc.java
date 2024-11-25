package com.example.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calc {
    private final ConvertCalculation convertCalculation;
    private final CalcPostFix calcPostFix;

    public Calc(){
        convertCalculation = new ConvertCalculation();
        calcPostFix = new CalcPostFix();
    }
    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '^' || c == ':' || c == '*' || c == '.';
    }

    public String calculationResult(String calculation){
        if (calculation.length()==1){
            if (isOperator(calculation.charAt(0))) return "Error";
            return String.valueOf(calculation.charAt(0));
        }
        for (int index = 1; index < calculation.length(); index++){
            if (isOperator(calculation.charAt(index)) && isOperator(calculation.charAt(index-1))){
                return "Error";
            }
        }
        if (isOperator(calculation.charAt(calculation.length()-1)) ||
            calculation.charAt(0)!='-' && isOperator(calculation.charAt(0))){
            return "Error";
        }
        String cal;
        if (calculation.charAt(0)=='-'){
            cal = "0" + calculation;
        } else cal = calculation;
        List<String> postFix = convertCalculation.infixToPostfix(cal);
        return String.valueOf(calcPostFix.calcPostFix(postFix));
    }
}
