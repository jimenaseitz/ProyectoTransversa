/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Alumno;
import persistencia.Conexion;
import com.sun.istack.internal.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import persistencia.AlumnoData;


/**
 *
 * @author sistema
 */
public class Prueba {

    private AlumnoData alumnoData;
    private Conexion conexion;
    AlumnoData dat=new AlumnoData();

   
    public static void main(String[] args) {

        Conexion con = new Conexion();

        System.out.println(con.getConexion());
/*        Alumno nuevo= new Alumno();
        nuevo.setApellido("PRUEBA1");
        nuevo.setNombre("NOMBRE");
        nuevo.setDni(12345);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        con.getConexion();
        dat.guardarAlumno(nuevo);
  */    

    }
}
