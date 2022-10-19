/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Alumno;
import Entidades.Conexion;
import com.sun.istack.internal.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import persistencia.AlumnoData;
import persistencia.miConexion;
import test.Conecta;

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
       Conecta c  = new Conecta();
       c.conectar();
        Conexion con=new Conexion();
        
     Prueba p;
  
    }   
    void conectar(){
    
        try {
           Class.forName("com.mysql.jdbc.Driver");
            Conexion con= new Conexion("jbdc:mysql://localhost/proyecto","root","");
           //Statement stmt=con.createStatement();  
           // ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      

   
}//final
