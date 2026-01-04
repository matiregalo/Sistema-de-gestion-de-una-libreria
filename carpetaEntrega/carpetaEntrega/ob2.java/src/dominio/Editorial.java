//Matias Regalo 308940 | Juan Constantin 335718
package dominio;

import java.io.Serializable;

public class Editorial implements Serializable{

    private String nombre;
    private String paisDeOrigen;

    // Constructor con parametros
    public Editorial(String nombre, String paisDeOrigen) {
        this.nombre = nombre;
        this.paisDeOrigen = paisDeOrigen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    
       // Método toString para representar al jugador
    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getPaisDeOrigen()+ ")";
    }
}
