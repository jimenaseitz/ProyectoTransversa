/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Entidades.Materia;
import Vistas.UniversidadG7;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jimes
 */
public class MateriaData {
     private Connection cx;

    public MateriaData() {
        this.cx = cx;
    }
     public void guardarMateria(Materia m) {

        try {
            String sql = "INSERT INTO `materia`( `Nombre`,`anio`,`Estado`) VALUES (?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.getEstado());
            
            int agregoregistro = ps.executeUpdate();
            String cartel;
            if (agregoregistro > 0) {
                cartel = "La materia fue agregada";
            } else {
                cartel = "No fue posible agregar la materia";
            }
            JOptionPane.showMessageDialog(null, cartel);
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int clave = rs.getInt(1);
                m.setId_materia(clave);
            
            System.out.println(m);
            cx.close();
                       }
            System.out.println(m);
            cx.close();
        } catch (SQLException ex) {

          
            JOptionPane.showMessageDialog(null,"NO SE HA PODIDO GUARDAR LA MATERIA - VERIFIQUE");
        }

        
    }
     
     public void actualizarMateria (Materia m){
        String query = "UPDATE materia set nombre=?, anio=?, estado=? where id_materia=?"; //1
        try {
            PreparedStatement ps = cx.prepareStatement(query);//2
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.getEstado());
            ps.setInt(4, m.getId_materia());
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null,"DATOS ACTUALIZADOS");
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE LA MATERIA - VERIFIQUE");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"NO SE HA PODIDO ACTUALIZAR LA MATERIA - VERIFIQUE");
           /* Logger.getLogger(MateriaData.class
                    .getName()).log(Level.SEVERE, null, ex);*/
        }
        }
}
