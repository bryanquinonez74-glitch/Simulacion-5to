package com.bryansystem.pealeatorio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PEAleatoridadApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PEAleatoridadApplication.class.getResource("PE_Aleatoria.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("PE Aleatorio");
        stage.setScene(scene);
        stage.show();
    }
}
