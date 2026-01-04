 //Matias Regalo 308940 | Juan Constantin 335718
package interfaz;

import dominio.*;
import java.util.*;
import javax.swing.JOptionPane;

public class anularFactura extends javax.swing.JFrame implements Observer {
    private Sistema modelo;

    public anularFactura (Sistema unSistema) {
        modelo = unSistema;
        initComponents();
        objetoAPantalla();
        setLocationRelativeTo(null);
        modelo.addObserver(this);
    }
    
    public void update(Observable o, Object ob){
         objetoAPantalla();
    }
    
    private void objetoAPantalla(){
        txtFactura.setText("");

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        lblFactura = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        txtFactura = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        lblAnularFactura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Anular Factura");
        setLocation(new java.awt.Point(500, 150));
        setPreferredSize(new java.awt.Dimension(958, 800));

        pnl1.setPreferredSize(new java.awt.Dimension(959, 800));
        pnl1.setLayout(null);

        lblFactura.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblFactura.setText("Número Factura:");
        pnl1.add(lblFactura);
        lblFactura.setBounds(50, 180, 210, 80);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        btnBuscar.setText("BUSCAR FACTURA");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnl1.add(btnBuscar);
        btnBuscar.setBounds(19, 430, 294, 160);

        btnAnular.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        btnAnular.setText("ANULAR FACTURA");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        pnl1.add(btnAnular);
        btnAnular.setBounds(332, 430, 294, 160);

        txtFactura.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pnl1.add(txtFactura);
        txtFactura.setBounds(240, 170, 540, 110);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnl1.add(btnCancelar);
        btnCancelar.setBounds(651, 430, 274, 160);

        lblAnularFactura.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblAnularFactura.setText("Anular Factura");
        lblAnularFactura.setMaximumSize(new java.awt.Dimension(111, 150));
        lblAnularFactura.setMinimumSize(new java.awt.Dimension(111, 16));
        lblAnularFactura.setName(""); // NOI18N
        lblAnularFactura.setPreferredSize(new java.awt.Dimension(233, 48));
        pnl1.add(lblAnularFactura);
        lblAnularFactura.setBounds(39, 26, 233, 48);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    String inputFactura = txtFactura.getText().trim();

    if (inputFactura.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de factura.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int numeroFactura;
    try {
        numeroFactura = Integer.parseInt(inputFactura);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El número de factura debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Venta venta = modelo.getVentaPorNumeroFactura(numeroFactura);

    if (venta == null) {
        JOptionPane.showMessageDialog(this, "No se encontró la factura con número " + numeroFactura + ".", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Mostrar detalles de la factura
        String detallesFactura = "Factura N°: " + venta.getFactura() + "\n"
                + "Fecha: " + venta.getFecha() + "\n"
                + "Cliente: " + (venta.getNombreDelCliente().isEmpty() ? "Sin especificar" : venta.getNombreDelCliente()) + "\n\n"
                + "Libros vendidos:\n";

        List<Libro> libros = venta.getLibrosVendidos();
        List<Integer> cantidades = venta.getCantidadesVendidas();
        int totalFactura = 0;

        for (int i = 0; i < libros.size(); i++) {
            int subtotal = libros.get(i).getPrecioDeVenta() * cantidades.get(i);
            totalFactura += subtotal;

            detallesFactura += "- Título: " + libros.get(i).getTitulo() 
                             + " | Cantidad: " + cantidades.get(i) 
                             + " | Subtotal: $" + subtotal + "\n";
        }

        detallesFactura += "\nTotal: $" + totalFactura;

        JOptionPane.showMessageDialog(this, detallesFactura, "Detalles de Factura", JOptionPane.INFORMATION_MESSAGE);
    }   
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
            String inputFactura = txtFactura.getText().trim();

    if (inputFactura.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de factura para anular.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int numeroFactura;
    try {
        numeroFactura = Integer.parseInt(inputFactura);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El número de factura debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Buscar la venta correspondiente en el sistema
    Venta venta = modelo.getVentaPorNumeroFactura(numeroFactura);

    if (venta == null) {
        JOptionPane.showMessageDialog(this, "No se encontró la factura con número " + numeroFactura + ".", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Confirmar la acción del usuario
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea anular esta factura?", "Confirmar Anulación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Devolver libros al stock
            List<Libro> libros = venta.getLibrosVendidos();
            List<Integer> cantidades = venta.getCantidadesVendidas();

            for (int i = 0; i < libros.size(); i++) {
                Libro libro = libros.get(i);
                int cantidadVendida = cantidades.get(i);
                libro.setStock(libro.getStock() + cantidadVendida); // Incrementar stock
            }

            // Eliminar la factura del sistema
            modelo.eliminarVenta(numeroFactura);

            JOptionPane.showMessageDialog(this, "Factura anulada con éxito. Libros devueltos al stock.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Actualizar la pantalla
            objetoAPantalla();
        }
    }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblAnularFactura;
    private javax.swing.JLabel lblFactura;
    private javax.swing.JPanel pnl1;
    private javax.swing.JTextField txtFactura;
    // End of variables declaration//GEN-END:variables
}
