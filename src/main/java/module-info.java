module com.example.tp1sim {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp1sim to javafx.fxml;
    exports com.example.tp1sim;
    exports com.example.tp1sim.Pantallas;
    opens com.example.tp1sim.Pantallas to javafx.fxml;
}