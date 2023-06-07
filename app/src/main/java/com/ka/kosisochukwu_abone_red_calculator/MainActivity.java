package com.ka.kosisochukwu_abone_red_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean startNewNumber = true;
    CalculatorModel calculatorModel = new CalculatorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleButtonPressed (android.view.View view){

        Button button = (Button) view;
        String buttonText = (String) button.getText();
        Log.i("msg", " " + buttonText);

        TextView textView = (TextView) findViewById(R.id.numberDisplay);
        String currentValue = (String) textView.getText();

        switch (buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (startNewNumber) {
                    currentValue = buttonText;
                } else {
                    currentValue += buttonText;
                }
                startNewNumber = false;
                break;
            case "0":
                if (!currentValue.equals("0")) { // Ignore leading zeros
                    if (startNewNumber) {
                        currentValue = buttonText;
                    } else {
                        currentValue += buttonText;
                    }
                }
                break;
            case ".":
                if (startNewNumber) {
                    currentValue = "0" + buttonText;
                } else if (!currentValue.contains(".")) {
                    currentValue += buttonText;
                }
                startNewNumber = false;
                break;
            case "+":
            case "-":
            case "x":
            case "/":
                if(calculatorModel.isFirstNumberSet && calculatorModel.isOperatorSet && !startNewNumber){
                    Double secondNumber = Double.parseDouble(currentValue);
                    calculatorModel.setSecondNumber(secondNumber);

                    currentValue = resultToString(calculatorModel.getResult());
                    startNewNumber = true;
                }
                Double firstNumber = Double.parseDouble(currentValue);
                calculatorModel.setFirstNumber(firstNumber);
                calculatorModel.setOperator(buttonText);
                startNewNumber = true;
                break;
            case "%":
                if(!currentValue.equals("0")) {
                    double percent = Double.parseDouble(currentValue) / 100;
                    currentValue = Double.toString(percent);
                }
                startNewNumber = true;
                break;
            case "=":
                if(calculatorModel.isFirstNumberSet) {
                    Double secondNumber = Double.parseDouble(currentValue);
                    calculatorModel.setSecondNumber(secondNumber);

                    currentValue = resultToString(calculatorModel.getResult());
                    startNewNumber = true;
                }
                break;
            case "+/-":
                if(!startNewNumber && !currentValue.contains("-")) {
                    currentValue = "-" + currentValue;
                }
                startNewNumber = true;
                break;
            case "C":
                calculatorModel.clear();
                startNewNumber = true;
                currentValue = "0";
                break;
            case "⌫":
                if(currentValue.length() == 1){
                    currentValue = "0";
                    startNewNumber = true;
                }
                else if(currentValue.length() > 1) {
                    currentValue = currentValue.substring(0, currentValue.length() - 1);
                }
        }

        textView.setText(currentValue);

    }
        public String resultToString(double num){
            int numInt = (int) num;
            if(num == numInt){
                return Integer.toString(numInt);
            }
            else{
                return Double.toString(num);
            }
        }
}