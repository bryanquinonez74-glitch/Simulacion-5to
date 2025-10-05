```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PruebaAleatoriedad extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Prueba de Aleatoriedad - Runs Test");

        Label lblInput = new Label("Ingresa números separados por coma:");
        TextField txtNumeros = new TextField();

        Button btnCalcular = new Button("Calcular Runs Test");
        Label lblResultado = new Label();

        btnCalcular.setOnAction(e -> {
            try {
                String[] partes = txtNumeros.getText().split(",");
                int n = partes.length;
                double[] datos = new double[n];

                for (int i = 0; i < n; i++) {
                    datos[i] = Double.parseDouble(partes[i].trim());
                }

                double media = 0;
                for (double d : datos) media += d;
                media /= n;

                // Generamos secuencia arriba (+) o abajo (-) de la media
                char[] secuencia = new char[n];
                for (int i = 0; i < n; i++) {
                    secuencia[i] = datos[i] >= media ? '+' : '-';
                }

                // Contamos runs
                int runs = 1;
                for (int i = 1; i < n; i++) {
                    if (secuencia[i] != secuencia[i-1]) runs++;
                }

                int n1 = 0, n2 = 0;
                for (char c : secuencia) {
                    if (c == '+') n1++; else n2++;
                }

                double mediaRuns = (2.0 * n1 * n2) / (n1 + n2) + 1;
                double varRuns = (2.0 * n1 * n2 * (2.0 * n1 * n2 - n1 - n2))
                        / (Math.pow(n1 + n2, 2) * (n1 + n2 - 1));
                double z = (runs - mediaRuns) / Math.sqrt(varRuns);

                lblResultado.setText(
                        "Runs = " + runs +
                                "\nEsperado = " + String.format("%.2f", mediaRuns) +
                                "\nZ = " + String.format("%.3f", z)
                );

            } catch (Exception ex) {
                lblResultado.setText("Error en los datos.");
            }
        });

        VBox vbox = new VBox(10, lblInput, txtNumeros, btnCalcular, lblResultado);
        vbox.setPadding(new Insets(20));
        stage.setScene(new Scene(vbox, 400, 250));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```
