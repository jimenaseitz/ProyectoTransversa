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
        jPanel1 = new javax.swing.JPanel();
        opInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        girlddatos = new javax.swing.JTable();
        bSalir = new javax.swing.JButton();
        BInscribir = new javax.swing.JButton();
        bborrarInscripcion = new javax.swing.JButton();

        ccomboalum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccomboalumActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Alumno");

        jLabel2.setText("Carga de Notas Por Alumnos");

        gListadoMaterias.add(opInscriptas);
        opInscriptas.setText("Inscrpitas");
        opInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opInscriptasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(opInscriptas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 213, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(opInscriptas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        girlddatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Nombre", "Año"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        BInscribir.setText("Inscribir a Materia");
        BInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInscribirActionPerformed(evt);
            }
        });

        bborrarInscripcion.setText("Anular Inscripción");
        bborrarInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bborrarInscripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bborrarInscripcion)
                        .addGap(42, 42, 42)
                        .addComponent(BInscribir)
                        .addGap(65, 65, 65)
                        .addComponent(bSalir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(227, 227, 227)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(181, 181, 181)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(ccomboalum, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalir)
                    .addComponent(BInscribir)
                    .addComponent(bborrarInscripcion))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opInscriptasActionPerformed
        armarGrillaMaterias();

    }//GEN-LAST:event_opInscriptasActionPerformed


    private void ccomboalumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccomboalumActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.girlddatos.getModel();
        modelo.setNumRows(0);
        armarGrillaMaterias();


    }//GEN-LAST:event_ccomboalumActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bSalirActionPerformed

    private void BInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInscribirActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.girlddatos.getModel();
        int codigo = Integer.parseInt(String.valueOf(modelo.getValueAt(this.girlddatos.getSelectedRow(), 0)));
        Inscripcion i = new Inscripcion();
        InscripcionData insd = new InscripcionData();
        MateriaData mdata = new MateriaData();
        Materia mtemp = new Materia();
        mtemp = mdata.buscarMateria(codigo);
        Alumno a = new Alumno();
        a = (Alumno) this.ccomboalum.getSelectedItem();
        i = new Inscripcion(mtemp, a, mtemp.getAnio(), 0);
        insd.guardarInscripcion(i);
        armarGrillaMaterias();
    }//GEN-LAST:event_BInscribirActionPerformed

    private void bborrarInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bborrarInscripcionActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.girlddatos.getModel();
        int codigo = Integer.parseInt(String.valueOf(modelo.getValueAt(this.girlddatos.getSelectedRow(), 0)));
        InscripcionData insd = new InscripcionData();
        Alumno a = new Alumno();
        a = (Alumno) this.ccomboalum.getSelectedItem();
        MateriaData mdata = new MateriaData();
        Materia mtemp = new Materia();
        mtemp = mdata.buscarMateria(codigo);
        insd.borrarInscripcion(a.getId_alumno(), mtemp.getId_materia());
        armarGrillaMaterias();

    }//GEN-LAST:event_bborrarInscripcionActionPerformed

    private void armarGrillaMaterias() {
        InscripcionData insd = new InscripcionData();
        ArrayList<Materia> templm = new ArrayList();
       

            templm = insd.obtenerMateriasInscriptas((Alumno) this.ccomboalum.getSelectedItem());

       
       
       

       
        String datos[] = new String[4];
        DefaultTableModel modelo = (DefaultTableModel) this.girlddatos.getModel();
        modelo.setNumRows(0);
        for (Materia materia : templm) {
            datos[0] = materia.getId_materia() + "";
            datos[1] = materia.getNombre();
            datos[2] = materia.getAnio() + "";
            modelo.addRow(datos);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BInscribir;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bborrarInscripcion;
    private javax.swing.JComboBox<Alumno> ccomboalum;
    private javax.swing.ButtonGroup gListadoMaterias;
    private javax.swing.JTable girlddatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opInscriptas;
    // End of variables declaration//GEN-END:variables
}
