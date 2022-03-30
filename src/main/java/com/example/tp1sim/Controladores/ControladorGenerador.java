package com.example.tp1sim.Controladores;

import com.example.tp1sim.Modelos.CongruencialLineal;
import com.example.tp1sim.Modelos.Intervalo;
import com.example.tp1sim.Modelos.Linea;
import com.example.tp1sim.Modelos.CongruencialMultiplicativo;
import com.example.tp1sim.Pantallas.PantallaGenerador;

import java.util.ArrayList;

public class ControladorGenerador {
    private CongruencialLineal congruencialLineal;
    private CongruencialMultiplicativo congruencialMultiplicativo;
    private ArrayList<Intervalo> intervalos;

    //congruencial lineal
    public ControladorGenerador(int x0, int k, int g, int c, int n, PantallaGenerador pantalla) {
        this.generarIntervalos(10, n);
        this.generarLineal(x0, k, g, c, n, pantalla);
        this.calcularChiCuadrado();
        pantalla.mostrarIntervalos(this.intervalos);


    }

    private void calcularChiCuadrado() {
        double cAcumulado = 0.0;
        for(var i=0;i<this.intervalos.size();i++){
            var fo = this.intervalos.get(i).getFrecuenciaObservada();
            var fe = this.intervalos.get(i).getFrecuenciaEsperada();
            var c = (double) Math.pow((fo-fe),2) / (fe);
            cAcumulado += c;

            this.intervalos.get(i).setC(c);
            this.intervalos.get(i).setCAcumulado(cAcumulado);


        }
    }

    //congruencial mutipicativo
    public ControladorGenerador(int x0, int k, int g, int n, PantallaGenerador pantalla) {
        this.generarIntervalos(10, n);
        this.generarMultiplicativo(x0, k, g, n, pantalla);
        pantalla.mostrarIntervalos(this.intervalos);
        this.calcularChiCuadrado();



    }

    public void generarIntervalos(int cantidadIntervalos, int n) {
        this.intervalos = new ArrayList<Intervalo>();
        double tamañoInt = (1 / (double) cantidadIntervalos);
        int frecuenciaEsperada = n / cantidadIntervalos;
        double desde = 0.000;
        double hasta = tamañoInt;
        for (var i = 0; i < cantidadIntervalos; i++) {
            Intervalo intervalo = new Intervalo(desde, hasta - 0.001, frecuenciaEsperada);
            desde = Math.round(hasta * 100) / 100d;
            hasta = Math.round((hasta + tamañoInt) * 100) / 100d;
            this.intervalos.add(intervalo);

        }

    }

    public void generarMultiplicativo(int x0, int k, int g, int n, PantallaGenerador pantalla) {
        this.congruencialMultiplicativo = new CongruencialMultiplicativo(x0, k, g);
        int xi = this.congruencialMultiplicativo.getSemilla();
        pantalla.armarColumnas();
        Linea lineaAnterior = null;
        for (var i = 0; i < n; i++) {

            Linea linea = new Linea(i, xi);
            linea.setXiSiguiente(congruencialMultiplicativo.generarXiSiguiente(xi));
            linea.setRND(congruencialMultiplicativo.generarRND(linea.getXiSiguiente()));
            if (lineaAnterior != null) {
                linea.setLineaAnterior(lineaAnterior);
            }
            xi = linea.getXiSiguiente();
            lineaAnterior = linea;
            for (Intervalo intervalo : intervalos) {
                if (linea.getRND() >= intervalo.getDesde() && linea.getRND() <= intervalo.getHasta()) {
                    intervalo.setFrecuenciaObservada(intervalo.getFrecuenciaObservada() + 1);
                }
            }

            pantalla.ponerLinea(linea);



        }
        pantalla.generarHistograma(intervalos);
    }

    public void generarLineal(int x0, int k, int g, int c, int n, PantallaGenerador pantalla) {
        this.congruencialLineal = new CongruencialLineal(x0, k, g, c);
        int xi = this.congruencialLineal.getSemilla();
        pantalla.armarColumnas();

        Linea lineaAnterior = null;
        for (var i = 0; i < n; i++) {

            Linea linea = new Linea(i, xi);
            linea.setXiSiguiente(congruencialLineal.generarXiSiguiente(xi));
            linea.setRND(congruencialLineal.generarRND(linea.getXiSiguiente()));
            if (lineaAnterior != null) {
                linea.setLineaAnterior(lineaAnterior);
            }
            xi = linea.getXiSiguiente();
            lineaAnterior = linea;
            for (Intervalo intervalo : intervalos) {
                if (linea.getRND() >= intervalo.getDesde() && linea.getRND() <= intervalo.getHasta()) {
                    intervalo.setFrecuenciaObservada(intervalo.getFrecuenciaObservada() + 1);
                }
            }
            pantalla.ponerLinea(linea);


        }
        pantalla.generarHistograma(intervalos);
    }
}