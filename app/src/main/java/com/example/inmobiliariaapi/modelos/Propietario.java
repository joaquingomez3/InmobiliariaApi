package com.example.inmobiliariaapi.modelos;

import java.io.Serializable;

public class Propietario implements Serializable {
    private int idPropietario;
    private String dni;
    private String apellido;
    private String nombre;
    private String telefono;
    private String email;
    private String clave;

    public Propietario() {}

    public Propietario(int idPropietario, String dni, String apellido, String nombre, String telefono, String mail, String password) {
        this.idPropietario = idPropietario;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = mail;
        this.clave = password;
    }

    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String mail) { this.email = mail; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
}

