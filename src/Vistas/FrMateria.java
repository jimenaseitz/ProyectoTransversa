/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Materia;
import javax.swing.JOptionPane;
import persistencia.MateriaData;

/**
 *
 * @author jimes
 */
public class FrMateria extends javax.swing.JInternalFrame {

    MateriaData matd = new MateriaData();
    Materia aux = new Materia();

    public FrMateria() {
        initComponents();
        this.tIdMateria.setText("0");

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
        tIdMateria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        tanio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bSalir = new javax.swing.JButton();
        bActualizare = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        BBuscar = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alta - Baja - Modificacion Materia");

        jLabel2.setText("Codigo");

        tIdMateria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tIdMateriaFocusLost(evt);
            }
        });
        tIdMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdMateriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        tanio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tanioFocusLost(evt);
            }
        });
        tanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanioActionPerformed(evt);
            }
        });

        jLabel4.setText("A??o");

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bActualizare.setText("Actualizar");
        bActualizare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizareActionPerformed(evt);
            }
        });

        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        BBuscar.setText("Buscar");
        BBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarActionPerformed(evt);
            }
        });

        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        BBorrar.setText("Borrar");
        BBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorrarActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mar.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bActualizare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSalir)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tanio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)))
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BBuscar)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bActualizare)
                            .addComponent(bSalir)
                            .addComponent(BBorrar)
                            .addComponent(bLimpiar)
                            .addComponent(bNuevo)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void bActualizareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizareActionPerformed

        if (!this.tIdMateria.getText().equals("")) {
            if (this.tanio.getText().equals("")) {
                this.tanio.setText("0");
            }

            aux.setId_materia(Integer.parseInt(this.tIdMateria.getText()));
            aux.setAnio(Integer.parseInt(this.tanio.getText()));
            aux.setEstado(true);
            aux.setNombre(this.tNombre.getText());
            matd.actualizarMateria(aux);
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar el c??digo");
        }


    }//GEN-LAST:event_bActualizareActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        aux.setAnio(Integer.parseInt(this.tanio.getText()));
        aux.setEstado(true);
        aux.setNombre(this.tNombre.getText());
        matd.guardarMateria(aux);
        limpiar();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void BBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarActionPerformed
    
        if (this.tIdMateria.getText().matches("[+-]?\\d*(\\.\\d+)?")) {
            if (this.tIdMateria.getText().equals("")) {
                this.tIdMateria.setText("0");
            }
            aux = matd.buscarMateria(Integer.parseInt(this.tIdMateria.getText()));
            this.tIdMateria.setText(String.valueOf(aux.getId_materia()));
            this.tNombre.setText(aux.getNombre());
            this.tanio.setText(String.valueOf(aux.getAnio()));

        } 

    }//GEN-LAST:event_BBuscarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bSalirActionPerformed

    private void tIdMateriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tIdMateriaFocusLost
        if (!this.tIdMateria.getText().matches("[+-]?\\d*(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero");
            this.tIdMateria.requestFocus();
                
            }
          
        

    

    }//GEN-LAST:event_tIdMateriaFocusLost

    private void tIdMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdMateriaActionPerformed

    private void tanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanioActionPerformed

    private void tanioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tanioFocusLost

        if (!this.tanio.getText().matches("[+-]?\\d*(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero");
            this.tanio.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tanioFocusLost

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        if (this.tIdMateria.getText().matches("[+-]?\\d*(\\.\\d+)?")) {
         if (this.tIdMateria.getText().equals("")) {
                this.tIdMateria.setText("0");
            }   
            matd.borrarMateria(Integer.parseInt(this.tIdMateria.getText()));

    }//GEN-LAST:event_BBorrarActionPerformed

    }

    private void limpiar() {
        this.tIdMateria.setText("");
        this.tNombre.setText("");
        this.tanio.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BBuscar;
    private javax.swing.JButton bActualizare;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tIdMateria;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tanio;
    // End of variables declaration//GEN-END:variables
}
