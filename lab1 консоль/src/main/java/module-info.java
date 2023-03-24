module ru.bstu.itz.cherepchenko.lab1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires com.almasb.fxgl.all;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;

    opens ru.bstu.itz.cherepchenko.lab1 to javafx.fxml;
    exports ru.bstu.itz.cherepchenko.lab1;
}