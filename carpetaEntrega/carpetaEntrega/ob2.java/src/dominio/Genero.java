//Matias Regalo 308940 | Juan Constantin 335718
package dominio;

import java.io.Serializable;

public class Genero implements Serializable{

    private String nombre;
    private String descripcion;

    // Constructor con parametros
    public Genero(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
       // Método toString para representar al jugador
    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getDescripcion()+ ")";
    }
}