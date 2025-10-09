package com.example.inmobiliariaapi.modelos;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class Alquiler {
    private int idAlquiler;
    private double precio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Inquilino inquilino;
    private Inmueble inmueble;

    public Alquiler() {}

    public Alquiler(int idAlquiler, double precio, LocalDateTime fechaInicio, LocalDateTime fechaFin, Inquilino inquilino, Inmueble inmueble) {
        this.idAlquiler = idAlquiler;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public int getIdAlquiler() { return idAlquiler; }
    public void setIdAlquiler(int idAlquiler) { this.idAlquiler = idAlquiler; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public Inquilino getInquilino() { return inquilino; }
    public void setInquilino(Inquilino inquilino) { this.inquilino = inquilino; }

    public Inmueble getInmueble() { return inmueble; }
    public void setInmueble(Inmueble inmueble) { this.inmueble = inmueble; }
}
