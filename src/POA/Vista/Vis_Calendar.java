/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author KEVIN LANDIVAR
 */
public class Vis_Calendar extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vis_Calendar
     */
    public Vis_Calendar() {
        initComponents();
    }

    public JDateChooser getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(JDateChooser Fecha_inicio) {
        this.Fecha_inicio = Fecha_inicio;
    }

    public JDateChooser getFecha_limite() {
        return Fecha_limite;
    }

    public void setFecha_limite(JDateChooser Fecha_limite) {
        this.Fecha_limite = Fecha_limite;
    }

    public JLabel getJl_evidencia() {
        return Jl_evidencia;
    }

    public void setJl_evidencia(JLabel Jl_evidencia) {
        this.Jl_evidencia = Jl_evidencia;
    }

    public JList getList_responsables() {
        return List_responsables;
    }

    public void setList_responsables(JList List_responsables) {
        this.List_responsables = List_responsables;
    }

    public JTable getTabla_calendario() {
        return Tabla_calendario;
    }

    public void setTabla_calendario(JTable Tabla_calendario) {
        this.Tabla_calendario = Tabla_calendario;
    }

    public JButton getBtn_añadir() {
        return btn_añadir;
    }

    public void setBtn_añadir(JButton btn_añadir) {
        this.btn_añadir = btn_añadir;
    }

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JButton getBtn_evidencia() {
        return btn_evidencia;
    }

    public void setBtn_evidencia(JButton btn_evidencia) {
        this.btn_evidencia = btn_evidencia;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JButton getBtn_imprimir() {
        return btn_imprimir;
    }

    public void setBtn_imprimir(JButton btn_imprimir) {
        this.btn_imprimir = btn_imprimir;
    }

    public JButton getBtn_modificar() {
        return btn_modificar;
    }

    public void setBtn_modificar(JButton btn_modificar) {
        this.btn_modificar = btn_modificar;
    }

    public JButton getBtn_n_actividad() {
        return btn_n_actividad;
    }

    public void setBtn_n_actividad(JButton btn_n_actividad) {
        this.btn_n_actividad = btn_n_actividad;
    }

    public JComboBox getCombo_actividad() {
        return combo_actividad;
    }

    public void setCombo_actividad(JComboBox combo_actividad) {
        this.combo_actividad = combo_actividad;
    }

    public JComboBox getCombo_periodo() {
        return combo_periodo;
    }

    public void setCombo_periodo(JComboBox combo_periodo) {
        this.combo_periodo = combo_periodo;
    }

    public JTextField getTxt_N_actividad() {
        return txt_N_actividad;
    }

    public void setTxt_N_actividad(JTextField txt_N_actividad) {
        this.txt_N_actividad = txt_N_actividad;
    }

    public JTextField getTxt_carrera() {
        return txt_carrera;
    }

    public void setTxt_carrera(JTextField txt_carrera) {
        this.txt_carrera = txt_carrera;
    }

    public JTextArea getTxt_descripcion() {
        return txt_descripcion;
    }

    public void setTxt_descripcion(JTextArea txt_descripcion) {
        this.txt_descripcion = txt_descripcion;
    }

    public JTextField getTxt_id_A() {
        return txt_id_A;
    }

    public void setTxt_id_A(JTextField txt_id_A) {
        this.txt_id_A = txt_id_A;
    }

    public JTextField getTxt_responsables() {
        return txt_responsables;
    }

    public void setTxt_responsables(JTextField txt_responsables) {
        this.txt_responsables = txt_responsables;
    }

    public JDialog getImprimir_D() {
        return Imprimir_D;
    }

    public void setImprimir_D(JDialog Imprimir_D) {
        this.Imprimir_D = Imprimir_D;
    }

    public JButton getBtn_aceptar() {
        return btn_aceptar;
    }

    public void setBtn_aceptar(JButton btn_aceptar) {
        this.btn_aceptar = btn_aceptar;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JComboBox getCombo_tipo_actividad_repor() {
        return combo_tipo_actividad_repor;
    }

    public void setCombo_tipo_actividad_repor(JComboBox combo_tipo_actividad_repor) {
        this.combo_tipo_actividad_repor = combo_tipo_actividad_repor;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Imprimir_D = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_tipo_actividad_repor = new javax.swing.JComboBox();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        btn_n_actividad = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id_A = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_responsables = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_responsables = new javax.swing.JTextField();
        txt_N_actividad = new javax.swing.JTextField();
        txt_carrera = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        combo_actividad = new javax.swing.JComboBox();
        combo_periodo = new javax.swing.JComboBox();
        Fecha_limite = new com.toedter.calendar.JDateChooser();
        Fecha_inicio = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_calendario = new javax.swing.JTable();
        btn_evidencia = new javax.swing.JButton();
        Jl_evidencia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setText("SELECCIONE EL TIPO DE ACTIVIDAD PARA EL REPORTE");

        jLabel7.setText("TIPO ACTIVIDAD:");

        combo_tipo_actividad_repor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_cancelar.setText("CANCELAR");

        btn_aceptar.setText("ACEPTAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(combo_tipo_actividad_repor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel7)
                                .addGap(140, 140, 140))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_aceptar)
                                .addGap(99, 99, 99)))
                        .addComponent(btn_cancelar)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo_tipo_actividad_repor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Imprimir_DLayout = new javax.swing.GroupLayout(Imprimir_D.getContentPane());
        Imprimir_D.getContentPane().setLayout(Imprimir_DLayout);
        Imprimir_DLayout.setHorizontalGroup(
            Imprimir_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Imprimir_DLayout.setVerticalGroup(
            Imprimir_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_n_actividad.setText("CREAR ACTIVIDAD");

        btn_modificar.setText("MODIFICAR");

        btn_guardar.setText("GUARDAR");

        btn_imprimir.setText("IMPRIMIR");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("ID ACTIVIDAD");

        jLabel2.setText("NOMBRE CARRERA:");

        jLabel3.setText("TIPO DE ACTIVIDAD:");

        jLabel4.setText("PERIODIO ACADÉMICO:");

        jLabel8.setText("NOMBRE DE  LA ACTIVIDAD:");

        jLabel11.setText("DESCRIPCION:");

        jLabel13.setText("RESPONSABLES DE LA ACRTIVIDAD:");

        List_responsables.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(List_responsables);

        jLabel14.setText("FECHA INICO:");

        jLabel15.setText("FECHA LIMITE:");

        btn_eliminar.setText("ELIMINAR");

        btn_añadir.setText("AÑADIR");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        combo_actividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_actividadActionPerformed(evt);
            }
        });

        combo_periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_responsables, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btn_añadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id_A, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_actividad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_N_actividad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(combo_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha_limite, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_actividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_N_actividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_responsables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_añadir))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(Fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Fecha_limite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tabla_calendario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(Tabla_calendario);

        btn_evidencia.setText("SUBIR EVIDENCIA");

        Jl_evidencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Jl_evidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_evidencia)
                        .addGap(384, 384, 384))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Jl_evidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btn_evidencia)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel6.setText("CALENDARIO ACADÉMICO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btn_n_actividad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addGap(92, 92, 92)
                        .addComponent(btn_modificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(jLabel6)
                        .addGap(0, 105, Short.MAX_VALUE)))
                .addGap(67, 67, 67)
                .addComponent(btn_imprimir)
                .addGap(264, 264, 264))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_modificar)
                            .addComponent(btn_guardar)
                            .addComponent(btn_imprimir))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_n_actividad)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_actividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_actividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_actividadActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_imprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fecha_inicio;
    private com.toedter.calendar.JDateChooser Fecha_limite;
    private javax.swing.JDialog Imprimir_D;
    private javax.swing.JLabel Jl_evidencia;
    private javax.swing.JList List_responsables;
    private javax.swing.JTable Tabla_calendario;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_evidencia;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_n_actividad;
    private javax.swing.JComboBox combo_actividad;
    private javax.swing.JComboBox combo_periodo;
    private javax.swing.JComboBox combo_tipo_actividad_repor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_N_actividad;
    private javax.swing.JTextField txt_carrera;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_id_A;
    private javax.swing.JTextField txt_responsables;
    // End of variables declaration//GEN-END:variables
}
