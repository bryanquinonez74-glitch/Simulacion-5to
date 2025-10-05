package com.brayansystem.pruebasestadisticas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;

public class pruebasestadisticasController {
    @FXML
    private Button btnGenerar;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextArea txtResultado;

    @FXML
    void initialize() {
        btnGenerar.setOnAction(e -> onCalcular());
    }
    @FXML
    private void onCalcular() {
        try {
            int n = Integer.parseInt(txtCantidad.getText());
            Random random = new Random();

            // Generar números aleatorios
            double[] numeros = new double[n];
            for (int i = 0; i < n; i++) {
                numeros[i] = random.nextDouble();
            }

            // Dividir en 10 intervalos
            int k = 10;
            int[] FO = new int[k];
            double FE = (double) n / k;

            for (double num : numeros) {
                int intervalo = (int) (num * k);
                FO[intervalo]++;
            }

            // Calcular chi-cuadrado
            double chi2 = 0;
            for (int i = 0; i < k; i++) {
                chi2 += Math.pow(FO[i] - FE, 2) / FE;
            }

            // Mostrar resultados
            StringBuilder sb = new StringBuilder();
            sb.append("Cantidad de números: ").append(n).append("\n");
            sb.append("Intervalos: ").append(k).append("\n\n");

            for (int i = 0; i < k; i++) {
                sb.append("Intervalo ").append(i + 1)
                        .append(" FO: ").append(FO[i])
                        .append(" FE: ").append(FE).append("\n");
            }

            sb.append("\nChi-cuadrado calculado: ").append(chi2).append("\n");

            txtResultado.setText(sb.toString());

        } catch (NumberFormatException e) {
            txtResultado.setText("⚠️ Ingrese un número válido en el campo.");
        }
    }
}

