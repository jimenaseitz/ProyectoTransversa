package persistencia;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection cx;

    public InscripcionData() {
        this.cx = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion in) {
        try {
            String sql = "INSERT INTO inscripcion (id_alumno, id_materia, nota ) values(?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, in.getAlumno().getId_alumno());
            ps.setInt(2, in.getMateria().getId_materia());
            ps.setLong(3, 0);
            int bandera = ps.executeUpdate();

            if (bandera > 0) {
                JOptionPane.showMessageDialog(null, "INSCRIPTO");
            } else {
                JOptionPane.showMessageDialog(null, "no es posible inscribir - VERIFIQUE ");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int clave = rs.getInt(1);
                in.setId_inscripcion(clave);
            }
            ps.close();
        } catch (SQLException ex) {

            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "La inscripción ya se encuentra ingresada - verifique");
            } else {
                if (ex.getErrorCode() == 1452) {
                    JOptionPane.showMessageDialog(null, "La Materia o Alumno son inexistentes - verifique");

                } else {
                    JOptionPane.showMessageDialog(null, "Error en sentencia ");
                }

            }

            System.out.println(ex.getErrorCode());

        }
    }

    public Inscripcion obtenerInscripcion(int a, int m) {
//public void obtenerInscripcion (int  a,id materia){
        Inscripcion i = new Inscripcion();
        AlumnoData al = new AlumnoData();
        MateriaData mat = new MateriaData();
        try {
            String sql = "SELECT * FROM inscripcion WHERE id_alumno=? and id_materia=?";
            PreparedStatement ps = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a);
            ps.setInt(2, m);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i.setAlumno(al.buscarAlumno(rs.getInt("id_alumno")));
                i.setMateria(mat.buscarMateria(rs.getInt("id_materia")));
            } else {
                JOptionPane.showMessageDialog(null, "no se encontraron registros");
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1452) {
                    JOptionPane.showMessageDialog(null, "La inscripcion es inexistente - verifique");

                } else {
                    JOptionPane.showMessageDialog(null, "Error en sentencia ");
                }

            System.out.println(ex.getErrorCode());
        }

        return i;
    }

    public void borrarInscripcion(int a, int m) {
        try {
            String sql = "DELETE from inscripcion where id_alumno=? and id_materia=?";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, a);
            ps.setInt(2, m);
            int bandera = ps.executeUpdate();
            if (bandera > 0) {
                JOptionPane.showMessageDialog(null, "La inscripción fue eliminada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "no se encuentra inscripto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en sentencia - borrarinscripcion");
        }
    }

    public void actualizarNota(int idalumno, int idmateria, double nota) {
        try {
            String sql = "Update inscripcion Set nota=? where id_alumno=? and id_materia=? ";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idalumno);
            ps.setInt(3, idmateria);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "La Nota se ha Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Alumno/materia no encontrada -Actualizar Nota");
            }
            ps.close();
        } catch (SQLException ex) {
             if (ex.getErrorCode() == 1452) {
                    JOptionPane.showMessageDialog(null, "La matreria o Alumno son inexistentes - verifique");

                } else {
                    JOptionPane.showMessageDialog(null, "Error en sentencia ");
                }

            System.out.println(ex.getErrorCode());
        }
    }

    public ArrayList obtenerMateriasInscriptas(Alumno al) {
        ArrayList<Materia> ma = new ArrayList();
        Materia mattemp;
        MateriaData m = new MateriaData();
        try {
            String sql = "SELECT * FROM inscripcion Where id_alumno=?";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, al.getId_alumno());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mattemp = new Materia();
                mattemp = m.buscarMateria(rs.getInt("id_materia"));
                ma.add(mattemp);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en consulta - obtenermateriasinscriptas");
        }
        return ma;
    }

    public ArrayList obtenerMateriasNoInscriptas(Alumno al) {
        ArrayList<Materia> ma = new ArrayList();
        Materia mattemp;
        try {
            String sql = "SELECT * FROM materia  WHERE id_materia NOT IN"
                    + " ( SELECT id_materia FROM inscripcion WHERE id_alumno = ?)"
                    + " and materia.estado=true";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, al.getId_alumno());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mattemp = new Materia();
                mattemp.setId_materia(rs.getInt("id_materia"));
                mattemp.setNombre(rs.getString("nombre"));
                mattemp.setAnio(rs.getInt("anio"));
                mattemp.setEstado(rs.getBoolean("estado"));
                ma.add(mattemp);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en consulta - obtenermateriasinscriptas");
        }
        return ma;
    }

    public ArrayList obtenerAlumnosInscriptos(Materia mat) {
        ArrayList<Alumno> listaAlumno = new ArrayList();
        Alumno tmpalum;
        try {
            String sql = "SELECT * FROM alumno  WHERE estado=true and  id_alumno IN ( SELECT id_alumno FROM inscripcion WHERE id_materia=?)";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, mat.getId_materia());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tmpalum = new Alumno();
                tmpalum.setId_alumno(rs.getInt("id_alumno"));
                tmpalum.setApellido(rs.getString("apellido"));
                tmpalum.setNombre(rs.getString("nombre"));
                tmpalum.setDni(rs.getInt("dni"));
                tmpalum.setEstado(rs.getBoolean("estado"));
                tmpalum.setFecha_nacimiento(rs.getDate("Fecha_nacimiento").toLocalDate());
                listaAlumno.add(tmpalum);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "verSQL obtener alumnos inscriptos");
        }
        return listaAlumno;
    }
}
