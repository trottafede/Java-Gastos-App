package Interfaz;

import Dominio.ArchivoGrabacion;
import Dominio.ArchivoLectura;
import Dominio.Categoria;
import Dominio.Gasto;
import Dominio.Producto;
import Dominio.Sistema;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VentanaListaGastos extends javax.swing.JFrame {

    Sistema modeloSistema;

    public VentanaListaGastos(Sistema unSistema) {
        this.modeloSistema = unSistema;
        initComponents();
        this.actualizarDatos();

    }

    public void actualizarDatos() {
        //limpiar datos
        this.lblGastoCategoria.setText("0");
        this.lblGastoMesActual.setText("0");
        this.lblGastosAnuales.setText("0");

        this.lblGastosAnuales.setText(Integer.toString(modeloSistema.getGastosAnuales(2022)));

        //cargo jList de meses
        this.lstMeses.setListData(this.modeloSistema.getListaDeMeses().toArray());

        //JList MES agrego listener para click event
        this.lstMeses.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    try {
                        String c = (String) lstMeses.getSelectedValue();
                        lblGastoMesActual.setText(Integer.toString(modeloSistema.getGastoPorMes(c)));
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                }
            }
        });

        //JList categorias
        this.lstCategorias.setListData(this.modeloSistema.getListaDeCategorias().toArray());

        //JList CATEGORIAS agrego listener para click event
        this.lstCategorias.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    try {
                        Categoria c = (Categoria) lstCategorias.getSelectedValue();
                        lblGastoCategoria.setText(Integer.toString(modeloSistema.getGastoPorCategoria(c)));
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                }
            }
        });

        //cargo tabla
        Iterator<Gasto> iter = this.modeloSistema.getListaDeGastos().iterator();
        DefaultTableModel model = (DefaultTableModel) this.tablaGastos.getModel();
        model.setRowCount(0);
        while (iter.hasNext()) {
            Gasto gasto = iter.next();
            DateFormat formatter = new SimpleDateFormat("dd/MM//yyyy");

            //Datos para cargar en la JTable
            Categoria categoria = gasto.getCategoria();
            String nombre = ((Producto) gasto).getNombre(); //downcasting
            String vendor = ((Producto) gasto).getVendor();
            int precio = gasto.getPrecio();
            String fecha = formatter.format(gasto.getFecha());

            model.addRow(new Object[]{categoria, nombre, vendor, "$" + precio, fecha});
        }

        //Centro la tabla?
        JTableUtilities.setCellsAlignment(this.tablaGastos, SwingConstants.CENTER);

        //Formatear las cajas de texto para tener valores al inicio del programa
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.cajaDesde.setText(formatter.format(date)); // caja fecha con fecha del dia de hoy al iniciar
        this.cajaHasta.setText(formatter.format(date));
    }

    public class JTableUtilities {

        public static void setCellsAlignment(JTable table, int alignment) {
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(alignment);

            TableModel tableModel = table.getModel();

            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaDesde = new javax.swing.JTextField();
        cajaHasta = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstMeses = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        btnLimpiar = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblGastoMesActual = new javax.swing.JLabel();
        lblGastoCategoria = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblGastosAnuales = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrarGasto = new javax.swing.JButton();
        btnAgregarUsuario = new javax.swing.JButton();
        btnVerUsuarios = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSerializar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de gastos");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 2, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Filtros");

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        lstMeses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstMeses);

        jLabel5.setText("Mes");

        btnLimpiar.setBackground(new java.awt.Color(255, 204, 204));
        btnLimpiar.setLabel("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lstCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstCategorias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cajaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cajaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cajaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cajaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(1080, 130, 360, 390);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Nombre", "Vendor", "Precio", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGastos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaGastos);
        if (tablaGastos.getColumnModel().getColumnCount() > 0) {
            tablaGastos.getColumnModel().getColumn(0).setResizable(false);
            tablaGastos.getColumnModel().getColumn(1).setResizable(false);
            tablaGastos.getColumnModel().getColumn(2).setResizable(false);
            tablaGastos.getColumnModel().getColumn(3).setResizable(false);
            tablaGastos.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Editar");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setText("Borrar");

        jLabel3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lista de gastos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 130, 1060, 650);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Estadísticas");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Gasto mes actual:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Gasto por categoria");

        lblGastoMesActual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGastoMesActual.setText("0");

        lblGastoCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGastoCategoria.setText("0");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Gastos al año");

        lblGastosAnuales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGastosAnuales.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGastoMesActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblGastoCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGastosAnuales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblGastoMesActual))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblGastoCategoria))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblGastosAnuales))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(1080, 530, 360, 250);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(new java.awt.GridLayout(1, 5, 5, 0));

        btnRegistrarGasto.setBackground(new java.awt.Color(204, 204, 255));
        btnRegistrarGasto.setText("Registrar Gasto");
        btnRegistrarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarGastoActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegistrarGasto);

        btnAgregarUsuario.setBackground(new java.awt.Color(204, 204, 255));
        btnAgregarUsuario.setText("Agregar usuario");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregarUsuario);

        btnVerUsuarios.setBackground(new java.awt.Color(204, 204, 255));
        btnVerUsuarios.setText("Ver Usuarios");
        btnVerUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerUsuariosActionPerformed(evt);
            }
        });
        jPanel4.add(btnVerUsuarios);

        btnImportar.setText("Importar txt");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        jPanel4.add(btnImportar);

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Exportar txt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel4.add(btnActualizar);

        btnSerializar.setText("Serializar");
        btnSerializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerializarActionPerformed(evt);
            }
        });
        jPanel4.add(btnSerializar);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 1460, 90);

        setSize(new java.awt.Dimension(1469, 837));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegistrarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGastoActionPerformed
        // TODO add your handling code here:
        VentanaRegistrarGasto vrg = new VentanaRegistrarGasto(this.modeloSistema);
        vrg.setVisible(true);
    }//GEN-LAST:event_btnRegistrarGastoActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        // TODO add your handling code here:
        VentanaNuevoUsuario vnu = new VentanaNuevoUsuario(this.modeloSistema);
        vnu.setVisible(true);
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void btnVerUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerUsuariosActionPerformed
        // TODO add your handling code here:
        VentanaListaUsuarios vlu = new VentanaListaUsuarios(this.modeloSistema);
        vlu.setVisible(true);
    }//GEN-LAST:event_btnVerUsuariosActionPerformed

    private void btnSerializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerializarActionPerformed
        // TODO add your handling code here:
        this.modeloSistema.serializar();
    }//GEN-LAST:event_btnSerializarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        this.actualizarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ArchivoGrabacion ag = new ArchivoGrabacion("Gastos.txt");

        Iterator<Gasto> iter = this.modeloSistema.getListaDeGastos().iterator();

        while (iter.hasNext()) {
            Gasto sg = iter.next();

            String categoria = sg.getCategoria().getCategoria() + "#";
            String precio = sg.getPrecio() + "#";
            String fecha = sg.getFecha() + "#";
            String producto = ((Producto) sg).getNombre() + "#";
            String vendor = ((Producto) sg).getVendor() + "#";

            //categoria#precio#fecha#producto#vendor
            String linea = categoria + precio + fecha + producto + vendor;
            ag.grabarLinea(linea);
        }
        ag.cerrar();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        // TODO add your handling code here:
        ArchivoLectura al = new ArchivoLectura("Gastos.txt");

        while (al.hayMasLineas()) {
            //categoria#precio#fecha#producto#vendor
            String linea = al.linea();
            String[] lineaArre = linea.split("#");

            String categoria = lineaArre[0];
            int precio = Integer.parseInt(lineaArre[1]);
            String fecha = lineaArre[2];
            String producto = lineaArre[3];
            String vendor = lineaArre[4];

            //Registrar categoria
            Categoria nc = new Categoria(categoria);
            this.modeloSistema.getListaDeCategorias().add(nc);

            try {
                //Formateo el string fecha a date fecha
                SimpleDateFormat formato = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
                Date dateFormateada = formato.parse(fecha);
                //registrar gasto
                Gasto ng = new Producto(producto, vendor, precio, dateFormateada, nc);
                this.modeloSistema.getListaDeGastos().add(ng);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
        }
        al.cerrar();
    }//GEN-LAST:event_btnImportarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnImportar;
    private java.awt.Button btnLimpiar;
    private javax.swing.JButton btnRegistrarGasto;
    private javax.swing.JButton btnSerializar;
    private javax.swing.JButton btnVerUsuarios;
    private javax.swing.JTextField cajaDesde;
    private javax.swing.JTextField cajaHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblGastoCategoria;
    private javax.swing.JLabel lblGastoMesActual;
    private javax.swing.JLabel lblGastosAnuales;
    private javax.swing.JList lstCategorias;
    private javax.swing.JList lstMeses;
    private javax.swing.JTable tablaGastos;
    // End of variables declaration//GEN-END:variables
}
