/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Entidades.Alumno;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author sistema
 */
public class InscripcionData {
    

    private Connection cx;

    public InscripcionData() {
      this.cx = Conexion.getConexion();
    }

    
    
    public void guardarInscripcion(Alumno al,Materia mat ){
        String sql= "INSERT INTO inscripcion () value(?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps= cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
        } catch (Exception e) {
        }
        
                
        
        
        
        
    }
    
}






