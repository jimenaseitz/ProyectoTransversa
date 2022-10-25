package Entidades;

public class Inscripcion {

    private int id_inscripcion;

    private Materia materia; 
   
    //private int id_alumno;
    private Alumno alumno;
    private int anio;

    private double nota;

    public Inscripcion() {
    }

    
    public Inscripcion(Materia materia, Alumno alumno, int anio, double nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.anio = anio;
        this.nota = nota;
    }

    public Materia getMateria() {
        return materia;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }



    @Override
    public String toString() {
        return "Inscripcion{" + "materia=" + materia + ", alumno=" + alumno + ", anio=" + anio + ", estado=" + estado + '}';
    }

    
    
    

    
}
