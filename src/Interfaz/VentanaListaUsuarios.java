package Interfaz;

import Dominio.Sistema;
import Dominio.Usuario;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class VentanaListaUsuarios extends javax.swing.JFrame {

    Sistema modeloSistema;

    public VentanaListaUsuarios(Sistema unSistema) {
        this.modeloSistema = unSistema;
        initComponents();
        this.lstUsuarios.setListData(this.modeloSistema.getListaDeUsuarios().toArray());

        //cargo tabla
        Iterator<Usuario> iter = this.modeloSistema.getListaDeUsuarios().iterator();
        DefaultTableModel model = (DefaultTableModel) this.tablaUsuarios.getModel();

        while (iter.hasNext()) {
            Usuario user = iter.next();
            model.addRow(new Object[]{user.getNombre(), user.getPassword(), user.isAdmin()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Usuarios");
        setResizable(false);
        getContentPane().setLayout(null);

        lstUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 210, 200);

        jLabel3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lista de usuarios");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 20, 470, 50);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setText("Borrar");
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 320, 110, 25);

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Editar");
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 360, 110, 25);

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Password", "Admin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.setColumnSelectionAllowed(true);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaUsuarios);
        tablaUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaUsuarios.getColumnModel().getColumnCount() > 0) {
            tablaUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(230, 90, 250, 200);

        jButton3.setText("Admin");
        getContentPane().add(jButton3);
        jButton3.setBounds(160, 320, 110, 25);

        jButton4.setText("No admin");
        getContentPane().add(jButton4);
        jButton4.setBounds(160, 360, 110, 25);

        setSize(new java.awt.Dimension(505, 457));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstUsuarios;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
