/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public class Cita {
    private String fechaHora; // Formato yyyy/mm/dd hh:mm
    private Medico medico;
    private Consultorio consultorio;
    private Paciente paciente;
    private ModalidadCita modalidad;
    private EstadoCita estado;

    public Cita(String fechaHora, Medico medico, Consultorio consultorio, Paciente paciente, ModalidadCita modalidad) {
        this.fechaHora = fechaHora;
        this.medico = medico;
        this.consultorio = consultorio;
        this.paciente = paciente;
        this.modalidad = modalidad;
        this.estado = EstadoCita.PROGRAMADA;
    }

    // Getters y Setters
    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ModalidadCita getModalidad() {
        return modalidad;
    }

    public void setModalidad(ModalidadCita modalidad) {
        this.modalidad = modalidad;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fechaHora='" + fechaHora + '\'' +
                ", medico=" + medico.getNombres() +
                ", paciente=" + paciente.getNombres() +
                ", estado=" + estado +
                '}';
    }
}
