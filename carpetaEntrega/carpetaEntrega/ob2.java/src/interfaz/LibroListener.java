 //Matias Regalo 308940 | Juan Constantin 335718
package interfaz;
import dominio.Libro;
import java.awt.event.*;
import java.awt.*;
 import javax.swing.*;
/**
 *
 * @author c
 */
public class LibroListener implements ActionListener{
            private Libro libro;
   public LibroListener(Libro libro) {
            this.libro = libro;
        }

public void actionPerformed(ActionEvent e) {
// este código se ejecutará al presionar el botón, obtengo cuál botón
JButton cual = ((JButton) e.getSource());
// código a completar según el botón presionado
if (libro != null) {
            JOptionPane.showMessageDialog(
                cual, // El botón como componente padre del mensaje
                "Título: " + libro.getTitulo() + "\n" +
                "Autor: " + libro.getAutor() + "\n" +
                "Género: " + libro.getGenero() + "\n" +
                "Editorial: " + libro.getEditorial() + "\n" +
                "Precio de venta: $" + libro.getPrecioDeVenta() + "\n" +
                "Stock: " + libro.getStock() + " unidades\n" +
                "Precio de costo: $" + libro.getPrecioDeCosto() + "\n" +
                "ISBN: " + libro.getIsbn(),
                "Detalles del Libro",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                cual,
                "No se encontró información del libro.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}



