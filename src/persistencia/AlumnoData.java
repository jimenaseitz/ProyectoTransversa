package persistencia;

import Entidades.*;
import Vistas.UniversidadG7;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
            cx.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UniversidadG7.class.getName()).log(Level.SEVERE, null, ex);

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
            }
            else {
            JOptionPane.showMessageDialog(null,"NO SE ENCONTRARON REGISTRO CON EL ID INDICADO");
            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "VERIFIQUE SENTENCIA - ALUMNODATA - buscarAlumno");
        }
        return al;
    }

    public void actualizarAlumno(Alumno a) {
        String query = "UPDATE alumno set nombre=?, fecha_nacimiento=?, estado=?, dni=? where id_alumno=?"; //1
        try {
            PreparedStatement ps = cx.prepareStatement(query);//2
            ps.setString(1, a.getNombre());
            ps.setDate(2, Date.valueOf(a.getFecha_nacimiento()));
            ps.setBoolean(3, a.getEstado());
            ps.setInt(4,Math.toIntExact(a.getDni()));
            ps.setInt(5, a.getId_alumno());
  //          ResultSet rs = ps.getGeneratedKeys(); //recupera y asigna
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null,"DATOS ACTUALIZADOS");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"NO SE HA PODIDO ACTUALIZAR EL ALUMNO - VERIFIQUE");
            Logger.getLogger(AlumnoData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//Actualizar un alumno

}
