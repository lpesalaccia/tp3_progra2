package test;

import model.Grafo;
import model.Persona;
import interfaces.IGrafo;

public class TestGrafo {
    public static void main(String[] args) {
        System.out.println("=== TRABAJO PRACTICO 3 - GRAFOS ===");
        
        IGrafo<Persona> grafoPersonas = new Grafo<>(false);
        System.out.println("\n1. CREANDO GRAFO NO DIRIGIDO CON PERSONAS");

        Persona ana = new Persona("123", "Ana", "Gomez", 25);
        Persona luis = new Persona("456", "Luis", "Perez", 30);
        Persona carlos = new Persona("789", "Carlos", "Ruiz", 28);
        Persona beatriz = new Persona("234", "Beatriz", "Lopez", 32);
        Persona diego = new Persona("567", "Diego", "Martinez", 27);
        Persona elena = new Persona("890", "Elena", "Fernandez", 29);

        grafoPersonas.agregarVertice(ana);
        grafoPersonas.agregarVertice(luis);
        grafoPersonas.agregarVertice(carlos);
        grafoPersonas.agregarVertice(beatriz);
        grafoPersonas.agregarVertice(diego);
        grafoPersonas.agregarVertice(elena);

        System.out.println("Personas agregadas al grafo:");
        grafoPersonas.mostrarVertices();

        System.out.println("\nAgregando conexiones...");
        grafoPersonas.agregarArista(ana, luis);
        grafoPersonas.agregarArista(ana, carlos);
        grafoPersonas.agregarArista(luis, beatriz);
        grafoPersonas.agregarArista(carlos, diego);
        grafoPersonas.agregarArista(diego, elena);
        grafoPersonas.agregarArista(beatriz, elena);

        grafoPersonas.mostrarGrafo();

        System.out.println("\n=== RECORRIDOS DEL GRAFO ===");
        
        System.out.println("\n2. RECORRIDO DFS (Busqueda en Profundidad usando Pila)");
        grafoPersonas.recorridoDFS(ana);

        System.out.println("\n3. RECORRIDO BFS (Busqueda en Anchura usando Cola)");
        grafoPersonas.recorridoBFS(ana);

        System.out.println("\n4. MATRIZ DE ADYACENCIA");
        grafoPersonas.mostrarMatrizAdyacencia();

        System.out.println("\n\n=== GRAFO DIRIGIDO ===");
        System.out.println("\n5. CREANDO GRAFO DIRIGIDO (Jerarquia)");
        
        IGrafo<Persona> grafoDirigido = new Grafo<>(true);
        
        Persona jefe = new Persona("001", "Maria", "Rodriguez", 45);
        Persona supervisor1 = new Persona("002", "Pedro", "Gonzalez", 35);
        Persona supervisor2 = new Persona("003", "Laura", "Mendez", 33);
        Persona empleado1 = new Persona("004", "Juan", "Silva", 28);
        Persona empleado2 = new Persona("005", "Sofia", "Torres", 26);
        
        grafoDirigido.agregarVertice(jefe);
        grafoDirigido.agregarVertice(supervisor1);
        grafoDirigido.agregarVertice(supervisor2);
        grafoDirigido.agregarVertice(empleado1);
        grafoDirigido.agregarVertice(empleado2);
        
        grafoDirigido.agregarArista(jefe, supervisor1);
        grafoDirigido.agregarArista(jefe, supervisor2);
        grafoDirigido.agregarArista(supervisor1, empleado1);
        grafoDirigido.agregarArista(supervisor2, empleado2);
        
        System.out.println("Es grafo dirigido? " + grafoDirigido.esDirigido());
        grafoDirigido.mostrarVertices();
        grafoDirigido.mostrarGrafo();
        
        System.out.println("\nRecorrido DFS en grafo dirigido:");
        grafoDirigido.recorridoDFS(jefe);
        
        System.out.println("\nRecorrido BFS en grafo dirigido:");
        grafoDirigido.recorridoBFS(jefe);
        
        System.out.println("\nMatriz de adyacencia del grafo dirigido:");
        grafoDirigido.mostrarMatrizAdyacencia();
        
        System.out.println("\n=== COMPARACION ===");
        System.out.println("Grafo no dirigido tiene " + grafoPersonas.obtenerCantidadVertices() + " vertices");
        System.out.println("Grafo dirigido tiene " + grafoDirigido.obtenerCantidadVertices() + " vertices");
        
        System.out.println("\n=== DEMOSTRACION PILA Y COLA ===");
        demonstrarPilaYCola();
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
    
    private static void demonstrarPilaYCola() {
        System.out.println("\nDemostración de PILA (LIFO - Last In, First Out):");
        interfaces.IPila pila = new model.Pila();
        
        System.out.println("Apilando: 1, 2, 3");
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        
        System.out.println("Desapilando: " + pila.desapilar());
        System.out.println("Desapilando: " + pila.desapilar());
        System.out.println("Desapilando: " + pila.desapilar());
        System.out.println("¿Está vacía? " + pila.estaVacia());
        
        System.out.println("\nDemostración de COLA (FIFO - First In, First Out):");
        interfaces.ICola cola = new model.Cola();
        
        System.out.println("Encolando: 10, 20, 30");
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        
        System.out.println("Desencolando: " + cola.desencolar());
        System.out.println("Desencolando: " + cola.desencolar());
        System.out.println("Desencolando: " + cola.desencolar());
        System.out.println("¿Está vacía? " + cola.estaVacia());
    }
}