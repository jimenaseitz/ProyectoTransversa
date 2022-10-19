/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sistema
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    String url="jdbc:mysql://localhost:3306/proyecto";
    String user="root";
    String pass="";
        
    Connection conexion;
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("ingrese");
            System.out.println(conexion.getMetaData());
        } catch (SQLException ex) {
            System.out.println("no ingrese");
            
        }
    
   
        
        
    
    
    
    }
    
}
