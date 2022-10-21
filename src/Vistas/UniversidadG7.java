package Vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Alumno;
import java.time.LocalDate;
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
//        dat.guardarAlumno(nuevo);
 
//BUSCANDO ALUMNO POR ID///
System.out.println(dat.buscarAlumno(3));
        System.out.println(dat.buscarAlumno(1));
         
        
        ///ACTUALIZANDO ALUMNO POR DNI
        nuevo.setId_alumno(6);
        nuevo.setApellido("PP");
        
        dat.actualizarAlumno(nuevo);
        
        
    }
}
