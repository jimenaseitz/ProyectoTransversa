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
        nuevo.setDni(44444444);
//se dan de alta alumnos en bd
        nuevo.setApellido("Lopez Pujato");
        nuevo.setNombre("Pablo Javier");
        nuevo.setDni(11111111);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        System.out.println("Envia alumno " + nuevo.getApellido());
        dat.guardarAlumno(nuevo);//se realiza conexion y se envia datos

        nuevo.setApellido("Seitz");
        nuevo.setNombre("Pablo Javier");
        nuevo.setDni(22222222);
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

        ///ACTUALIZANDO ALUMNO POR DNI
        nuevo.setId_alumno(6);
        nuevo.setApellido("PP");

        ///ACTUALIZANDO ALUMNO POR CODIGO ID ALUMNO=1
        nuevo.setId_alumno(1);
        nuevo.setApellido("LOPEZ");
        nuevo.setNombre("RUBEN");
        nuevo.setDni(25555555);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        System.out.println("actualiza datos por id = 1");
        dat.actualizarAlumno(nuevo);

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
