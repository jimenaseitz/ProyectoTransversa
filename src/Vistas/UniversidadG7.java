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

    public static void main(String[] args) {
        // TODO code application logic here

        AlumnoData dat = new AlumnoData();
        Alumno nuevo = new Alumno();

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
        System.out.println("Envia alumno " + nuevo.getApellido());
        dat.guardarAlumno(nuevo);//se realiza conexion y se envia datos

//BUSCANDO ALUMNO POR ID///
        System.out.println("BUSCA POR UN ID INCORRECTO");
        System.out.println(dat.buscarAlumno(3));//id existente
        System.out.println("BUSCA POR UN ID CORRECTO");
        System.out.println(dat.buscarAlumno(1));

        ///ACTUALIZANDO ALUMNO POR CODIGO ID ALUMNO=1
        nuevo.setId_alumno(1);
        nuevo.setApellido("LOPEZ");
        nuevo.setNombre("RUBEN");
        nuevo.setDni(25555555);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        System.out.println("actualiza datos por id = 1");
        dat.actualizarAlumno(nuevo);
        System.out.println("cambia estado borrado logico(Desactivado)");
        dat.borrarAlumno(1, false);
        System.out.println("se trata de haccer borrado logio con id inexistente");
        dat.borrarAlumno(-1, false);
        System.out.println("consultando todos los alumnos activos ");
        System.out.println(dat.buscaAlumnos());
    }
}
