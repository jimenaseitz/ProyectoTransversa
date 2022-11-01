package Entidades;

import java.time.LocalDate;


public class Alumno {

    private String nombre;

    private String apellido;

    private long dni;

    private int id_alumno;

    private LocalDate fecha_nacimiento;

    private boolean estado;

    public Alumno() {
    }

    public Alumno(String nombre, LocalDate fecha_nacimiento, boolean estado) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

   
    public Alumno( int id_alumno, String nombre, String apellido, long dni, LocalDate fecha_nacimiento, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id_alumno = id_alumno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public Alumno(String nombre, String apellido, long dni, LocalDate fecha_nacimiento, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
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

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    
    

    
    
    
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", id_alumno=" + id_alumno + ", fecha_nacimiento=" + fecha_nacimiento + ", estado=" + estado + '}';
    }
}
