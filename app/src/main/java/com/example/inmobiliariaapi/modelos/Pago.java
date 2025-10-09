package com.example.inmobiliariaapi.modelos;

import java.time.LocalDate;

import java.time.LocalDate;

public class Pago {
    private int idPago;
    private int nroPago;
    private LocalDate fecha;
    private double importe;
    private Alquiler alquiler;

    public Pago() {}

    public Pago(int idPago, int nroPago, LocalDate fecha, double importe, Alquiler alquiler) {
        this.idPago = idPago;
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.alquiler = alquiler;
    }

    public int getIdPago() { return idPago; }
    public void setIdPago(int idPago) { this.idPago = idPago; }

    public int getNroPago() { return nroPago; }
    public void setNroPago(int nroPago) { this.nroPago = nroPago; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public double getImporte() { return importe; }
    public void setImporte(double importe) { this.importe = importe; }

    public Alquiler getAlquiler() { return alquiler; }
    public void setAlquiler(Alquiler alquiler) { this.alquiler = alquiler; }
}
