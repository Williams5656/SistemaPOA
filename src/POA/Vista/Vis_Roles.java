
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

    public JButton getjButton1() {
        return btn_actualizar;
    }

    public void setjButton1(JButton jButton1) {
        this.btn_actualizar = jButton1;
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

    public JButton getBtn_actualizar() {
        return btn_actualizar;
    }

    public void setBtn_actualizar(JButton btn_actualizar) {
        this.btn_actualizar = btn_actualizar;
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

    public JButton getBtn_cancelarE() {
        return btn_cancelarE;
    }

    public void setBtn_cancelarE(JButton btn_cancelarE) {
        this.btn_cancelarE = btn_cancelarE;
    }

    public JButton getBtn_guardarE() {
        return btn_guardarE;
    }

    public void setBtn_guardarE(JButton btn_guardarE) {
        this.btn_guardarE = btn_guardarE;
    }

    public JTextField getTxt_nombreE() {
        return txt_nombreE;
    }

    public void setTxt_nombreE(JTextField txt_nombreE) {
        this.txt_nombreE = txt_nombreE;
    }

    public JTextArea getTxt_observacionesE() {
        return txt_observacionesE;
    }

    public void setTxt_observacionesE(JTextArea txt_observacionesE) {
        this.txt_observacionesE = txt_observacionesE;
    }

    public JDialog getVista_EditarRol() {
        return vista_EditarRol;
    }

    public void setVista_EditarRol(JDialog vista_EditarRol) {
        this.vista_EditarRol = vista_EditarRol;
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
        vista_EditarRol = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombreE = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_observacionesE = new javax.swing.JTextArea();
        btn_cancelarE = new javax.swing.JButton();
        btn_guardarE = new javax.swing.JButton();
        btn_ingresar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_rol = new javax.swing.JTextField();
        btn_actualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_rol = new javax.swing.JTable();
        btn_ver_permiso = new javax.swing.JButton();
        btn_editar_permiso = new javax.swing.JButton();

        vista_NuevoRol.setTitle("Nuevo Rol");

        jLabel2.setText("Numero:");

        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });

        jLabel3.setText("ID:");

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre del Rol:");

        jLabel5.setText("Observaciones:");

        txt_observaciones.setColumns(20);
        txt_observaciones.setRows(5);
        jScrollPane1.setViewportView(txt_observaciones);

        btn_guardar_rol.setText("Guardar");

        btn_cancelar.setText("Cancelar ");

        javax.swing.GroupLayout vista_NuevoRolLayout = new javax.swing.GroupLayout(vista_NuevoRol.getContentPane());
        vista_NuevoRol.getContentPane().setLayout(vista_NuevoRolLayout);
        vista_NuevoRolLayout.setHorizontalGroup(
            vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vista_NuevoRolLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btn_cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar_rol)
                .addGap(77, 77, 77))
            .addGroup(vista_NuevoRolLayout.createSequentialGroup()
                .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(vista_NuevoRolLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vista_NuevoRolLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(34, 34, 34)
                        .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombrerol, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_numero)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        vista_NuevoRolLayout.setVerticalGroup(
            vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vista_NuevoRolLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nombrerol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(vista_NuevoRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_guardar_rol))
                .addGap(26, 26, 26))
        );

        vista_EditarRol.setTitle("Editar Rol");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Observaciones:");

        txt_observacionesE.setColumns(20);
        txt_observacionesE.setRows(5);
        jScrollPane3.setViewportView(txt_observacionesE);

        btn_cancelarE.setText("Cancelar");

        btn_guardarE.setText("Guardar");

        javax.swing.GroupLayout vista_EditarRolLayout = new javax.swing.GroupLayout(vista_EditarRol.getContentPane());
        vista_EditarRol.getContentPane().setLayout(vista_EditarRolLayout);
        vista_EditarRolLayout.setHorizontalGroup(
            vista_EditarRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vista_EditarRolLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(vista_EditarRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(vista_EditarRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(txt_nombreE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(vista_EditarRolLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btn_cancelarE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btn_guardarE)
                .addGap(78, 78, 78))
        );
        vista_EditarRolLayout.setVerticalGroup(
            vista_EditarRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vista_EditarRolLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(vista_EditarRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(vista_EditarRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(vista_EditarRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelarE)
                    .addComponent(btn_guardarE))
                .addGap(47, 47, 47))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 34, -1, -1));

        btn_editar.setText("Editar");
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 34, -1, -1));

        btn_eliminar.setText("Eliminar");
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 34, -1, -1));

        jLabel1.setText("Buscar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(668, 42, 54, -1));
        getContentPane().add(txt_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 38, 227, -1));

        btn_actualizar.setText("Actualizar");
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 96, -1, -1));

        tabla_rol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Id", "Nombre", "Observaciones"
            }
        ));
        jScrollPane2.setViewportView(tabla_rol);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 430, 240));

        btn_ver_permiso.setText("Ver permiso");
        getContentPane().add(btn_ver_permiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 30));

        btn_editar_permiso.setText("Editar Permiso");
        getContentPane().add(btn_editar_permiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 30));

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

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelarE;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_editar_permiso;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardarE;
    private javax.swing.JButton btn_guardar_rol;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_ver_permiso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla_rol;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombreE;
    private javax.swing.JTextField txt_nombrerol;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextArea txt_observaciones;
    private javax.swing.JTextArea txt_observacionesE;
    private javax.swing.JTextField txt_rol;
    private javax.swing.JDialog vista_EditarRol;
    private javax.swing.JDialog vista_NuevoRol;
    // End of variables declaration//GEN-END:variables
}
