package com.example.colorchooserapp;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    public void initialize() {
        // Bind the TextField values to the corresponding Slider values bi-directionally
        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), conv);
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), conv);
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), conv);
        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), alphaConv);

        // Bind the color rectangle's fill property to the slider values
        colorRectangle.fillProperty().bind(
                Bindings.createObjectBinding(() ->
                                Color.rgb(
                                        (int) redSlider.getValue(),
                                        (int) greenSlider.getValue(),
                                        (int) blueSlider.getValue(),
                                        alphaSlider.getValue()
                                ),
                        redSlider.valueProperty(),
                        greenSlider.valueProperty(),
                        blueSlider.valueProperty(),
                        alphaSlider.valueProperty()
                )
        );
    }

    // Converter for integer values (used for RGB)
    private final javafx.util.StringConverter<Number> conv = new javafx.util.StringConverter<>() {
        @Override
        public String toString(Number value) {
            return value.intValue() + "";
        }

        @Override
        public Number fromString(String string) {
            return Integer.parseInt(string);
        }
    };

    // Converter for double values (used for alpha)
    private final javafx.util.StringConverter<Number> alphaConv = new javafx.util.StringConverter<>() {
        @Override
        public String toString(Number value) {
            return String.format("%.2f", value.doubleValue());
        }

        @Override
        public Number fromString(String string) {
            return Double.parseDouble(string);
        }
    };
}