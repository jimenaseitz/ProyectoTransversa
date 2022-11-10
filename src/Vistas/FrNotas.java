/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.*;
import persistencia.AlumnoData;

/**
 *
 * @author sistema
 */
public class FrNotas extends javax.swing.JInternalFrame {

    private ArrayList<Alumno> listado;
    private AlumnoData ald = new AlumnoData();

    public FrNotas() {
        initComponents();
        listado = ald.buscaAlumnos();
        for (Object al : listado) {
            this.ccomboalum.addItem((Alumno) al);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gListadoMaterias = new javax.swing.ButtonGroup();
        ccomboalum = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        girlddatos = new javax.swing.JTable();
        bSalir = new javax.swing.JButton();
        bmodificar = new javax.swing.JButton();

        ccomboalum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccomboalumActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Alumno");

        jLabel2.setText("Carga de Notas Por Alumnos");

        girlddatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identificacion", "Nombre", "Año", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(girlddatos);

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bmodificar.setText("Modificar Nota");
        bmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(ccomboalum, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel1)))
                            .addGap(205, 205, 205))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(bmodificar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bSalir)
                            .addGap(44, 44, 44)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ccomboalum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalir)
                    .addComponent(bmodificar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void ccomboalumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccomboalumActionPerformed

        armarGrillaMaterias();
    }//GEN-LAST:event_ccomboalumActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bSalirActionPerformed

    private void bmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodificarActionPerformed
DefaultTableModel modelo = (DefaultTableModel) this.girlddatos.getModel();
         
        if (this.girlddatos.getSelectedRow() != -1) {//me fijo si seleleccionó materia desde el grid
             
            int codigo = Integer.parseInt(String.valueOf(modelo.getValueAt(this.girlddatos.getSelectedRow(), 0)));
            double vnota;
            vnota = Double.parseDouble((String) modelo.getValueAt(this.girlddatos.getSelectedRow(), 3));

            Alumno a = new Alumno();
            a = (Alumno) this.ccomboalum.getSelectedItem();
            InscripcionData insd = new InscripcionData();
            insd.actualizarNota(a.getId_alumno(), codigo, vnota);
            armarGrillaMaterias();
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una materia");
        }


    }//GEN-LAST:event_bmodificarActionPerformed

    private void armarGrillaMaterias() {
        InscripcionData insd = new InscripcionData();
        ArrayList<Inscripcion> templm = new ArrayList();
        templm = insd.obtenerInscripcionesxAlumno((Alumno) this.ccomboalum.getSelectedItem());
        String datos[] = new String[4];
        DefaultTableModel modelo = (DefaultTableModel) this.girlddatos.getModel();
        modelo.setNumRows(0);
        for (Inscripcion i : templm) {
            datos[0] = i.getMateria().getId_materia() + "";
            datos[1] = i.getMateria().getNombre();
            datos[2] = i.getMateria().getAnio() + "";
            datos[3] = i.getNota() + "";
            modelo.addRow(datos);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bmodificar;
    private javax.swing.JComboBox<Alumno> ccomboalum;
    private javax.swing.ButtonGroup gListadoMaterias;
    private javax.swing.JTable girlddatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
