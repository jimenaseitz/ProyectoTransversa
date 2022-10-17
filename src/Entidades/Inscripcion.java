package Entidades;

public class Inscripcion {

    private int id_materia;

    private int id_alumno;

    private int anio;

    private boolean estado;

    public Inscripcion() {
    }

    public Inscripcion(int id_materia, int id_alumno, int anio, boolean estado) {
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
        this.anio = anio;
        this.estado = estado;
    }

    public int getId_materia() {
        return id_materia;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_materia=" + id_materia + ", id_alumno=" + id_alumno + ", anio=" + anio + ", estado=" + estado + '}';
    }
}
