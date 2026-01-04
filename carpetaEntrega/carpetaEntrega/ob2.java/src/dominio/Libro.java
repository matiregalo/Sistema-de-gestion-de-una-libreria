//Matias Regalo 308940 | Juan Constantin 335718
package dominio;

import java.io.Serializable;

public class Libro implements Serializable{
    private String autor;
    private String genero;
    private String editorial;
    private String isbn;
    private String titulo;
    private int precioDeCosto;
    private int precioDeVenta;
    private int stock;
   
    // Constructor con parametros
    public Libro(String autor, String genero, String editorial, String isbn, String titulo, int precioDeCosto, int precioDeVenta, int stock) {
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.isbn = isbn;
        this.titulo = titulo;
        this.precioDeCosto = precioDeCosto;
        this.precioDeVenta = precioDeVenta;
        this.stock = stock;
        }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecioDeCosto() {
        return precioDeCosto;
    }

    public void setPrecioDeCosto(int precioDeCosto) {
        this.precioDeCosto = precioDeCosto;
    }

    public int getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(int precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }
    
    
     public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
 @Override
    public String toString() {
        return this.getIsbn()+ " - " + this.getTitulo();
    }
}