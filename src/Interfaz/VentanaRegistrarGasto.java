package Interfaz;

import Dominio.Categoria;
import Dominio.Gasto;
import Dominio.Producto;
import Dominio.Sistema;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentanaRegistrarGasto extends javax.swing.JFrame {

    Sistema modeloSistema;

    public VentanaRegistrarGasto(Sistema unSistema) {
        this.modeloSistema = unSistema;
        initComponents();

        //cargo la lista de categorias actuales
        this.cargarDatos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cajaFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cajaPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cajaVendor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cajaProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarGasto = new java.awt.Button();
        cajaCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList();
        btnAgregar = new java.awt.Button();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar gasto");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Gasto");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 10, 470, 50);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setText("Categoria");

        jLabel4.setText("Fecha");

        cajaPrecio.setText("0");

        jLabel2.setText("Precio ($)");

        jLabel5.setText("Vendor");

        jLabel1.setText("Producto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cajaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cajaVendor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cajaPrecio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(cajaFecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cajaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cajaVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cajaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cajaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 70, 360, 300);

        btnRegistrarGasto.setBackground(new java.awt.Color(204, 204, 255));
        btnRegistrarGasto.setLabel("Registrar gasto");
        btnRegistrarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarGastoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarGasto);
        btnRegistrarGasto.setBounds(300, 380, 120, 30);
        getContentPane().add(cajaCategoria);
        cajaCategoria.setBounds(450, 110, 200, 30);

        lstCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCategorias.setToolTipText("");
        jScrollPane1.setViewportView(lstCategorias);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(450, 160, 210, 200);

        btnAgregar.setBackground(new java.awt.Color(204, 204, 255));
        btnAgregar.setLabel("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(530, 380, 130, 30);

        jLabel7.setText("Categoría");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(450, 70, 80, 30);

        setSize(new java.awt.Dimension(707, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGastoActionPerformed
        try {
            // TODO add your handling code here:

            String producto = this.cajaProducto.getText();
            String vendor = this.cajaVendor.getText();
            int precio = Integer.parseInt(this.cajaPrecio.getText());
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(this.cajaFecha.getText());
            Categoria categoria = (Categoria) this.comboCategoria.getSelectedItem();

            //Creo mi nuevo gasto y lo agrego a sistema
            Gasto g = new Producto(producto, vendor, precio, fecha, categoria);
            this.modeloSistema.getListaDeGastos().add(g);
            JOptionPane.showMessageDialog(null, "Se registró nuevo gasto", "Nuevo gasto", JOptionPane.INFORMATION_MESSAGE);

        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnRegistrarGastoActionPerformed

    public void cargarDatos() {
        //limpiar toda la info de los componentes
        this.lstCategorias.clearSelection();
        this.comboCategoria.removeAllItems();
        this.lstCategorias.clearSelection();
        this.cajaCategoria.setText("");

        //Cargo list de categorias
        this.lstCategorias.setListData(this.modeloSistema.getListaDeCategorias().toArray());

        //Cargo jComboBox de categoria
        Iterator<Categoria> iter = this.modeloSistema.getListaDeCategorias().iterator();

        while (iter.hasNext()) {
            Categoria c = iter.next();
            this.comboCategoria.addItem(c);
        }

        //Formatear las cajas de texto para tener valores al inicio del programa
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.cajaFecha.setText(formatter.format(date)); // caja fecha con fecha del dia de hoy al iniciar

    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String nuevaCategoria = this.cajaCategoria.getText();

        //Creo mi nueva categoria y la agrego a sistema
        Categoria c = new Categoria(nuevaCategoria);
        this.modeloSistema.getListaDeCategorias().add(c);

        //mando mensaje
        JOptionPane.showMessageDialog(null, "Se creó correctamente la categoría", "Nueva categoría", JOptionPane.INFORMATION_MESSAGE);
        this.cargarDatos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnAgregar;
    private java.awt.Button btnRegistrarGasto;
    private javax.swing.JTextField cajaCategoria;
    private javax.swing.JTextField cajaFecha;
    private javax.swing.JTextField cajaPrecio;
    private javax.swing.JTextField cajaProducto;
    private javax.swing.JTextField cajaVendor;
    private javax.swing.JComboBox<Categoria> comboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstCategorias;
    // End of variables declaration//GEN-END:variables
}
