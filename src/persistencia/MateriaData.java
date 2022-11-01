/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jimes
 */
public class MateriaData {

    private Connection cx;

    public MateriaData() {
        this.cx = Conexion.getConexion();
    }

    public void guardarMateria(Materia m) {
        try {
            String sql = "INSERT INTO `materia`( `Nombre`,`anio`,`Estado`) VALUES (?,?,?)";
            PreparedStatement ps = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.getEstado());
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
                m.setId_materia(clave);
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "La materia ya se encuentra ingresada - verifique");
            } else if (ex.getErrorCode() == 1452) {
                JOptionPane.showMessageDialog(null, "La inscripcion o Alumno son inexistentes - verifique");

            } else {
                JOptionPane.showMessageDialog(null, "Error en sentencia ");
            }

            System.out.println(ex.getErrorCode());
        }

    }

    public void actualizarMateria(Materia m) {
        String query = "UPDATE materia set nombre=?, anio=?, estado=? where id_materia=?";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.getEstado());
            ps.setInt(4, m.getId_materia());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE LA MATERIA - VERIFIQUE");
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "La materia ya se encuentra ingresada - verifique");
            } else if (ex.getErrorCode() == 1452) {
                JOptionPane.showMessageDialog(null, "La inscripcion o Alumno son inexistentes - verifique");

            } else {
                JOptionPane.showMessageDialog(null, "Error en sentencia ");
            }

            System.out.println(ex.getErrorCode());
        }
    }

    public Materia buscarMateria(int id) {
        Materia ma = new Materia();
        String sql = "SELECT * FROM materia WHERE id_materia=? and estado=1";
        PreparedStatement ps;
        try {
            ps = cx.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ma.setId_materia(id);
                ma.setNombre(rs.getString("nombre"));
                ma.setEstado(rs.getBoolean("estado"));
                ma.setAnio(rs.getInt("anio"));
            } else {
                JOptionPane.showMessageDialog(null, "Materia no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verifique Sentencia -buscarMateria");
        }
        return ma;
    }

    public void borrarMateria(int id) {
        String sql = "UPDATE materia SET estado=false where id_materia=?";
        PreparedStatement ps;
        try {
            ps = cx.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "LA MATERIA FUE BORRADA");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible actualizar el estado de la materia");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error en sentencia verifique sqlBORRARMATERIA");
        }
    }

    public ArrayList<Materia> buscaMaterias() {
        ArrayList<Materia> aux = new ArrayList();
        Materia ma;
        String sql = "Select * from materia where estado=1";
        try {
            PreparedStatement ps = cx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ma = new Materia();
                ma.setId_materia(rs.getInt("id_materia"));
                ma.setNombre(rs.getString("nombre"));
                ma.setEstado(rs.getBoolean("estado"));
                ma.setAnio(rs.getInt("anio"));
                aux.add(ma);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lista O consulta incorrecta, verifique");
        }
        return aux;

    }
}
