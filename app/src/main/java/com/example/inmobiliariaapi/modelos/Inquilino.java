package com.example.inmobiliariaapi.modelos;

import java.io.Serializable;

public class Inquilino implements Serializable {
    private int idInquilino;
    private int dni;
    private String apellido;
    private String nombre;
    private String direccion;
    private int telefono;

    public Inquilino() {}

    public Inquilino(int idInquilino, int dni, String apellido, String nombre, String direccion, int telefono) {
        this.idInquilino = idInquilino;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdInquilino() { return idInquilino; }
    public void setIdInquilino(int idInquilino) { this.idInquilino = idInquilino; }

    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
}
