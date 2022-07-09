package Interfaz;

import Dominio.Sistema;
import Dominio.Usuario;
import javax.swing.JOptionPane;

public class VentanaNuevoUsuario extends javax.swing.JFrame {

    private Sistema modeloSistema;

    public VentanaNuevoUsuario(Sistema unSistema) {
        this.modeloSistema = unSistema;

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaUser = new javax.swing.JTextField();
        cajaPassword = new javax.swing.JPasswordField();
        btnCrearUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear usuario");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

        jLabel1.setText("User");

        jLabel2.setText("Password");

        cajaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaUserActionPerformed(evt);
            }
        });

        cajaPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnCrearUser.setBackground(new java.awt.Color(204, 204, 255));
        btnCrearUser.setText("Crear usuario");
        btnCrearUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cajaPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(cajaUser))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cajaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cajaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 110, 360, 230);

        jLabel3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nuevo Usuario");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 40, 366, 50);

        setSize(new java.awt.Dimension(505, 431));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean validarInputs(String username, String password) {

        boolean userNameInvalido = username.length() < 4 || username.length() > 10;
        boolean passwordInvalida = password.length() < 4 || password.length() > 10;
        boolean resultado = !userNameInvalido && !passwordInvalida;

        if (userNameInvalido) {
            String mensaje
                    = "Por favor, ingrese un nombre válido" + "\n"
                    + "Carácteres minimos: 4" + "\n"
                    + "Carácteres máximos: 10";
            JOptionPane.showMessageDialog(null, mensaje, "Nombre inválido", JOptionPane.ERROR_MESSAGE);
            this.cajaUser.requestFocus();
        }

        if (passwordInvalida) {
            String mensaje
                    = "Por favor, ingrese una contraseña válida" + "\n"
                    + "Carácteres minimos: 4" + "\n"
                    + "Carácteres máximos: 10";
            JOptionPane.showMessageDialog(null, mensaje, "Contraseña inválido", JOptionPane.ERROR_MESSAGE);
            this.cajaPassword.requestFocus();
        }

        return resultado;
    }

    private void btnCrearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUserActionPerformed
        // TODO add your handling code here:

        // Logeo al usuario si existe y sus credenciales coinciden
        // Sino tiro un mensaje de error diciendo que algo salio mal
        String username = this.cajaUser.getText();
        String password = this.cajaPassword.getText();

        if (this.validarInputs(username, password)) {
            Usuario u = new Usuario(username, password);

            boolean esNuevoRegistro = this.modeloSistema.agregarUsuario(u);

            if (esNuevoRegistro) {
                JOptionPane.showMessageDialog(null, "Registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                //mostrar ventana principal
                VentanaListaGastos vm = new VentanaListaGastos(this.modeloSistema);
                vm.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya se encuentra", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnCrearUserActionPerformed

    private void cajaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUser;
    private javax.swing.JPasswordField cajaPassword;
    private javax.swing.JTextField cajaUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
