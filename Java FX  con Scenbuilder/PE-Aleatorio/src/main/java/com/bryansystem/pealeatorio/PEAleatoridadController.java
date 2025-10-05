package com.bryansystem.pealeatorio;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PEAleatoridadController {

    @FXML private TextField txtNumeros;
    @FXML private Button btnCalcular;
    @FXML private TextArea txtResultado;

    @FXML
    private void onCalcular() {
        try {
            String[] partes = txtNumeros.getText().split(",");
            int n = partes.length;
            int[] datos = new int[n];
            for (int i = 0; i < n; i++) datos[i] = Integer.parseInt(partes[i].trim());

            // 5 intervalos
            int[] freq = new int[5];
            for (int d : datos) {
                int idx = d / 5;
                if (idx >= 5) idx = 4;
                freq[idx]++;
            }

            double esperado = (double)n/5;
            double chi2 = 0;
            for (int f : freq) chi2 += Math.pow(f-esperado,2)/esperado;

            txtResultado.setText("Chi-cuadrado = " + chi2);
        } catch(Exception e) {
            txtResultado.setText("Error en los datos.");
        }

    }@FXML
    private void onLimpiar() {
        txtNumeros.clear();   // Limpia el TextField
        txtNumeros.requestFocus(); // Pone el cursor de nuevo en el TextField
    }
}
