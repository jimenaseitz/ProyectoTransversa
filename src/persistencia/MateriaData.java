/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Entidades.Materia;
import Vistas.UniversidadG7;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
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
            ps.setBoolean(3, m.isEstado());
            
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
                
                //que

            }
            System.out.println(m);
            cx.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UniversidadG7.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
