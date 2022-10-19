package persistencia;

import Entidades.*;
import java.sql.Connection;
import java.time.LocalDate;


public class AlumnoData {
private Connection con = null;

public AlumnoData(miConexion conexion){
    this.con=conexion.buscarConexion();
                
}
public Alumno buscarAlumno(int id){
    
    
}//seleccionando 1 alumno



}

