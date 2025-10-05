package com.brayansystem.peindependencia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PEIApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PEIApplication.class.getResource("PEIndependencia-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Prueba de Independencia de Números Pseudoaleatorios");
        stage.setScene(scene);
        stage.show();
    }
}
