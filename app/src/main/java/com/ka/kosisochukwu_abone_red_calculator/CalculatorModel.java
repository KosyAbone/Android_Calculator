package com.ka.kosisochukwu_abone_red_calculator;

import android.util.Log;

public class CalculatorModel {

    double firstNumber = 0.0;
    double secondNumber = 0.0;
    String operator = "";
    double result = 0.0;

    boolean isFirstNumberSet = false;
    boolean isSecondNumberSet = false;
    boolean isOperatorSet = false;

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
        isFirstNumberSet = true;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
        isSecondNumberSet = true;
    }

    public void setOperator(String operator) {
        this.operator = operator;
        isOperatorSet = true;
    }

    public double getResult() {
        if(isFirstNumberSet && !isSecondNumberSet && isOperatorSet){
            secondNumber = firstNumber;
        }
        if(isFirstNumberSet && isSecondNumberSet && isOperatorSet){
            switch (operator){
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "x":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
           }
        }
        return result;
    }

    public void clear(){
        double firstNumber = 0.0;
        double secondNumber = 0.0;
        String operator = "";
        boolean isFirstNumberSet = false;
        boolean isSecondNumberSet = false;
        boolean isOperatorSet = false;
    }
}
