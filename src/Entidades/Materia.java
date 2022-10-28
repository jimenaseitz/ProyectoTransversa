package Entidades;

public class Materia {

    private String nombre;

    private int anio;

    private int id_materia;

    private boolean estado;

    public Materia() {
    }

    public Materia(String nombre, int anio, int id_materia, boolean estado) {
        this.nombre = nombre;
        this.anio = anio;
        this.id_materia = id_materia;
        this.estado = estado;
    }

    public Materia(String nombre, int anio, boolean estado) {
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

   
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", anio=" + anio + ", id_materia=" + id_materia + ", estado=" + estado + '}';
    }
}
