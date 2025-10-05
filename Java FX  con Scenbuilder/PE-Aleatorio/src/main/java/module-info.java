module com.example.pealeatorio {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.bryansystem.pealeatorio to javafx.fxml;
    exports com.bryansystem.pealeatorio;
}