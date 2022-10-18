/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Alumno;
import Entidades.Conexion;
import com.sun.istack.internal.logging.Logger;
import java.time.LocalDate;
import java.util.logging.Level;
import persistencia.AlumnoData;
import persistencia.miConexion;

/**
 *
 * @author sistema
 */
public class Prueba {

    private AlumnoData alumnoData;
    private Conexion conexion;
    
    public static void main(String[] args) {

        LocalDate fecha = LocalDate.now();
        Alumno estudioso = new Alumno("prueba",fecha,true);//0
        new Prueba().conectar(estudioso);
        
}
void conectar(Alumno estudioso){
    try {
        conexion = new Conexion ("jbdc:mysql://localhost/proyecto","root","");
        alumnoData = new AlumnoData(conexion);
        alumnoData.guardarAlumno(estudioso);
        
    } catch (ClassNotFoundException ex) {
     Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE,null, ex);
    }
}    
}

