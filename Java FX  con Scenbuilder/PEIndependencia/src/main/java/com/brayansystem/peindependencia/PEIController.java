package com.brayansystem.peindependencia;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class PEIController {
    @FXML
    private Button btnCalcular;

    @FXML
    private TextArea txtNumeros;

    @FXML
    private TextArea txtResultado;

    @FXML
    public void initialize() {
        btnCalcular.setOnAction(event -> onCalcular());
    }

    @FXML
    private void onCalcular() {
        String input = txtNumeros.getText();
        String[] numerosStr = input.split("[,\\s]+"); // separados por coma o espacio
        List<Double> numeros = new ArrayList<>();

        try {
            for (String numStr : numerosStr) {
                numeros.add(Double.parseDouble(numStr));
            }

            boolean independencia = pruebaIndependencia(numeros);
            txtResultado.setText(independencia ? "Los números son independientes." : "Los números NO son independientes.");
        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingrese solo números separados por coma o espacio.");
        }
    }

    private boolean pruebaIndependencia(List<Double> numeros) {
        // Método simple: compara pares consecutivos
        int n = numeros.size();
        double suma = 0;
        for (int i = 0; i < n - 1; i++) {
            suma += numeros.get(i) * numeros.get(i + 1);
        }
        double media = suma / (n - 1);

        // Comprobación simple: si la media está cerca de 1/4 (valor esperado para uniformes [0,1])
        return Math.abs(media - 0.25) < 0.05;
    }
}


