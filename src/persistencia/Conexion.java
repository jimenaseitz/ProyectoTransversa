/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
    private static String db = "";
    private static String url = "jdbc:mysql://localhost:3306/proyecto";
    //String url="jdbc:mysql://localhost/proyecto/";
    private static String usr = "root";
    private static String pass = "";
  // String timeZone="?useLegacyDatetimeCode=false&serverTimezone=UTC\";
    private static String driver = "org.mariadb.jdbc.Driver";
    private static Connection cx=null;

  
    public static Connection getConexion() {
        if (cx == null) {
            try {
                Class.forName(driver);
                //url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password

                cx = DriverManager.getConnection(url + db, usr, pass);
                System.out.println("Se conectó a bd" + db);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("No se conectó a bd " + db);
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cx;
    }
    

    public void desconectar() {
        try {
            cx.close();
            System.out.println("Se desconectó con éxito");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
