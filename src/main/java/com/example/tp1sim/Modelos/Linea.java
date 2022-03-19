package com.example.tp1sim.Modelos;

public class Linea
{
    private int i;
    private int xi;
    private int xiSiguiente;
    private double RND;
    private Linea lineaAnterior;

    public Linea(int i, int xi)
    {
        this.i = i;
        this.xi = xi;
    }


    public void setXiSiguiente(int xiSiguiente) {
        this.xiSiguiente = xiSiguiente;
    }
    public void setRND(double RND)
    {
            this.RND= RND;
    }

    public int getXiSiguiente() {
        return this.xiSiguiente;
    }

    public void setLineaAnterior(Linea lineaAnterior) {
        this.lineaAnterior = lineaAnterior;
    }
}
