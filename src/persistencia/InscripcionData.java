/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author sistema
 */
public class InscripcionData {

    private Connection cx;

    public InscripcionData() {
        this.cx = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion in) {
        
        try {
            String sql = "INSERT INTO inscripcion (id_alumno, id_materia ) values(?,?)";
            System.out.println("---------");
            System.out.println(in);
            PreparedStatement ps;

            ps = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, in.getAlumno().getId_alumno());
            ps.setInt(2, in.getMateria().getId_materia());
            int bandera = ps.executeUpdate();
            System.out.println(bandera);
            if (bandera > 0) {
                JOptionPane.showMessageDialog(null, "El Alumno fue inscripto de manera correcta");
            } else {
                JOptionPane.showMessageDialog(null, "INSCRIPCIONDATA-no se ha podido dar de alta - VERIFIQUE ");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int clave = rs.getInt(1);
                in.setId_inscripcion(clave);
                System.out.println(in);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE DATOS -posible alumno existente ");
            //(java.util.logging.Logger.getLogger(UniversidadG7.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
