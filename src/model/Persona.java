package model;
import interfaces.IPersona;
public class Persona implements IPersona{

    private String dni;
    private String nombre;
    private String apellido;
    private int edad;


    //Metodos
    public String obtenerNombreCompleto() {
        return nombre+" "+apellido;
    }

    //Constructor
    public Persona(String dni, String nombre, String apellido, int edad) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }


    //Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    //ToString
    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
    }


}
