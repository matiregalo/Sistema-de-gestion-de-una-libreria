//Matias Regalo 308940 | Juan Constantin 335718
package interfaz;
import dominio.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
//NUEVO
public class registrarVenta extends javax.swing.JFrame implements Observer{
    private Sistema modelo;
    private List<Libro> librosEnVenta = new ArrayList<>();
    private List<Integer> cantidadesEnVenta = new ArrayList<>();
    private int totalVenta = 0;

    public registrarVenta(Sistema unSistema) {
        modelo = unSistema;
        initComponents();
        modelo.addObserver(this);
        setLocationRelativeTo(null);
        lblFactura.setText("Factura: " + modelo.obtenerFacturaActual());
        cargarLibrosEnStock();
   }


    private void cargarLibrosEnStock() {
       List<Libro> librosEnStock = modelo.getListaLibros();
       librosEnStock.sort(Comparator.comparing(Libro::getTitulo));

       DefaultListModel<String> modeloListaStock = new DefaultListModel<>();
       for (Libro libro : librosEnStock) {
           modeloListaStock.addElement(libro.getIsbn() + " - " + libro.getTitulo());
       }

       lstLibrosEnStock.setModel(modeloListaStock);
   }

    
        private void actualizarListaLibrosEnVenta() {
        DefaultListModel<String> modeloListaVenta = new DefaultListModel<>();

        for (int i = 0; i < librosEnVenta.size(); i++) {
            Libro libro = librosEnVenta.get(i);
            int cantidad = cantidadesEnVenta.get(i);
            int precioUnitario = libro.getPrecioDeVenta();
            modeloListaVenta.addElement(cantidad + " - " + libro.getTitulo() + " - $" + precioUnitario);
        }

        lstLibrosEnVenta.setModel(modeloListaVenta);
    }

    private void actualizarTotalVenta() {
        totalVenta = 0;

        for (int i = 0; i < librosEnVenta.size(); i++) {
            int cantidad = cantidadesEnVenta.get(i);
            int precioUnitario = librosEnVenta.get(i).getPrecioDeVenta();
            totalVenta += cantidad * precioUnitario;
        }

        lblTotal.setText("Total: $" + totalVenta);
    }

@Override
public void update(Observable o, Object arg) {
    cargarLibrosEnStock();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFactura = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAumentar = new javax.swing.JButton();
        btnDisminuir = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLibrosEnVenta = new javax.swing.JList<>();
        lstVenta = new javax.swing.JScrollPane();
        lstLibrosEnStock = new javax.swing.JList<>();
        lblLstLibro = new javax.swing.JLabel();
        lblLstVenta = new javax.swing.JLabel();
        lblRegistrarVenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venta de Libros");
        setLocation(new java.awt.Point(500, 150));
        setPreferredSize(new java.awt.Dimension(958, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(958, 800));
        jPanel1.setLayout(null);

        lblFactura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFactura.setText("Nº Factura:");
        jPanel1.add(lblFactura);
        lblFactura.setBounds(60, 80, 230, 20);

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setText("Fecha: ");
        jPanel1.add(lblFecha);
        lblFecha.setBounds(60, 110, 110, 20);

        txtFecha.setText("dia/mes/año");
        jPanel1.add(txtFecha);
        txtFecha.setBounds(120, 110, 270, 22);
        jPanel1.add(txtCliente);
        txtCliente.setBounds(120, 140, 270, 22);

        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente.setText("Cliente:");
        jPanel1.add(lblCliente);
        lblCliente.setBounds(60, 140, 90, 20);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar);
        btnRegistrar.setBounds(590, 710, 140, 30);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(760, 710, 140, 30);

        btnAumentar.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        btnAumentar.setText("->");
        btnAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAumentar);
        btnAumentar.setBounds(410, 340, 140, 30);

