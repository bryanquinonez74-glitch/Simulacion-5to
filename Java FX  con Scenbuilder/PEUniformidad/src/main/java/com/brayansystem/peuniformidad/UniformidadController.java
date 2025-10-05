package com.brayansystem.peuniformidad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;

public class UniformidadController {
    @FXML
    private TextField txtCantidad;

    @FXML
    private Button btnGenerar;

    @FXML
    private TableView<Numero> tablaNumeros;

    @FXML
    private TableColumn<Numero, Integer> colIndice;

    @FXML
    private TableColumn<Numero, Double> colValor;

    @FXML
    private TextArea txtResultado;

    private ObservableList<Numero> listaNumeros;

    @FXML
    public void initialize() {
        colIndice.setCellValueFactory(data -> data.getValue().indiceProperty().asObject());
        colValor.setCellValueFactory(data -> data.getValue().valorProperty().asObject());
        listaNumeros = FXCollections.observableArrayList();
        tablaNumeros.setItems(listaNumeros);

        btnGenerar.setOnAction(event -> onCalcular());
    }

    @FXML
    private void onCalcular() {
        listaNumeros.clear();
        int n;
        try {
            n = Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            txtResultado.setText("Por favor ingrese un número válido en 'Cantidad'.");
            return;
        }

        Random rand = new Random();
        double suma = 0.0;
        double sumaCuadrados = 0.0;

        for (int i = 1; i <= n; i++) {
            double valor = rand.nextDouble(); // número [0,1)
            listaNumeros.add(new Numero(i, valor));
            suma += valor;
            sumaCuadrados += Math.pow(valor - 0.5, 2);
        }

        // --- Prueba de la media ---
        double media = suma / n;
        double z0 = Math.abs((media - 0.5) * Math.sqrt(n) / Math.sqrt(1.0 / 12.0));
        double zCritico = 1.96; // nivel 95%

        StringBuilder sb = new StringBuilder();
        sb.append("=== Prueba de Uniformidad ===\n");
        sb.append("Media calculada: ").append(media).append("\n");
        sb.append("Estadístico Z0: ").append(z0).append("\n");
        sb.append("Z crítico (95%): ±").append(zCritico).append("\n");

        if (z0 < zCritico) {
            sb.append("Resultado: No se rechaza H0 (Uniformidad aceptada)\n");
        } else {
            sb.append("Resultado: Se rechaza H0 (No uniforme)\n");
        }

        txtResultado.setText(sb.toString());
    }
}