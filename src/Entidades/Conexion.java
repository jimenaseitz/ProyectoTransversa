/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import persistencia.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sistema
 */
public class Conexion {
    private String url;
    private String usuario;
    private String password;
    private Connection conexion;

    public Conexion() {
    }
 
    
    
    public Conexion(String url, String usuario, String password)throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        Class.forName("org.mariadb.jdbc.Driver");
    }

    public Connection getConexion() {
        if (conexion == null) {
            try {
                //establecemos por primera vez
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "");
                System.out.println("Se conecto");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("No hay Conexion");
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return conexion;//devyuelve conexion establecida
    }
}