        btnDisminuir.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        btnDisminuir.setText("<-");
        btnDisminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisminuirActionPerformed(evt);
            }
        });
        jPanel1.add(btnDisminuir);
        btnDisminuir.setBounds(410, 410, 140, 30);

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText("Total: $");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(380, 640, 350, 30);

        jScrollPane1.setViewportView(lstLibrosEnVenta);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(570, 200, 320, 420);

        lstLibrosEnStock.setPreferredSize(new java.awt.Dimension(200, 200));
        lstVenta.setViewportView(lstLibrosEnStock);

        jPanel1.add(lstVenta);
        lstVenta.setBounds(60, 200, 330, 410);

        lblLstLibro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLstLibro.setText("Libros");
        jPanel1.add(lblLstLibro);
        lblLstLibro.setBounds(60, 170, 50, 20);

        lblLstVenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLstVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLstVenta.setText("Ventas");
        jPanel1.add(lblLstVenta);
        lblLstVenta.setBounds(570, 170, 60, 20);

        lblRegistrarVenta.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblRegistrarVenta.setText("Registrar Ventas");
        lblRegistrarVenta.setPreferredSize(new java.awt.Dimension(233, 48));
        jPanel1.add(lblRegistrarVenta);
        lblRegistrarVenta.setBounds(39, 26, 270, 48);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarActionPerformed
         String seleccion = lstLibrosEnStock.getSelectedValue();

        if (seleccion != null) {
            String isbnSeleccionado = seleccion.split(" - ")[0];
            Libro libroSeleccionado = modelo.getLibroPorISBN(isbnSeleccionado);

            if (libroSeleccionado != null) {
                if (librosEnVenta.contains(libroSeleccionado)) {
                    int index = librosEnVenta.indexOf(libroSeleccionado);
                    cantidadesEnVenta.set(index, cantidadesEnVenta.get(index) + 1);
                } else {
                    librosEnVenta.add(libroSeleccionado);
                    cantidadesEnVenta.add(1);
                }

                actualizarListaLibrosEnVenta();
                actualizarTotalVenta();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Libro no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un libro para agregar a la venta.");
        }
    }//GEN-LAST:event_btnAumentarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
if (librosEnVenta.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay libros seleccionados para la venta.");
        return;
    }

    String fecha = txtFecha.getText();
    String cliente = txtCliente.getText();
    boolean ventaValida = false;

    // Validar stock y ajustar cantidades
    for (int i = 0; i < librosEnVenta.size(); i++) {
        Libro libro = librosEnVenta.get(i);
        int cantidadVendida = cantidadesEnVenta.get(i);

        if (libro.getStock() < cantidadVendida) {
            if (libro.getStock() > 0) {
                cantidadesEnVenta.set(i, libro.getStock()); // Ajusta a la cantidad disponible
                libro.setStock(0); // Sin stock restante
                ventaValida = true;
            } else {
                librosEnVenta.remove(i); // Eliminar el libro de la lista de venta
                cantidadesEnVenta.remove(i);
                i--; // Ajustar el índice tras eliminación
            }
        } else {
            libro.setStock(libro.getStock() - cantidadVendida); // Descontar stock
            ventaValida = true;
        }
    }

    if (!ventaValida) {
        JOptionPane.showMessageDialog(this, "Sin stock suficiente para realizar la venta.");
        return;
    }

    // Registrar la venta con los datos completos
    Venta nuevaVenta = modelo.registrarVenta(fecha, cliente, librosEnVenta, cantidadesEnVenta);

      JOptionPane.showMessageDialog(this, "Venta registrada exitosamente."
            + "\nSe vendieron: "+ cantidadesEnVenta + " \nTotal: $" + nuevaVenta.calcularTotal());
      
    // Actualizar la interfaz
    lblFactura.setText("Nº Factura: " + modelo.obtenerFacturaActual());
    lblTotal.setText("Total: $0");
    librosEnVenta.clear();
    cantidadesEnVenta.clear();
    cargarLibrosEnStock();
    actualizarListaLibrosEnVenta();
    txtFecha.setText("dia/mes/año");
    txtCliente.setText("");
  
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnDisminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisminuirActionPerformed
        int index = lstLibrosEnVenta.getSelectedIndex();

        if (index != -1) {
            int cantidad = cantidadesEnVenta.get(index);

            if (cantidad > 1) {
                cantidadesEnVenta.set(index, cantidad - 1);
            } else {
                librosEnVenta.remove(index);
                cantidadesEnVenta.remove(index);
            }

            actualizarListaLibrosEnVenta();
            actualizarTotalVenta();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un libro para eliminar de la venta.");
        }
    }//GEN-LAST:event_btnDisminuirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAumentar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDisminuir;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFactura;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLstLibro;
    private javax.swing.JLabel lblLstVenta;
    private javax.swing.JLabel lblRegistrarVenta;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<String> lstLibrosEnStock;
    private javax.swing.JList<String> lstLibrosEnVenta;
    private javax.swing.JScrollPane lstVenta;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}


