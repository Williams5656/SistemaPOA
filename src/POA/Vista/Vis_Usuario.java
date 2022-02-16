/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Renato Llivisaca
 */
public class Vis_Usuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vis_Usuario
     */
    public Vis_Usuario() {
        initComponents();
    }

    public JButton getBtnbuscar() {
        return btnbuscar;
    }

    public void setBtnbuscar(JButton btnbuscar) {
        this.btnbuscar = btnbuscar;
    }

    public JButton getBtneliminar() {
        return btneliminar;
    }

    public void setBtneliminar(JButton btneliminar) {
        this.btneliminar = btneliminar;
    }

    public JButton getBtnguardar() {
        return btnguardar;
    }

    public void setBtnguardar(JButton btnguardar) {
        this.btnguardar = btnguardar;
    }

    public JButton getBtnimprimir() {
        return btnimprimir;
    }

    public void setBtnimprimir(JButton btnimprimir) {
        this.btnimprimir = btnimprimir;
    }

    public JButton getBtnmodificar() {
        return btnmodificar;
    }

    public void setBtnmodificar(JButton btnmodificar) {
        this.btnmodificar = btnmodificar;
    }

    public JButton getBtnnuevo() {
        return btnnuevo;
    }

    public void setBtnnuevo(JButton btnnuevo) {
        this.btnnuevo = btnnuevo;
    }

    public JTextField getTxtContrasenia() {
        return txtContrasenia;
    }

    public void setTxtContrasenia(JTextField txtContrasenia) {
        this.txtContrasenia = txtContrasenia;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    public JTable getTableUsuario() {
        return tableUsuario;
    }

    public void setTableUsuario(JTable tableUsuario) {
        this.tableUsuario = tableUsuario;
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnmodificar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        txtcedula = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setText("Cedula:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 50, 30));

        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, 30));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 140, 30));

        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, 30));
        getContentPane().add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 140, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        tableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Usuario", "Contraseña"
            }
        ));
        jScrollPane1.setViewportView(tableUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 450, 210));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/buscar (2).png"))); // NOI18N
        btnbuscar.setText("Buscar");
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 40));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 160, 40));

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/impresion.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 470, 60));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btnmodificar.setText("Modificar");
        jPanel2.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/WhatsApp Image 2022-02-15 at 00.32.29.jpeg"))); // NOI18N
        btneliminar.setText("Eliminar");
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 470, 60));
        getContentPane().add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 140, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 10, 360));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/My project.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
    }//GEN-LAST:event_btnimprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableUsuario;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtcedula;
    // End of variables declaration//GEN-END:variables
}
