package com.example.tp1sim.Modelos;

public class CongruencialMultiplicativo {

    private int m ;
    private int a;
    private int x0;

    public CongruencialMultiplicativo(int x0,int k,int g)
    {
        this.m = (int) Math.pow(2,g);
        this.a=3 +8*k;
        this.x0=x0;
    }
    public int generarXiSiguiente(int xi)
    {
        return ( a * xi ) % this.m;

    }
    public double generarRND(int xiSiguiente){
        return (double) xiSiguiente / this.m ;
    }


    public int getSemilla() {
        return this.x0;
    }
}
