package persistencia;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

public class AlumnoData {
    private Connection con = null;
    Conexion conexion= new Conexion();

    public AlumnoData() {
        this.con = conexion.getConexion();

    }

    public void guardarAlumno(Alumno a) {

        a.setApellido("PRUEBA1");
        a.setNombre("NOMBRE");
        a.setDni(12345);
        a.setFecha_nacimiento(LocalDate.now());
        a.setEstado(true);

        String query = "INSERT INTO alumno (id_alumno, apellido, nombre, dni, fecha_nacimiento, estado) Values (?,?,?,?,?,?)"; //1
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);//2
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setInt(4, 111);
            //ps.setInt(4, a.getDni());
            ps.setDate(5, Date.valueOf(a.getFecha_nacimiento()));
            ps.setBoolean(6, a.getEstado());
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

    public Alumno buscarAlumno(int id) {
        Alumno a = null;
        String sql = "SELECT * FROM alumno WHERE id_alumno=?"; //1

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql); //2
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();//paso 3

            //while (rs.next()) {
            a = new Alumno();// paso 4 armamos el objeto
            a.setId_alumno(rs.getInt("id_alumno"));
            a.setDni(rs.getFloat("dni"));
            a.setApellido(rs.getString("apellido"));
            a.setNombre(rs.getString("nombre"));
            a.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
            a.setEstado(rs.getBoolean("estado"));
            //}
            ps.close();
        } catch (SQLException ex) {

            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        //busco un alummno
        return a;

    }

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
            Logger.getLogger(AlumnoData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//Actualizar un alumno

}
