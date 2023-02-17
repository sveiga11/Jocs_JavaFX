module com.example.zombies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zombies to javafx.fxml;
    exports com.example.zombies;
}