module com.brayansystem.peuniformidad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.brayansystem.peuniformidad to javafx.fxml;
    exports com.brayansystem.peuniformidad;
}