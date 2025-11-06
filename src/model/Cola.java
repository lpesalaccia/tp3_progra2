package model;

import interfaces.ICola;

public class Cola implements ICola {
    private int[] elementos;
    private int frente;
    private int fin;
    private int contador;
    private int capacidad;
    
    public Cola() {
        this.capacidad = 100;
        this.elementos = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.contador = 0;
    }
    
    @Override
    public void encolar(int elemento) {
        if (contador == capacidad) {
            System.out.println("Error: La cola está llena");
            return;
        }
        fin = (fin + 1) % capacidad;
        elementos[fin] = elemento;
        contador++;
    }
    
    @Override
    public int desencolar() {
        if (estaVacia()) {
            return -1;
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad;
        contador--;
        return elemento;
    }
    
    @Override
    public boolean estaVacia() {
        return contador == 0;
    }
}