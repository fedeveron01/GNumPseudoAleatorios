package com.example.tp1sim.Pantallas;

import com.example.tp1sim.Controladores.ControladorGenerador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PantallaGenerador {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField x0;
    @FXML
    private TextField k;
    @FXML
    private TextField g;
    @FXML
    private TextField c;

    private ControladorGenerador controladorGenerador;
    @FXML
    protected void onHelloButtonClick()
    {

    }

    public void generarCongruencialLineal(ActionEvent actionEvent) {
        int x0 = Integer.parseInt(this.x0.getText());
        int k = Integer.parseInt(this.k.getText());
        int g = Integer.parseInt(this.g.getText());
        int c = Integer.parseInt(this.c.getText());

        controladorGenerador = new ControladorGenerador(x0,k,g,c);

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void generarCongruencialMultiplicativo(ActionEvent actionEvent) {
        int x0 = Integer.parseInt(this.x0.getText());
        int k = Integer.parseInt(this.k.getText());
        int g = Integer.parseInt(this.g.getText());
        controladorGenerador = new ControladorGenerador(x0,k,g);
    }
}