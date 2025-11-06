package model;

import interfaces.IPila;

public class Pila implements IPila {
    private int[] elementos;
    private int tope;
    private int capacidad;
    
    public Pila() {
        this.capacidad = 100;
        this.elementos = new int[capacidad];
        this.tope = -1;
    }
    
    @Override
    public void apilar(int elemento) {
        if (tope == capacidad - 1) {
            System.out.println("Error: La pila está llena");
            return;
        }
        tope++;
        elementos[tope] = elemento;
    }
    
    @Override
    public int desapilar() {
        if (estaVacia()) {
            return -1;
        }
        int elemento = elementos[tope];
        tope--;
        return elemento;
    }
    
    @Override
    public boolean estaVacia() {
        return tope == -1;
    }
}