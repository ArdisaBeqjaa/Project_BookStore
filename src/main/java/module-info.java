module com.example.project_bookstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project_bookstore to javafx.fxml;
    exports com.example.project_bookstore;
}