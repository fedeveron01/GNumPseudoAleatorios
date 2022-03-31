package com.example.tp1sim.Modelos;
import java.text.DecimalFormat;

public class Intervalo {
    private double desde;
    private double hasta;
    private int frecuenciaObservada;
    private int frecuenciaEsperada;
    private double c;
    private double cAcumulado;
    private String marcaDeClase;

    public Intervalo(double desde,double hasta,int frecuenciaEsperada){
        this.desde =desde;
        this.hasta = hasta;
        this.frecuenciaEsperada = frecuenciaEsperada;
        double marca = (double) ((hasta + desde)/2);
        String pattern ="#.####";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        String formattedDouble = decimalFormat.format(marca);

        this.marcaDeClase = formattedDouble;

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

    public String getMarcaDeClase() {
        return marcaDeClase;
    }

    public void setMarcaDeClase(String marcaDeClase) {
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
