//Matias Regalo 308940 | Juan Constantin 335718
package dominio;

import java.io.Serializable;
import java.util.List;

public class Autor implements Serializable{

    private String nombre;
    private String nacionalidad;
    private List<String> generos;

    // Constructor con parametros
    public Autor(String nombre, String nacionalidad, List<String> generos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generos = generos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }
    
       public boolean escribeEnGenero(String genero) {
        return generos.contains(genero);  // Verifica si el género está en la lista de géneros del autor
    }
    
       // Método toString para representar al jugador
    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getNacionalidad() + ")";
    }
}
