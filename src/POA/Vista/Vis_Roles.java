
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Myrian
 */
public class Vis_Roles extends javax.swing.JInternalFrame {

    /**
     * Creates new form vista_roles
     */
    public Vis_Roles() {
        initComponents();
    }

    public JButton getBtn_editar() {
        return btn_editar;
    }

    public void setBtn_editar(JButton btn_editar) {
        this.btn_editar = btn_editar;
    }

    public JButton getBtn_editar_permiso() {
        return btn_editar_permiso;
    }

    public void setBtn_editar_permiso(JButton btn_editar_permiso) {
        this.btn_editar_permiso = btn_editar_permiso;
    }

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JButton getBtn_guardar_rol() {
        return btn_guardar_rol;
    }

    public void setBtn_guardar_rol(JButton btn_guardar_rol) {
        this.btn_guardar_rol = btn_guardar_rol;
    }

    public JButton getBtn_ingresar() {
        return btn_ingresar;
    }

    public void setBtn_ingresar(JButton btn_ingresar) {
        this.btn_ingresar = btn_ingresar;
    }

    public JButton getBtn_ver_permiso() {
        return btn_ver_permiso;
    }

    public void setBtn_ver_permiso(JButton btn_ver_permiso) {
        this.btn_ver_permiso = btn_ver_permiso;
    }

    public JTable getTabla_rol() {
        return tabla_rol;
    }

    public void setTabla_rol(JTable tabla_rol) {
        this.tabla_rol = tabla_rol;
    }

    public JTextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
    }

    public JTextField getTxt_nombrerol() {
        return txt_nombrerol;
    }

    public void setTxt_nombrerol(JTextField txt_nombrerol) {
        this.txt_nombrerol = txt_nombrerol;
    }

    public JTextField getTxt_numero() {
        return txt_numero;
    }

    public void setTxt_numero(JTextField txt_numero) {
        this.txt_numero = txt_numero;
    }

    public JTextField getTxt_rol() {
        return txt_rol;
    }

    public void setTxt_rol(JTextField txt_rol) {
        this.txt_rol = txt_rol;
    }

    public JDialog getVista_NuevoRol() {
        return vista_NuevoRol;
    }

    public void setVista_NuevoRol(JDialog vista_NuevoRol) {
        this.vista_NuevoRol = vista_NuevoRol;
    }



    public JTextArea getTxt_observaciones() {
        return txt_observaciones;
    }

    public void setTxt_observaciones(JTextArea txt_observaciones) {
        this.txt_observaciones = txt_observaciones;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vista_NuevoRol = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nombrerol = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observaciones = new javax.swing.JTextArea();
        btn_guardar_rol = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_ingresar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_rol = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_rol = new javax.swing.JTable();
        btn_ver_permiso = new javax.swing.JButton();
        btn_editar_permiso = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        vista_NuevoRol.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        vista_NuevoRol.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 500));

        jLabel2.setText("Numero:");
        vista_NuevoRol.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 58, -1, -1));

        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });
        vista_NuevoRol.getContentPane().add(txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 50, 204, 32));

        jLabel3.setText("ID:");
        vista_NuevoRol.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 114, -1, 20));

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        vista_NuevoRol.getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 108, 204, 32));

        jLabel4.setText("Nombre del Rol:");
        vista_NuevoRol.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 177, -1, -1));
        vista_NuevoRol.getContentPane().add(txt_nombrerol, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 168, 207, 34));

        jLabel5.setText("Observaciones:");
        vista_NuevoRol.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 246, -1, -1));

        txt_observaciones.setColumns(20);
        txt_observaciones.setRows(5);
        jScrollPane1.setViewportView(txt_observaciones);

        vista_NuevoRol.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 246, -1, 155));

        btn_guardar_rol.setText("Guardar");
        vista_NuevoRol.getContentPane().add(btn_guardar_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 436, -1, -1));

        btn_cancelar.setText("Cancelar ");
        vista_NuevoRol.getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 436, -1, -1));

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 21, -1, -1));

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/WhatsApp Image 2022-02-15 at 00.32.29.jpeg"))); // NOI18N
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 21, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/buscar (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 21, 46, -1));

        txt_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rolActionPerformed(evt);
            }
        });
        getContentPane().add(txt_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 22, 227, -1));

        tabla_rol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "numero_rol", "id_rol", "nombre_rol", "observaciones"
            }
        ));
        jScrollPane2.setViewportView(tabla_rol);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 430, 210));

        btn_ver_permiso.setText("Ver permiso");
        getContentPane().add(btn_ver_permiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 30));

        btn_editar_permiso.setText("Editar Permiso");
        getContentPane().add(btn_editar_permiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void txt_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rolActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_editar_permiso;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar_rol;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_ver_permiso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_rol;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombrerol;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextArea txt_observaciones;
    private javax.swing.JTextField txt_rol;
    private javax.swing.JDialog vista_NuevoRol;
    // End of variables declaration//GEN-END:variables
}
