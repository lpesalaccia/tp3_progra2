package interfaces;

import java.util.ArrayList;

public interface IGrafo<T> {
    void agregarVertice(T nuevoVertice);
    void agregarArista(T origen, T destino);
    ArrayList<T> obtenerAdyacentes(T vertice);
    void recorridoDFS(T inicio);
    void recorridoBFS(T inicio);
    void mostrarMatrizAdyacencia();
    boolean esDirigido();
    void mostrarGrafo();
    void mostrarVertices();
    int obtenerCantidadVertices();
}