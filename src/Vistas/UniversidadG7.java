package Vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Alumno;
import Entidades.Materia;
import java.time.LocalDate;
import persistencia.AlumnoData;
import persistencia.MateriaData;

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
        nuevo.setDni(4444);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
      dat.guardarAlumno(nuevo);
 
//BUSCANDO ALUMNO POR ID///
System.out.println(dat.buscarAlumno(3));
        System.out.println(dat.buscarAlumno(1));
         
        
        ///ACTUALIZANDO ALUMNO POR DNI
        nuevo.setId_alumno(6);
        nuevo.setApellido("PP");
        
       // dat.actualizarAlumno(nuevo);
        // AGREGAR MATERIA
        Materia ma = new Materia();
        ma.setNombre("MAtematica 1");
        ma.setAnio(1);
        ma.setEstado(true);
        
        MateriaData m = new MateriaData();
        m.guardarMateria(ma);
        
    }
}
