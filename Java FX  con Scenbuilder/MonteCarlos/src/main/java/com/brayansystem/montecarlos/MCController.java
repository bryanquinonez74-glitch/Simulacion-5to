package com.brayansystem.montecarlos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class MCController {
    @FXML
    private Button btnCalcular;

    @FXML
    private LineChart<Number, Number> chart;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtCantidad;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private CategoryAxis yAxis;

    @FXML
     void calcularMonteCarlo(ActionEvent event) {

     chart.getData().clear(); // Limpiar gráfica
    XYChart.Series<Number, Number> puntosDentro = new XYChart.Series<>();
    XYChart.Series<Number, Number> puntosFuera = new XYChart.Series<>();
        puntosDentro.setName("Dentro del círculo");
        puntosFuera.setName("Fuera del círculo");

    int cantidad;
        try {
        cantidad = Integer.parseInt(txtCantidad.getText());
    } catch (NumberFormatException e) {
        lblResultado.setText("Ingresa un número válido");
        return;
    }

    Random rnd = new Random();
    int dentro = 0;

        for (int i = 0; i < cantidad; i++) {
        double x = rnd.nextDouble();
        double y = rnd.nextDouble();
        if (x * x + y * y <= 1) {
            dentro++;
            puntosDentro.getData().add(new XYChart.Data<>(x, y));
        } else {
            puntosFuera.getData().add(new XYChart.Data<>(x, y));
        }
    }

        chart.getData().addAll(puntosDentro, puntosFuera);

    double piAprox = 4.0 * dentro / cantidad;
        lblResultado.setText("π ≈ " + piAprox);
}
}
