module com.example.pruebasdexml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.pruebasdexml to javafx.fxml;
    exports com.example.pruebasdexml;
}