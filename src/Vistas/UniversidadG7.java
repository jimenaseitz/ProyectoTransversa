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

    public static void main(String[] args) {

        AlumnoData dat = new AlumnoData();
        //Conexion con = new Conexion();
        Alumno nuevo = new Alumno();
        Alumno aparains = new Alumno();

//se dan de alta alumnos en bd
        nuevo.setApellido("Lopez Pujato");
        nuevo.setNombre("Pablo Javier");
        nuevo.setDni(11111111);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        System.out.println("Envia alumno " + nuevo.getApellido());
        dat.guardarAlumno(nuevo);//se realiza conexion y se envia datos
        aparains = nuevo;

        nuevo.setNombre("Seitz");
        nuevo.setNombre("Jimena");
        nuevo.setDni(1234);
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


        ///ACTUALIZANDO ALUMNO POR CODIGO ID ALUMNO=1
        nuevo.setId_alumno(201);
        nuevo.setApellido("Seitz-Actualizada");
        nuevo.setNombre("Jimena");
        nuevo.setDni(25555555);
        nuevo.setFecha_nacimiento(LocalDate.now());
        nuevo.setEstado(true);
        dat.actualizarAlumno(nuevo);

        //BUSCANDO ALUMNO POR ID///
       
        dat.borrarAlumno(317);

        //creo materia temporal
        System.out.println("se agregan materias");
        MateriaData m = new MateriaData();
        Materia m1 = new Materia("ingles 1 ", 1, true);
        m.guardarMateria(m1);
        Materia m2 = new Materia("lengua 2", 2, true);
        m.guardarMateria(m2);

        Materia m3 = new Materia("Matematica 1", 3, true);
        m.guardarMateria(m3);
        m1 = new Materia("Matematica-actualiza 1", 3, true);

        m1 = new Materia("ingles 1 ", 2, true);
        m.guardarMateria(m1);

        m1.setId_materia(84);
        m.actualizarMateria(m1);
        m1.setId_materia(86);
       
        InscripcionData id = new InscripcionData();
        Inscripcion i1 = new Inscripcion(m1, nuevo, m1.getAnio(), 0);
        id.guardarInscripcion(i1);
        m2.setId_materia(87);
        i1 = new Inscripcion(m2, nuevo, m1.getAnio(), 0);

        id.guardarInscripcion(i1);
        System.out.println("Optiene inscripcion de una materia");
        System.out.println(id.obtenerInscripcion(201, 86));
        id.borrarInscripcion(5, 2);

        id.actualizarNota(4, 1, 10);//actualizo nota alumno inscripcion
        System.out.println("alumno" + aparains);
        System.out.println("---Muestra Materias inscriptas---");
        System.out.println(id.obtenerMateriasInscriptas(aparains));
        System.out.println("-Muestras materias no inscriptas-");
        System.out.println(id.obtenerMateriasNoInscriptas(aparains));
        System.out.println("Alumnos Inscriptos a materia:  " + m1);
        System.out.println(id.obtenerAlumnosInscriptos(m1));

    }
}
