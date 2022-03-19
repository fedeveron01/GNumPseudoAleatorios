package com.example.tp1sim.Modelos;

public class CongruencialLineal
{


    private int m ;
    private int a;
    private int c;
    private int x0;

    public CongruencialLineal(int x0,int k,int g,int c)
    {
        this.m = (int) Math.pow(2,g);
        this.a = 1 + 4*k;
        this.c = c;
        this.x0 = x0;

    }

    public int generarXiSiguiente(int xi)
    {
        return ( a * xi + this.c ) % this.m;

    }

    public double generarRND(int xiSiguiente){
        return (double) xiSiguiente / this.m ;
    }


    public int getSemilla() {
        return this.x0;
    }
}
