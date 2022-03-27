package com.example.tp1sim.Controladores;

import com.example.tp1sim.Modelos.CongruencialLineal;
import com.example.tp1sim.Modelos.Linea;
import com.example.tp1sim.Modelos.CongruencialMultiplicativo;
public class ControladorGenerador
{
    private CongruencialLineal congruencialLineal;
    private CongruencialMultiplicativo congruencialMultiplicativo;
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
    //congruencial mutipicativo
    public ControladorGenerador(int x0,int k,int g){
        this.congruencialMultiplicativo= new CongruencialMultiplicativo(x0,k, g);
        int n = 10000;
        int xi = this.congruencialMultiplicativo.getSemilla();
        Linea lineaAnterior = null;
        for(var i = 0; i<n ;i++)
        {

            Linea linea = new Linea(i,xi);
            linea.setXiSiguiente( congruencialMultiplicativo.generarXiSiguiente(xi)) ;
            linea.setRND(congruencialMultiplicativo.generarRND(linea.getXiSiguiente()));
            if(lineaAnterior != null){
                linea.setLineaAnterior(lineaAnterior);
            }
            xi = linea.getXiSiguiente();
            lineaAnterior = linea;


        }

    }
}
