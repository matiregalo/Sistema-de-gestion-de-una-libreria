 //Matias Regalo 308940 | Juan Constantin 335718
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Venta implements Serializable {
    private String fecha;
    private String nombreDelCliente;
    private int factura;
    private List<Libro> librosVendidos;
    private List<Integer> cantidadesVendidas;

    public Venta(String fecha, String nombreDelCliente, int factura) {
        this.fecha = fecha;
        this.nombreDelCliente = nombreDelCliente;
        this.factura = factura;
        this.librosVendidos = new ArrayList<>();
        this.cantidadesVendidas = new ArrayList<>();
    }

    public void agregarLibro(Libro libro, int cantidad) {
        librosVendidos.add(libro);
        cantidadesVendidas.add(cantidad);
    }

    public int calcularTotal() {
        int total = 0;
        for (int i = 0; i < librosVendidos.size(); i++) {
            total += librosVendidos.get(i).getPrecioDeVenta() * cantidadesVendidas.get(i);
        }
        return total;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public int getFactura() {
        return factura;
    }

    public List<Libro> getLibrosVendidos() {
        return librosVendidos;
    }

    public List<Integer> getCantidadesVendidas() {
        return cantidadesVendidas;
    }
}
