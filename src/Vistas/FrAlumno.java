/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Alumno;
import java.time.LocalDate;
import persistencia.AlumnoData;

/**
 *
 * @author jimes
 */
public class FrAlumno extends javax.swing.JInternalFrame {
  AlumnoData al;
    /**
     * Creates new form FrAlumno
     */
    public FrAlumno() {
        initComponents();
         this.al = new AlumnoData();
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
        jLabel2 = new javax.swing.JLabel();
        BxBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BxEstado = new javax.swing.JCheckBox();
        TxApellido = new javax.swing.JTextField();
        TxNombre = new javax.swing.JTextField();
        TxFechaDeNacimiento = new javax.swing.JTextField();
        BxGuardar = new javax.swing.JButton();
        BxBorrar = new javax.swing.JButton();
        BxActualizar = new javax.swing.JButton();
        BxLimpiar = new javax.swing.JButton();
        TxLegajo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxDNI = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("ALUMNO");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Legajo");

        BxBuscar.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        BxBuscar.setForeground(new java.awt.Color(51, 0, 255));
        BxBuscar.setText("Buscar");
        BxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BxBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido");

        jLabel4.setText("Nombre");

        jLabel5.setText("Fecha Nac");

        BxEstado.setText("Estado");
        BxEstado.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        BxEstado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BxEstado.setIconTextGap(20);
        BxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BxEstadoActionPerformed(evt);
            }
        });

        TxApellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        TxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxNombreActionPerformed(evt);
            }
        });

        BxGuardar.setText("Guardar");
        BxGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BxGuardarActionPerformed(evt);
            }
        });

        BxBorrar.setText("Borrar");

        BxActualizar.setText("Actualizar");

        BxLimpiar.setText("Limpiar");

        jLabel6.setText("DNI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(TxLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BxGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(BxBorrar)
                                .addGap(14, 14, 14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BxBuscar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BxActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BxLimpiar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BxEstado)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxNombre)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(TxDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(146, 146, 146))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BxBuscar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(BxEstado)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BxGuardar)
                    .addComponent(BxBorrar)
                    .addComponent(BxActualizar)
                    .addComponent(BxLimpiar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BxBuscarActionPerformed
        
       Alumno alumno = al.buscarAlumno(Integer.parseInt(this.TxLegajo.getText()));
       this.TxApellido.setText(alumno.getApellido());
       this.TxNombre.setText(alumno.getNombre());
       this.TxFechaDeNacimiento.setText(alumno.getFecha_nacimiento().toString());
       this.TxDNI.setText(String.valueOf(alumno.getDni()));
              
        
    }//GEN-LAST:event_BxBuscarActionPerformed

    private void BxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BxEstadoActionPerformed

    private void TxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxNombreActionPerformed

    private void BxGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BxGuardarActionPerformed
       
        Alumno alumno = new Alumno(this.TxDNI.getText(),this.TxApellido.getText(),this.TxNombre.getText(),this.TxFechaDeNacimiento.getText(),this.BxEstado.action(true, ui));
 
        this.al.guardarAlumno(alumno);// TODO add your handling code here:
    }//GEN-LAST:event_BxGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BxActualizar;
    private javax.swing.JButton BxBorrar;
    private javax.swing.JButton BxBuscar;
    private javax.swing.JCheckBox BxEstado;
    private javax.swing.JButton BxGuardar;
    private javax.swing.JButton BxLimpiar;
    private javax.swing.JTextField TxApellido;
    private javax.swing.JTextField TxDNI;
    private javax.swing.JTextField TxFechaDeNacimiento;
    private javax.swing.JTextField TxLegajo;
    private javax.swing.JTextField TxNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
