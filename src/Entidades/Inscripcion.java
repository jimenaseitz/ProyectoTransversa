package Entidades;

public class Inscripcion {

    //private int id_materia;

    private Materia materia; 
   
    //private int id_alumno;
    private Alumno alumno;
    private int anio;

    private boolean estado;

    public Inscripcion() {
    }

    
    public Inscripcion(Materia materia, Alumno alumno, int anio, boolean estado) {
        this.materia = materia;
        this.alumno = alumno;
        this.anio = anio;
        this.estado = estado;
    }

    public Materia getMateria() {
        return materia;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "materia=" + materia + ", alumno=" + alumno + ", anio=" + anio + ", estado=" + estado + '}';
    }

    
    
    

    
}
