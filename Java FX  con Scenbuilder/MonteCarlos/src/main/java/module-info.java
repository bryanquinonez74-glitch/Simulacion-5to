module com.brayansystem.montecarlos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.brayansystem.montecarlos to javafx.fxml;
    exports com.brayansystem.montecarlos;
}