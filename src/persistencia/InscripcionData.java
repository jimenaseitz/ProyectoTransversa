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
            System.out.println(sql);
            System.out.println(in.getAlumno().getId_alumno() + " -id mat: " + in.getMateria().getId_materia());
            ps.setInt(1, in.getAlumno().getId_alumno());
            ps.setInt(2, in.getMateria().getId_materia());
            ps.setLong(3, 0);
            int bandera = ps.executeUpdate();
            System.out.println("imprime el valor de la bandera: " + bandera);
            if (bandera > 0) {
                JOptionPane.showMessageDialog(null, "INSCRIPTO");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podidio inscribir - VERIFIQUE ");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int clave = rs.getInt(1);
                in.setId_inscripcion(clave);
            }
            System.out.println("Saliendo del bucle");
            System.out.println(in);
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE-InscripcionData ");
            //(java.util.logging.Logger.getLogger(UniversidadG7.class.getName()).log(Level.SEVERE, null, ex);
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
                //    i.setMateria(mat.buscarMateria(rs.getInt("id_materia")));
            } else {
                JOptionPane.showMessageDialog(null, "no se encontraron registros");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verifique Sentencia -BuscarInscripcion");
        }
        System.out.println("Obtiene inscripcion desde un alumnoyMateria");
        System.out.println(i);
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
                JOptionPane.showMessageDialog(null, "no se encuentra la inscripcion");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en sentencia verificar sql - inscripciondata");
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
                JOptionPane.showMessageDialog(null, "inscripcion no encontrada - Verifique");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR EN CONSULTA - actualizarnota-Inscripcion");
        }
    }

    public ArrayList obtenerMateriasInscriptas(Alumno al) {
        ArrayList<Alumno> ma = new ArrayList();
        Materia mattemp;
        System.out.println(al.getId_alumno());
        try {
            String sql = "SELECT * FROM inscripcion Where id_alumno=?";
            PreparedStatement ps = cx.prepareStatement(sql);
            ps.setInt(1, al.getId_alumno());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mattemp = new Materia();
                mattemp.setId_materia(rs.getInt("id_materia"));
//falta terminar se necesita método buscarMateria()
                System.out.println("completar con método buscar materia");
                ma.add(mattemp);
                System.out.println("entra");
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
            System.out.println(rs.wasNull());
            while (rs.next()) {
                mattemp = new Materia();
                mattemp.setId_materia(rs.getInt("id_materia"));
//falta terminar se necesita método buscarMateria()
                ma.add(mattemp);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en consulta - obtenermateriasinscriptas");
        }

        return ma;
    }
    
    public ArrayList obtenerAlumnosInscriptos(Materia maT){
        ArrayList lista = new ArrayList();
        Alumno tempalum;
        string sql="";
        return lista;
    }
    
}
