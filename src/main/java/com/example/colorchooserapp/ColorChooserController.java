package com.example.colorchooserapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;

public class ColorChooserController {
    // instance variables for interacting with GUI components
    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private Slider alphaSlider;
    @FXML
    private TextField redTextField;
    @FXML
    private TextField greenTextField;
    @FXML
    private TextField blueTextField;
    @FXML
    private TextField alphaTextField;
    @FXML
    private Rectangle colorRectangle;

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize() {
        // bind TextField values to corresponding Slider values
        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), new StringConverter<>() {
            @Override
            public String toString(Number number) {
                return number.toString();
            }

            @Override
            public Number fromString(String s) {
                return null;
            }
        });

        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), new StringConverter<>() {
            @Override
            public String toString(Number number) {
                return number.toString();
            }

            @Override
            public Number fromString(String s) {
                return null;
            }
        });


        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), new StringConverter<>() {
            @Override
            public String toString(Number number) {
                return number.toString();
            }

            @Override
            public Number fromString(String s) {
                return null;
            }
        });


        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), new StringConverter<>() {
            @Override
            public String toString(Number number) {
                return number.toString();
            }

            @Override
            public Number fromString(String s) {
                return null;
            }
        });

        redTextField.textProperty().addListener((observableValue, s, t1) -> redSlider.adjustValue(Double.parseDouble(t1)));

        blueTextField.textProperty().addListener((observableValue, s, t1) -> blueSlider.adjustValue(Double.parseDouble(t1)));

        greenTextField.textProperty().addListener((observableValue, s, t1) -> greenSlider.adjustValue(Double.parseDouble(t1)));

        alphaTextField.textProperty().addListener((observableValue, s, t1) -> alphaSlider.adjustValue(Double.parseDouble(t1)));

        // listeners that set Rectangle's fill based on Slider changes
        redSlider.valueProperty().addListener((ov, oldValue, newValue) -> {
            red = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        greenSlider.valueProperty().addListener((ov, oldValue, newValue) -> {
            green = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        blueSlider.valueProperty().addListener((ov, oldValue, newValue) -> {
            blue = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        alphaSlider.valueProperty().addListener((ov, oldValue, newValue) -> {
            alpha = newValue.doubleValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
    }
}
