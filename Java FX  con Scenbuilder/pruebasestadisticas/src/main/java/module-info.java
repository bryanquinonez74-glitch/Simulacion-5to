module com.brayansystem.pruebasestadisticas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.brayansystem.pruebasestadisticas to javafx.fxml;
    exports com.brayansystem.pruebasestadisticas;
}