package persistencia;

import Entidades.*;
import Vistas.UniversidadG7;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger;

public class AlumnoData {

    private Connection cx;

    public AlumnoData() {
        this.cx = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno a) {

        try {
            String sql = "INSERT INTO `alumno`( `DNI`, `Apellido`, `Nombre`, `Fecha_nacimiento`, `Estado`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(a.getFecha_nacimiento()));
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
                int clave = rs.getInt(1);
                a.setId_alumno(clave);
            }
            System.out.println(a);
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE DATOS -posible alumno existente ");
            //(java.util.logging.Logger.getLogger(UniversidadG7.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public Alumno buscarAlumno(int id) {
        Alumno al = new Alumno();
        String sql = "SELECT * FROM alumno WHERE id_alumno=?"; //1
        PreparedStatement ps;
        try {
            ps = cx.prepareStatement(sql); //2
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//paso 3
            if (rs.next()) {
                al.setId_alumno(id);
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setNombre(rs.getString("nombre"));
                al.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                al.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON REGISTRO CON EL ID INDICADO");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verifique Sentencia -AlumnoData-buscarAlumno");
//Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }

    public void actualizarAlumno(Alumno a) {

        //   public Alumno( int id_alumno, String nombre, String apellido, long dni, LocalDate fecha_nacimiento, boolean estado) {
        String query = "UPDATE alumno set nombre=?, apellido=?,  dni=?, fecha_nacimiento=?, estado=? where id_alumno=?"; //1
        PreparedStatement ps;
        try {
            ps = cx.prepareStatement(query);//2
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, Math.toIntExact(a.getDni()));
            ps.setDate(4, Date.valueOf(a.getFecha_nacimiento()));
            ps.setBoolean(5, a.getEstado());
            ps.setInt(6, a.getId_alumno());
            int bandera = ps.executeUpdate();
            if (bandera > 0) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA PODIDO ACTUALIZAR LOS DATOS");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE HA PODIDO ACTUALIZAR EL ALUMNO - VERIFIQUE");

        }

    }//Actualizar un alumno

    public void borrarAlumno(int id, boolean condicion) {//borrado logico
        String sql = "UPDATE alumno SET estado=? where id_alumno=?";
        PreparedStatement ps;
        try {
            ps = cx.prepareStatement(sql);
            ps.setBoolean(1, condicion);
            ps.setInt(2, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "SE REALIZÓ BORRADO LOGICO");

            } else {
                JOptionPane.showMessageDialog(null, "el id ingresado no se encuentra - verifique");
            }

        } catch (SQLException ex) {
            System.out.println("Error en sentencia verifique sql");
        }

    }

    public ArrayList buscaAlumnosxApe(String Nombre) {
        ArrayList<Alumno> lista=null;
        Alumno al;
        String sql = "Select * from alumno apellido=?";
        PreparedStatement ps;
        try {

        } catch (Exception e) {

        }

        return lista;

    }

}
