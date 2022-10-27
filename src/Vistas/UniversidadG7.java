package Vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.time.LocalDate;
import persistencia.AlumnoData;
import persistencia.InscripcionData;
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
        Alumno aparains= new Alumno();
        

        nuevo.setApellido("SANCHEZ");
        nuevo.setNombre("TOMAS JOAQUIN");
        nuevo.setDni(44444444);

//se dan de alta alumnos en bd

    nuevo.setApellido("Lopez Pujato");
        nuevo.setNombre("Pablo Javier");
        nuevo.setDni(11111111);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        System.out.println("Envia alumno " + nuevo.getApellido());
        dat.guardarAlumno(nuevo);//se realiza conexion y se envia datos

        aparains=nuevo;


        nuevo.setNombre("Pablo Javier");
        nuevo.setDni(123);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        System.out.println("Envia alumno " + nuevo.getApellido());
        dat.guardarAlumno(nuevo);//se realiza conexion y se envia datos

        nuevo.setApellido("Sanchez");
        nuevo.setNombre("Tomas");
        nuevo.setDni(33333332);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
//        dat.guardarAlumno(nuevo);

        System.out.println("Envia alumno " + nuevo.getApellido());
        dat.guardarAlumno(nuevo);//se realiza conexion y se envia datos

//BUSCANDO ALUMNO POR ID///
        System.out.println(dat.buscarAlumno(3));
        System.out.println(dat.buscarAlumno(1));
        System.out.println("BUSCA POR UN ID INCORRECTO");
        System.out.println(dat.buscarAlumno(3));//id existente
        System.out.println("BUSCA POR UN ID CORRECTO");
        System.out.println(dat.buscarAlumno(1));

      
        ///ACTUALIZANDO ALUMNO POR CODIGO ID ALUMNO=1
        nuevo.setId_alumno(3);
        nuevo.setApellido("LOPEz");
        nuevo.setNombre("RUBEN");
        nuevo.setDni(25555555);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
dat.actualizarAlumno(nuevo);
        //creo materia temporal
        
        Materia m1 = new Materia ("ingles 1 ", 1 ,1, true);
        Materia m2 = new Materia ("lengua 2" ,1,2, true);
        //Agrego materia//
        
        
         //public Inscripcion(Materia materia, Alumno alumno, int anio, double nota) {
        Inscripcion i1=new Inscripcion (m1,aparains,m1.getAnio(),0);
        InscripcionData id= new InscripcionData();
        
       
        id.guardarInscripcion(i1);
        id.obtenerInscripcion(3,2); 
        id.borrarInscripcion(5, 2);
        id.borrarInscripcion(3, 1);
        id.actualizarNota(4, 1, 10);//actualizo nota alumno inscripcion
        id.actualizarNota(4, 15, 10); //materia inexistente
        System.out.println("alumno"+aparains);
        System.out.println("---Muestra Materias inscriptas---");
        System.out.println(id.obtenerMateriasInscriptas(aparains));
        System.out.println("-Muestras materias no inscriptas-");
        System.out.println(id.obtenerMateriasNoInscriptas(aparains));
        system.out.println(id.obtenerAlumnosInscriptos(m1));
        
        
        /*
        // dat.actualizarAlumno(nuevo);
        // AGREGAR MATERIA
        Materia ma = new Materia();
        ma.setNombre("MAtematica 1");
        ma.setAnio(1);
        ma.setEstado(true);

        MateriaData m = new MateriaData();
        m.guardarMateria(ma);
*/
    }
}
