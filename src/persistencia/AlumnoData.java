package persistencia;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "El alumno ya se encuentra ingresado - verifique");
            } else {
                if (ex.getErrorCode() == 1452) {
                    JOptionPane.showMessageDialog(null, "El Alumno no inexiste - verifique");

                } else {
                    JOptionPane.showMessageDialog(null, "Error en sentencia ");
                }
            }
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
                JOptionPane.showMessageDialog(null, "Registro no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verifique Sentencia -buscarAlumno");
        }
        return al;
    }

    public void actualizarAlumno(Alumno a) {

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

            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "El alumno ya se encuentra actualizado con esos datos - verifique");
            } else {
                if (ex.getErrorCode() == 1452) {
                    JOptionPane.showMessageDialog(null, "El Alumno no inexiste - verifique");

                } else {
                    JOptionPane.showMessageDialog(null, "Error en sentencia ");
                }
            }

        }

    }//Actualizar un alumno

    public void borrarAlumno(int id) {//borrado logico
        String sql = "UPDATE alumno SET estado=false where id_alumno=?";
        PreparedStatement ps;
        try {
            ps = cx.prepareStatement(sql);

            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "EL ALUMNO FUE BORRADO");

            } else {
                JOptionPane.showMessageDialog(null, "No fue posible actualizar");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error en sentencia verifique sqlBORARALUMNO");
        }

    }

    public ArrayList<Alumno> buscaAlumnos() {
        ArrayList<Alumno> listatmp = new ArrayList();
        Alumno al;
        String sql = "Select * from alumno where estado=1";
        try {
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al = new Alumno();
                al.setId_alumno(rs.getInt("id_alumno"));
                al.setApellido(rs.getString("apellido"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setEstado(rs.getBoolean("estado"));
                al.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                listatmp.add(al);

            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lista O consulta incorrecta, verifique");
        }
        return listatmp;

    }

}
