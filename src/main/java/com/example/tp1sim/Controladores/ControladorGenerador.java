package com.example.tp1sim.Controladores;

import com.example.tp1sim.Modelos.CongruencialLineal;
import com.example.tp1sim.Modelos.Linea;

public class ControladorGenerador
{
    private CongruencialLineal congruencialLineal;

    public ControladorGenerador(int x0,int k,int g,int c){
        this.congruencialLineal = new CongruencialLineal(x0,k,g,c);
        int n = 10000;
        int xi = this.congruencialLineal.getSemilla();
        Linea lineaAnterior = null;
        for(var i = 0; i<n ;i++)
        {

            Linea linea = new Linea(i,xi);
            linea.setXiSiguiente( congruencialLineal.generarXiSiguiente(xi)) ;
            linea.setRND(congruencialLineal.generarRND(linea.getXiSiguiente()));
            if(lineaAnterior != null){
                    linea.setLineaAnterior(lineaAnterior);
            }
            xi = linea.getXiSiguiente();
            lineaAnterior = linea;


        }

    }
}
