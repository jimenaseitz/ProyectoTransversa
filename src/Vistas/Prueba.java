/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Alumno;
import persistencia.Conexion;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import persistencia.AlumnoData;

/**
 *
 * @author sistema
 */
public class Prueba {

    private AlumnoData alumnoData;
    private Conexion conexion;
    AlumnoData dat = new AlumnoData();

    public static void main(String[] args) {

        Conexion con = new Conexion();

        System.out.println(con.getConexion());
        try {
            Alumno nuevo = new Alumno();
            nuevo.setApellido("PRUEBA1");
            nuevo.setNombre("NOMBRE");
            nuevo.setDni(12345);
            nuevo.setFecha_nacimiento(LocalDate.now());
            nuevo.setEstado(true);

            String sql = "INSERT INTO `alumno`( `DNI`, `Apellido`, `Nombre`, `Fecha_nacimiento`, `Estado`) VALUES (?,?,?,?,?)";

            Connection cx = con.getConexion();
            PreparedStatement ps = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, nuevo.getDni());
            ps.setString(2, nuevo.getApellido());
            ps.setString(3, nuevo.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(nuevo.getFecha_nacimiento()));
            ps.setBoolean(5, true);

            int agregoregistro = ps.executeUpdate();
            String cartel;
            if (agregoregistro > 0) {
                cartel = "El Registro fue agregado";
            } else {
                cartel = "No fue posible agregar el registro";
            }
            JOptionPane.showMessageDialog(null, cartel);
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
            int clave=rs.getInt(1);
                nuevo.setId_alumno(clave);
            }
            
            System.out.println(nuevo);
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
