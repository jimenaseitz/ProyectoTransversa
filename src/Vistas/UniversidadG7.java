package Vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class UniversidadG7 {

    //1 private AlumnoData alumnoData;
//    private Conexion conexion;
    //2AlumnoData dat;
    public static void main(String[] args) {
        // TODO code application logic here

        AlumnoData dat = new AlumnoData();

        //Conexion con = new Conexion();
        Alumno nuevo = new Alumno();
        nuevo.setApellido("SANCHEZ");
        nuevo.setNombre("TOMAS JOAQUIN");
        nuevo.setDni(44444444);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        dat.guardarAlumno(nuevo);

    }
}
