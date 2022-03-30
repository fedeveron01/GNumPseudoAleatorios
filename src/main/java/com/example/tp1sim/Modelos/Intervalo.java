package com.example.tp1sim.Modelos;

public class Intervalo {
    private double desde;
    private double hasta;
    private int frecuenciaObservada;
    private int frecuenciaEsperada;
    private double c;
    private double cAcumulado;
    private double marcaDeClase;

    public Intervalo(double desde,double hasta,int frecuenciaEsperada){
        this.desde =desde;
        this.hasta = hasta;
        this.frecuenciaEsperada = frecuenciaEsperada;
        var marca = (double) ((hasta + desde)/2);
        this.marcaDeClase = marca;

    }
    public double getDesde() {
        return desde;
    }

    public void setDesde(double desde) {
        this.desde = desde;
    }

    public double getHasta() {
        return hasta;
    }

    public void setHasta(double hasta) {
        this.hasta = hasta;
    }

    public int getFrecuenciaObservada() {
        return frecuenciaObservada;
    }

    public void setFrecuenciaObservada(int frecuenciaObservada) {
        this.frecuenciaObservada = frecuenciaObservada;
    }

    public int getFrecuenciaEsperada() {
        return frecuenciaEsperada;
    }

    public void setFrecuenciaEsperada(int frecuenciaEsperada) {
        this.frecuenciaEsperada = frecuenciaEsperada;
    }

    public double getMarcaDeClase() {
        return marcaDeClase;
    }

    public void setMarcaDeClase(double marcaDeClase) {
        this.marcaDeClase = marcaDeClase;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getCAcumulado() {
        return cAcumulado;
    }

    public void setCAcumulado(double cAcumulado) {
        this.cAcumulado = cAcumulado;
    }
}
