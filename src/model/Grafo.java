package model;

import java.util.ArrayList;
import interfaces.IGrafo;

public class Grafo<T> implements IGrafo<T> {
    private ArrayList<T> vertices;
    private ArrayList<ArrayList<Integer>> matrizAdyacencia;
    private boolean esDirigido;
    
    public Grafo() {
        this.vertices = new ArrayList<>();
        this.matrizAdyacencia = new ArrayList<>();
        this.esDirigido = false;
    }
    
    public Grafo(boolean dirigido) {
        this.vertices = new ArrayList<>();
        this.matrizAdyacencia = new ArrayList<>();
        this.esDirigido = dirigido;
    }
    
    @Override
    public void agregarVertice(T nuevoVertice) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equals(nuevoVertice)) {
                return;
            }
        }
        
        vertices.add(nuevoVertice);
        
        ArrayList<Integer> nuevaFila = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            nuevaFila.add(0);
        }
        matrizAdyacencia.add(nuevaFila);
        
        for (int i = 0; i < matrizAdyacencia.size() - 1; i++) {
            matrizAdyacencia.get(i).add(0);
        }
    }
    
    private int buscarIndice(T vertice) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equals(vertice)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public void agregarArista(T origen, T destino) {
        int indiceOrigen = buscarIndice(origen);
        int indiceDestino = buscarIndice(destino);
        
        if (indiceOrigen == -1 || indiceDestino == -1) {
            System.out.println("Uno o ambos vertices no existen");
            return;
        }
        
        matrizAdyacencia.get(indiceOrigen).set(indiceDestino, 1);
        
        if (!esDirigido) {
            matrizAdyacencia.get(indiceDestino).set(indiceOrigen, 1);
        }
    }
    
    @Override
    public ArrayList<T> obtenerAdyacentes(T vertice) {
        ArrayList<T> adyacentes = new ArrayList<>();
        int indice = buscarIndice(vertice);
        
        if (indice == -1) {
            return adyacentes;
        }
        
        for (int i = 0; i < vertices.size(); i++) {
            if (matrizAdyacencia.get(indice).get(i) == 1) {
                adyacentes.add(vertices.get(i));
            }
        }
        
        return adyacentes;
    }
    
    @Override
    public void recorridoDFS(T inicio) {
        int indiceInicio = buscarIndice(inicio);
        if (indiceInicio == -1) {
            System.out.println("El vertice no existe en el grafo");
            return;
        }
        
        ArrayList<Boolean> visitados = new ArrayList<>();
        Pila pila = new Pila();
        
        for (int i = 0; i < vertices.size(); i++) {
            visitados.add(false);
        }
        
        pila.apilar(indiceInicio);
        
        System.out.println("Recorrido DFS desde " + inicio + ":");
        
        while (!pila.estaVacia()) {
            int indiceActual = pila.desapilar();
            
            if (!visitados.get(indiceActual)) {
                visitados.set(indiceActual, true);
                System.out.print(vertices.get(indiceActual) + " -> ");
                
                for (int i = vertices.size() - 1; i >= 0; i--) {
                    if (matrizAdyacencia.get(indiceActual).get(i) == 1 && !visitados.get(i)) {
                        pila.apilar(i);
                    }
                }
            }
        }
        System.out.println("FIN");
    }
    
    @Override
    public void recorridoBFS(T inicio) {
        int indiceInicio = buscarIndice(inicio);
        if (indiceInicio == -1) {
            System.out.println("El vertice no existe en el grafo");
            return;
        }
        
        ArrayList<Boolean> visitados = new ArrayList<>();
        Cola cola = new Cola();
        
        for (int i = 0; i < vertices.size(); i++) {
            visitados.add(false);
        }
        
        visitados.set(indiceInicio, true);
        cola.encolar(indiceInicio);
        
        System.out.println("Recorrido BFS desde " + inicio + ":");
        
        while (!cola.estaVacia()) {
            int indiceActual = cola.desencolar();
            System.out.print(vertices.get(indiceActual) + " -> ");
            
            for (int i = 0; i < vertices.size(); i++) {
                if (matrizAdyacencia.get(indiceActual).get(i) == 1 && !visitados.get(i)) {
                    visitados.set(i, true);
                    cola.encolar(i);
                }
            }
        }
        System.out.println("FIN");
    }
    
    @Override
    public void mostrarMatrizAdyacencia() {
        if (vertices.size() == 0) {
            System.out.println("El grafo esta vacio");
            return;
        }
        
        System.out.println("\nMatriz de Adyacencia:");
        
        System.out.print("\t\t");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print("[" + i + "]\t");
        }
        System.out.println();
        
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print("[" + i + "] " + vertices.get(i) + "\t");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdyacencia.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
    
    @Override
    public boolean esDirigido() {
        return esDirigido;
    }
    
    @Override
    public void mostrarVertices() {
        System.out.println("\nVertices del grafo:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println("[" + i + "] " + vertices.get(i));
        }
    }
    
    @Override
    public void mostrarGrafo() {
        System.out.println("\nEstructura del grafo:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " -> ");
            ArrayList<T> adyacentes = obtenerAdyacentes(vertices.get(i));
            for (int j = 0; j < adyacentes.size(); j++) {
                System.out.print(adyacentes.get(j));
                if (j < adyacentes.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    
    @Override
    public int obtenerCantidadVertices() {
        return vertices.size();
    }
}
