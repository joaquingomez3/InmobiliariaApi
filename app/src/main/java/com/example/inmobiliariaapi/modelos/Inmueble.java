package com.example.inmobiliariaapi.modelos;

import java.io.Serializable;

public class Inmueble implements Serializable {
    private int idInmueble;
    private String direccion;
    private int ambientes;
    private String tipo;
    private String uso;
    private double precio;
    private String imagen;
    private boolean disponible;
    private Propietario propietario;

    public Inmueble() {}

    public Inmueble(int idInmueble, String direccion, int ambientes, String tipo, String uso, double precio, String imagen, boolean disponible, Propietario propietario) {
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.ambientes = ambientes;
        this.tipo = tipo;
        this.uso = uso;
        this.precio = precio;
        this.imagen = imagen;
        this.disponible = disponible;
        this.propietario = propietario;
    }

    public int getIdInmueble() { return idInmueble; }
    public void setIdInmueble(int idInmueble) { this.idInmueble = idInmueble; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getAmbientes() { return ambientes; }
    public void setAmbientes(int ambientes) { this.ambientes = ambientes; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getUso() { return uso; }
    public void setUso(String uso) { this.uso = uso; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public Propietario getPropietario() { return propietario; }
    public void setPropietario(Propietario propietario) { this.propietario = propietario; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
}
