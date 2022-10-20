/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sistema
 */
public class Conecta {
      String db="";
   String url="jdbc:mysql://localhost:3306/proyecto";
      //String url="jdbc:mysql://localhost/proyecto/";
        String usr="root";
        String pass="";
        String driver="org.mariadb.jdbc.Driver";
        Connection cx;
     /*
        
        
             Class.forName("org.mariadb.jdbc.Driver");
    }

    public Connection getConexion() {
        if (conexion == null) {
            try {
                //establecemos por primera vez
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc://localhost/proyecto", "root", "");
            } catch 
        
        */   
        
        //Class.forName("org.mariadb.jdbc.Driver");//

    public Conecta() {
    }
        
    public Connection conectar(){
          try {
              Class.forName(driver);
              cx=DriverManager.getConnection(url+db, usr, pass);
              System.out.println("Se conectó a bd"+db);
          } catch (ClassNotFoundException | SQLException ex) {
              System.out.println("No se conectó a bd "+db );
              Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
          }
    return cx;
    }
public void desconectar(){
          try { 
              cx.close();
          } catch (SQLException ex) {
              Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
          }
}
}
