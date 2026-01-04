 //Matias Regalo 308940 | Juan Constantin 335718
package interfaz;

import dominio.*;
import java.io.PrintWriter;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class consultarVenta extends javax.swing.JFrame implements Observer{
    private final Sistema modelo;

    /**
     * Creates new form ventanaConsultaLibro
     * @param unSistema
     */
    public consultarVenta(Sistema unSistema) {
       modelo = unSistema;
       initComponents();
       setLocationRelativeTo(null);
       configurarTabla(); // Configurar títulos de la tabla
       objetoAPantalla(); // Limpiar y preparar los campos
       modelo.addObserver(this);
   }



private void objetoAPantalla() {
    // Limpia el campo ISBN
    txtIsbn.setText("");

    // Limpia los resúmenes
    lblVendidos.setText("nroVendidos");
    lblRecaudado.setText("nroRecaudado");
    lblGanancia.setText("nroGanancia");

    // Limpia la tabla
    DefaultTableModel modeloTabla = (DefaultTableModel) tablaLibros.getModel();
    modeloTabla.setRowCount(0);

    // Limpia el título
    lblTitulo.setText("titulo del libro");
}

    @Override
    public void update(Observable o, Object ob){
         objetoAPantalla();
    }
    
    private void configurarTabla() {
        // Define los nuevos títulos de las columnas
        String[] columnas = {"Fecha", "Cliente", "Factura", "Cantidad", "Precio", "Importe"};

        // Crea un modelo de tabla con los títulos
        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);

        // Asigna el modelo a la tabla
        tablaLibros.setModel(modeloTabla);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        lblISBN = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        lblEjemplares = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTGanancia = new javax.swing.JLabel();
        lblVendidos = new javax.swing.JLabel();
        lblRecaudado = new javax.swing.JLabel();
        lblGanancia = new javax.swing.JLabel();
        btnAyudaIdentificar = new javax.swing.JButton();
        lblAnularFactura = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Ventas");
        setLocation(new java.awt.Point(500, 150));
        setPreferredSize(new java.awt.Dimension(958, 800));

        pnl1.setPreferredSize(new java.awt.Dimension(958, 800));
        pnl1.setLayout(null);

        lblISBN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblISBN.setText("Isbn:");
        pnl1.add(lblISBN);
        lblISBN.setBounds(60, 140, 90, 40);
        pnl1.add(txtIsbn);
        txtIsbn.setBounds(110, 140, 210, 40);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnl1.add(btnConsultar);
        btnConsultar.setBounds(430, 140, 140, 40);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        pnl1.add(btnExportar);
        btnExportar.setBounds(600, 140, 140, 40);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 255));
        lblTitulo.setText("titulo del libro");
        pnl1.add(lblTitulo);
        lblTitulo.setBounds(110, 220, 330, 60);

        tablaLibros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaLibros);

        pnl1.add(jScrollPane1);
        jScrollPane1.setBounds(110, 270, 750, 320);

        lblEjemplares.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEjemplares.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEjemplares.setText("Ejemplares Vendidos");
        lblEjemplares.setToolTipText("");
        pnl1.add(lblEjemplares);
        lblEjemplares.setBounds(0, 630, 320, 25);

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("Total Recaudado");
        pnl1.add(lblTotal);
        lblTotal.setBounds(320, 630, 320, 25);

        lblTGanancia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTGanancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTGanancia.setText("Total Ganancia");
        pnl1.add(lblTGanancia);
        lblTGanancia.setBounds(640, 630, 320, 25);

        lblVendidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVendidos.setForeground(new java.awt.Color(0, 0, 204));
        lblVendidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVendidos.setText("nroVendidos");
        pnl1.add(lblVendidos);
        lblVendidos.setBounds(0, 670, 320, 20);

        lblRecaudado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRecaudado.setForeground(new java.awt.Color(0, 0, 204));
        lblRecaudado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecaudado.setText("nroRecaudado");
        pnl1.add(lblRecaudado);
        lblRecaudado.setBounds(320, 670, 320, 20);

        lblGanancia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGanancia.setForeground(new java.awt.Color(0, 0, 204));
        lblGanancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGanancia.setText("nroGanancia");
        pnl1.add(lblGanancia);
        lblGanancia.setBounds(640, 670, 320, 20);

        btnAyudaIdentificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAyudaIdentificar.setText("...");
        btnAyudaIdentificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaIdentificarActionPerformed(evt);
            }
        });
        pnl1.add(btnAyudaIdentificar);
        btnAyudaIdentificar.setBounds(330, 140, 70, 40);

        lblAnularFactura.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblAnularFactura.setText("Consultar Venta");
        lblAnularFactura.setMaximumSize(new java.awt.Dimension(111, 150));
        lblAnularFactura.setMinimumSize(new java.awt.Dimension(111, 16));
        lblAnularFactura.setName(""); // NOI18N
        lblAnularFactura.setPreferredSize(new java.awt.Dimension(233, 48));
        pnl1.add(lblAnularFactura);
        lblAnularFactura.setBounds(39, 26, 280, 48);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnl1.add(btnCancelar);
        btnCancelar.setBounds(770, 140, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAyudaIdentificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaIdentificarActionPerformed
        if (frameAuxiliar == null || !frameAuxiliar.isVisible()) {
            mostrarListaLibros(); // Mostrar la lista si no está visible
        } else {
            ocultarListaLibros(); // Ocultar la lista si ya está visible
        }
    }//GEN-LAST:event_btnAyudaIdentificarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        // Verificar si la tabla tiene datos
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaLibros.getModel();
        if (modeloTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay datos para exportar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ruta del archivo
        String filePath = "VENTAS.CSV";

        try (PrintWriter writer = new PrintWriter(filePath)) {
            // Escribir los títulos de las columnas
            writer.println("Fecha;Cliente;Factura;Cantidad;Precio;Importe");

            // Escribir las filas de la tabla
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                    row.append(modeloTabla.getValueAt(i, j).toString());
                    if (j < modeloTabla.getColumnCount() - 1) {
                        row.append(";");
                    }
                }
                writer.println(row.toString());
            }

            JOptionPane.showMessageDialog(this, "Datos exportados exitosamente a " + filePath, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al exportar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // Obtén el ISBN ingresado en el campo de texto
        String isbn = txtIsbn.getText().trim();

        // Verifica que no esté vacío
        if (isbn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtén las ventas relacionadas al ISBN
        List<Venta> ventas = modelo.getVentasPorISBN(isbn);

        // Verifica si hay ventas para este ISBN
        if (ventas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron ventas para el ISBN ingresado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Actualizar el lblTitulo con el título del libro correspondiente al ISBN
        Libro libro = modelo.getLibroPorISBN(isbn);
        if (libro != null) {
            lblTitulo.setText(libro.getTitulo());
        } else {
            lblTitulo.setText("Libro no encontrado");
        }

        // Ordena las ventas por número de factura en orden decreciente
        ventas.sort((v1, v2) -> Integer.compare(v2.getFactura(), v1.getFactura()));

        // Limpia la tabla antes de agregar los datos
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaLibros.getModel();
        modeloTabla.setRowCount(0);

        // Variables para los resúmenes
        int totalVendidos = 0;
        int totalRecaudado = 0;
        int totalGanancia = 0;

        // Itera sobre las ventas y agrega las filas a la tabla
        for (Venta venta : ventas) {
            for (int i = 0; i < venta.getLibrosVendidos().size(); i++) {
                Libro libroEnVenta = venta.getLibrosVendidos().get(i);

                // Verificar que el libro en la venta coincida con el ISBN ingresado
                if (!libroEnVenta.getIsbn().equals(isbn)) {
                    continue; // Si no coincide, pasa al siguiente libro
                }

                int cantidad = venta.getCantidadesVendidas().get(i);
                int precio = libroEnVenta.getPrecioDeVenta();
                int importe = cantidad * precio;
                int ganancia = (precio - libroEnVenta.getPrecioDeCosto()) * cantidad;

                // Actualiza los resúmenes
                totalVendidos += cantidad;
                totalRecaudado += importe;
                totalGanancia += ganancia;

                // Agrega una fila a la tabla
                modeloTabla.addRow(new Object[]{
                    venta.getFecha(),
                    venta.getNombreDelCliente(),
                    venta.getFactura(),
                    cantidad,
                    precio,
                    importe
                });
            }
        }

        // Actualiza los resúmenes en los labels
        lblVendidos.setText(String.valueOf(totalVendidos));
        lblRecaudado.setText("$" + totalRecaudado);
        lblGanancia.setText("$" + totalGanancia);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

private boolean panelVisible = false; // Variable para manejar la visibilidad del panel
private JFrame frameAuxiliar; // Ventana auxiliar para mostrar la lista    
    
    
    
    private void mostrarListaLibros() {
       frameAuxiliar = new JFrame("Lista de Libros");
       frameAuxiliar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frameAuxiliar.setLayout(new BoxLayout(frameAuxiliar.getContentPane(), BoxLayout.Y_AXIS));

       // Crear un botón para cerrar la ventana
       JButton btnCerrar = new JButton("Cerrar");
       btnCerrar.addActionListener(e -> ocultarListaLibros());
       frameAuxiliar.add(btnCerrar);

       // Crear la lista de libros
       List<Libro> listaLibros = modelo.getListaLibros();
       DefaultListModel<String> modeloLista = new DefaultListModel<>();
       for (Libro libro : listaLibros) {
           modeloLista.addElement(libro.getIsbn() + " - " + libro.getTitulo());
       }

       JList<String> lista = new JList<>(modeloLista);
       lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       lista.addListSelectionListener(e -> {
           if (!e.getValueIsAdjusting()) {
               String seleccion = lista.getSelectedValue();
               if (seleccion != null) {
                   // Obtener el ISBN seleccionado
                   String isbnSeleccionado = seleccion.split(" - ")[0];

                   // Copiar el ISBN al campo de texto y ocultar la ventana
                   txtIsbn.setText(isbnSeleccionado);
                   ocultarListaLibros();

                   // Ejecutar la consulta automáticamente
                   btnConsultarActionPerformed(null);
               }
           }
       });

       JScrollPane scrollPane = new JScrollPane(lista);
       frameAuxiliar.add(scrollPane);

       frameAuxiliar.setSize(300, 400);
       frameAuxiliar.setLocationRelativeTo(this);
       frameAuxiliar.setVisible(true);
    }
    
    
    private void ocultarListaLibros() {
         if (frameAuxiliar != null) {
            frameAuxiliar.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyudaIdentificar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnularFactura;
    private javax.swing.JLabel lblEjemplares;
    private javax.swing.JLabel lblGanancia;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblRecaudado;
    private javax.swing.JLabel lblTGanancia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendidos;
    private javax.swing.JPanel pnl1;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtIsbn;
    // End of variables declaration//GEN-END:variables
}
