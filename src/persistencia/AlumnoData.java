package persistencia;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData(miConexion conexion) {
        this.con = conexion.buscarConexion();

    }

    public void guardarAlumno(Alumno a) {
        String query = "INSERT INTO alumno (nombre, fecha_nacimiento, estado) Values ('Alumno1','1978/06/10',1)"; //1
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);//2
            ps.setString(1, a.getNombre());
            ps.setDate(2, Date.valueOf(a.getFecha_nacimiento()));
            ps.setBoolean(3, a.getEstado());
            ps.execute();//3
            ResultSet rs = ps.getGeneratedKeys(); //recupera y asigna
            if (rs.next()) {
                a.setId_alumno(rs.getInt(1));
            } else {
                System.out.println("no se pudo obtener el Id del Alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno void buscarAlumno(int id) {

    }//busco un alummno

    public void actualizarAlumno(Alumno a) {

        String query = "UPDATE alumno set nombre=?, fecha_nacimiento=?, estado=? where id_alumno=?"; //1
        try {
            PreparedStatement ps = con.prepareStatement(query);//2
            ps.setString(1, a.getNombre());
            ps.setDate(2, Date.valueOf(a.getFecha_nacimiento()));
            ps.setBoolean(3, a.getEstado());
            ps.execute();//3
            ps.setInt(4, a.getId_alumno());
            ResultSet rs = ps.getGeneratedKeys(); //recupera y asigna

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//Actualizar un alumno

}
