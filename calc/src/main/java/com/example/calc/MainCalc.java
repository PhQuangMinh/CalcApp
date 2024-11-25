package com.example.calc;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.text.DecimalFormat;

public class MainCalc {
    @FXML
    private TextField frameCalculation;

    private StringBuilder calculation;

    private Calc calc;

    public void init(){
        calculation = new StringBuilder();
        frameCalculation.addEventFilter(KeyEvent.KEY_TYPED, Event::consume);
        calc = new Calc();
//        frameCalculation.setEditable(false);
    }

    @FXML
    public void buttonAction(ActionEvent actionEvent){
        Button clickedButton = (Button)actionEvent.getSource();
        calculation.append(clickedButton.getText());
        frameCalculation.setText(calculation.toString());
    }

    @FXML
    public void deleteEvent(){
        if (calculation.isEmpty()) return;
        calculation.deleteCharAt(calculation.length()-1);
        frameCalculation.setText(calculation.toString());
    }

    @FXML
    public void clearEvent(){
        if (calculation.isEmpty()) return;
        calculation.delete(0, calculation.length());
        frameCalculation.setText(calculation.toString());
    }

    @FXML
    public void equalsEvent(){
        String result = calc.calculationResult(calculation.toString());
        double resultDouble = Double.parseDouble(result);
        if (Math.floor(resultDouble) == resultDouble){
            frameCalculation.setText(calculation.toString() + " = " + (int)Math.floor(resultDouble));
        }else{
            DecimalFormat decimalFormat = new DecimalFormat("#.######");
            String formattedResult = decimalFormat.format(resultDouble);
            frameCalculation.setText(calculation.toString() + " = " + formattedResult);
        }
    }
}
