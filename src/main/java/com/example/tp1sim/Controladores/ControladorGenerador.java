package com.example.tp1sim.Controladores;

import com.example.tp1sim.Modelos.CongruencialLineal;
import com.example.tp1sim.Modelos.Intervalo;
import com.example.tp1sim.Modelos.Linea;
import com.example.tp1sim.Modelos.CongruencialMultiplicativo;
import com.example.tp1sim.Pantallas.PantallaGenerador;

import java.util.ArrayList;

public class ControladorGenerador
{
    private CongruencialLineal congruencialLineal;
    private CongruencialMultiplicativo congruencialMultiplicativo;
    private ArrayList<Intervalo> intervalos;

    //congruencial lineal
    public ControladorGenerador(int x0,int k,int g,int c, int n , PantallaGenerador pantalla){
        this.generarIntervalos(10,n);
        this.generarLineal(x0,k,g,c,n,pantalla);
        pantalla.mostrarIntervalos(this.intervalos);


    }

    //congruencial mutipicativo
    public ControladorGenerador(int x0, int k, int g, int n , PantallaGenerador pantalla){
        this.generarMultiplicativo(x0,k,g,n,pantalla);


    }

    public void generarIntervalos(int cantidadIntervalos , int n){
        this.intervalos = new ArrayList<Intervalo>();
        int frecuenciaEsperada = n / cantidadIntervalos;
        double desde = 0;
        double hasta = ((double) (1 / cantidadIntervalos) );
        for(var i=0;i<cantidadIntervalos;i++)
        {
            Intervalo intervalo = new Intervalo(desde,hasta - 0.001,frecuenciaEsperada);
            desde = hasta;
            hasta = hasta * 2;
            this.intervalos.add(intervalo);

        }

    }
    public void generarMultiplicativo(int x0, int k, int g, int n , PantallaGenerador pantalla){
        this.congruencialMultiplicativo= new CongruencialMultiplicativo(x0,k, g);
        int xi = this.congruencialMultiplicativo.getSemilla();
        pantalla.armarColumnas();
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

            pantalla.ponerLinea(linea);


        }
    }
    public void generarLineal(int x0,int k,int g,int c, int n , PantallaGenerador pantalla){
        this.congruencialLineal = new CongruencialLineal(x0,k,g,c);
        int xi = this.congruencialLineal.getSemilla();
        pantalla.armarColumnas();

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
            for (Intervalo intervalo : intervalos)
            {
                if(linea.getRND() >= intervalo.getDesde() && linea.getRND() <= intervalo.getHasta())
                {
                    intervalo.setFrecuenciaObservada(intervalo.getFrecuenciaObservada()+1);
                }
            }
            pantalla.ponerLinea(linea);

        }
    }



}
