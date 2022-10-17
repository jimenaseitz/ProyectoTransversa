package persistencia;

import Entidades.*;
import java.time.LocalDate;


public class AlumnoData {

    private String nombre;

    private String apellido;

    private float dni;

    private int id_alumno;

    private LocalDate fecha;

    private boolean estado;

    public AlumnoData() {
    }

    public AlumnoData(String nombre, String apellido, float dni, int id_alumno, LocalDate fecha, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id_alumno = id_alumno;
        this.fecha = fecha;
        this.estado = estado;
    }

    public AlumnoData(String nombre, String apellido, float dni, LocalDate fecha, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getDni() {
        return dni;
    }

    public void setDni(float dni) {
        this.dni = dni;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", id_alumno=" + id_alumno + ", fecha=" + fecha + ", estado=" + estado + '}';
    }
}
