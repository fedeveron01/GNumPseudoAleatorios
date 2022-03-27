package com.example.tp1sim.Pantallas;

import com.example.tp1sim.Controladores.ControladorGenerador;
import com.example.tp1sim.Modelos.Intervalo;
import com.example.tp1sim.Modelos.Linea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class PantallaGenerador {

    @FXML
    private TextField x0;
    @FXML
    private TextField k;
    @FXML
    private TextField g;
    @FXML
    private TextField c;
    @FXML
    private TextField n;
    @FXML
    private TableView tblGenerador;
    @FXML
    private TableView tblIntervalos;


    @FXML
    private ChoiceBox cbIntervalos;

    private ControladorGenerador controladorGenerador;


    public void generarCongruencialLineal(ActionEvent actionEvent) {
        int x0 = Integer.parseInt(this.x0.getText());
        int k = Integer.parseInt(this.k.getText());
        int g = Integer.parseInt(this.g.getText());
        int c = Integer.parseInt(this.c.getText());
        int n = Integer.parseInt(this.n.getText());

        controladorGenerador = new ControladorGenerador(x0,k,g,c,n,this);

    }

    public void generarCongruencialMultiplicativo(ActionEvent actionEvent) {
        int x0 = Integer.parseInt(this.x0.getText());
        int k = Integer.parseInt(this.k.getText());
        int g = Integer.parseInt(this.g.getText());
        int n = Integer.parseInt(this.n.getText());

        controladorGenerador = new ControladorGenerador(x0,k,g,n,this);
    }

    public void limpiarTabla(){
        tblGenerador.getColumns().clear();
        tblGenerador.getItems().clear();
    }

    public void limpiarTablaIntervalos()
    {
        tblIntervalos.getColumns().clear();
        tblIntervalos.getItems().clear();

    }

    public void armarColumnas(){
        limpiarTabla();
        TableColumn<Linea,Integer> colIteracion = new TableColumn<>("Iteración");
        TableColumn<Linea,Integer> colXi = new TableColumn<>("Xi");
        TableColumn<Linea,Integer> colXiSiguiente = new TableColumn<>("Xi+1");
        TableColumn<Linea,Double> colRND = new TableColumn<>("RND");

        colIteracion.setCellValueFactory(new PropertyValueFactory<Linea,Integer>("i"));
        colXi.setCellValueFactory(new PropertyValueFactory<Linea,Integer>("xi"));
        colXiSiguiente.setCellValueFactory(new PropertyValueFactory<Linea,Integer>("xiSiguiente"));
        colRND.setCellValueFactory(new PropertyValueFactory<Linea,Double>("RND"));

        tblGenerador.getColumns().addAll(colIteracion,colXi,colXiSiguiente,colRND);


    }
    public void ponerLinea(Linea linea) {
     ;

        tblGenerador.getItems().add(linea);


    }

    public void armarGrafico(){
        List<Linea> lineas =  tblGenerador.getItems();
    }

    public void mostrarIntervalos(ArrayList<Intervalo> intervalos)
    {
        this.limpiarTablaIntervalos();
        TableColumn<Intervalo,Double> colDesde = new TableColumn<>("desde");
        TableColumn<Intervalo,Double> colHasta = new TableColumn<>("hasta");
        TableColumn<Intervalo,Integer> colFrecuenciaObservada = new TableColumn<>("frecuenciaObservada");
        TableColumn<Intervalo,Integer> colFrecuenciaEsperada = new TableColumn<>("frecuenciaEsperada");

        colDesde.setCellValueFactory(new PropertyValueFactory<Intervalo,Double>("desde"));
        colHasta.setCellValueFactory(new PropertyValueFactory<Intervalo,Double>("hasta"));
        colFrecuenciaObservada.setCellValueFactory(new PropertyValueFactory<Intervalo,Integer>("frecuenciaObservada"));
        colFrecuenciaEsperada.setCellValueFactory(new PropertyValueFactory<Intervalo,Integer>("frecuenciaEsperada"));


    }
}