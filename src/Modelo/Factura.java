/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public class Factura {
    private String fecha; // Formato yyyy/mm/dd
    private Paciente paciente;
    private double total;
    private String metodoPago;
    private Cita cita;
    
    public Factura(String fecha, Paciente paciente, double total, String metodoPago, Cita cita) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.total = total;
        this.metodoPago = metodoPago;
        this.cita = cita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
