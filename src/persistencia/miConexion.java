/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sistema
 */
public class miConexion {

    private String url;
    private String usuario;
    private String password;

    private Connection conexion;

    public miConexion() {
    }

    public miConexion(String url, String usr, String pass) {
        this.url = url;
        this.usuario = usr;
        this.password = pass;
    }

    
  public Connection buscarConexion() {
      if (conexion==null) {
          try {
          //establecemos por primera vez
          Class.forName("or.mariadb.jdbc.Driver");
                  } catch (SQLException |  ClassNotFoundException ex) {
              Logger.getLogger(miConexion.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      
      return conexion;//devyuelve conexion establecida
  }
}
