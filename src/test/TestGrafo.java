package test;

import model.Grafo;
import model.Persona;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<Persona> grafoDni = new Grafo<>();


        // Array de personas
        Persona[] personas = {
                new Persona("123", "Ana", "Gómez", 25),
                new Persona("456", "Luis", "Pérez", 30),
                new Persona("789", "Carlos", "Ruiz", 28),
                new Persona("234", "Beatriz", "López", 32),
                new Persona("567", "Diego", "Martínez", 27),
                new Persona("890", "Elena", "Fernández", 29),
                new Persona("345", "Fernando", "Torres", 31),
                new Persona("678", "Gabriela", "Sánchez", 26),
                new Persona("901", "Hugo", "Ramírez", 33),
                new Persona("112", "Irene", "Castro", 24),
                new Persona("223", "Jorge", "Molina", 35),
                new Persona("334", "Karina", "Vega", 22),
                new Persona("445", "Laura", "Silva", 34),
                new Persona("556", "Marcos", "Domínguez", 36),
                new Persona("667", "Natalia", "Aguilar", 23)
        };
    }
}