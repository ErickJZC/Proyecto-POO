/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Modelo.Cita;
import Modelo.Consultorio;
import Modelo.EstadoCita;
import Modelo.Medico;
import Modelo.ModalidadCita;
import Modelo.Paciente;
import java.util.ArrayList;

/**
 *
 * @author ALARCON
 */
public class GestionCitas {
    private ArrayList<Cita> citas;

    public GestionCitas() {
        this.citas = new ArrayList<>();
    }

    public ArrayList<Cita> getCitas() {
        return new ArrayList<>(citas); // Devuelve una copia
    }

    public boolean crearCita(String fechaHora, Medico medico, Consultorio consultorio, Paciente paciente, ModalidadCita modalidad) {
        if (!validarDisponibilidad(medico, consultorio, fechaHora)) {
            return false;
        }
        Cita nuevaCita = new Cita(fechaHora, medico, consultorio, paciente, modalidad);
        citas.add(nuevaCita);
        return true;
    }

    public boolean cancelarCita(Cita cita) {
        if (citas.contains(cita)) {
            cita.setEstado(EstadoCita.CANCELADA);
            return true;
        }
        return false;
    }

    public boolean modificarCita(Cita cita, String nuevaFecha, Medico nuevoMedico, Consultorio nuevoConsultorio) {
        if (!citas.contains(cita) || !validarDisponibilidad(nuevoMedico, nuevoConsultorio, nuevaFecha)) {
            return false;
        }
        cita.setFechaHora(nuevaFecha);
        cita.setMedico(nuevoMedico);
        cita.setConsultorio(nuevoConsultorio);
        return true;
    }

    public ArrayList<Cita> buscarCitaPorEspecialidad(String especialidad) {
        ArrayList<Cita> resultado = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getMedico().getEspecialidad().equalsIgnoreCase(especialidad)) {
                resultado.add(cita);
            }
        }
        return resultado;
    }

    public ArrayList<Cita> buscarCitaPorMedico(Medico medico) {
        ArrayList<Cita> resultado = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getMedico().equals(medico)) {
                resultado.add(cita);
            }
        }
        return resultado;
    }

    public ArrayList<Cita> buscarCitaPorFecha(String fecha) {
        ArrayList<Cita> resultado = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getFechaHora().startsWith(fecha)) {
                resultado.add(cita);
            }
        }
        return resultado;
    }

    private boolean validarDisponibilidad(Medico medico, Consultorio consultorio, String fechaHora) {
        for (Cita cita : citas) {
            // Solo validar contra citas que no estén canceladas
            if (cita.getEstado() != EstadoCita.CANCELADA && cita.getFechaHora().equals(fechaHora)) {
                if (cita.getMedico().equals(medico)) {
                    System.out.println("El médico no está disponible en esa fecha y hora.");
                    return false;
                }
                if (cita.getConsultorio().equals(consultorio)) {
                    System.out.println("El consultorio no está disponible en esa fecha y hora.");
                    return false;
                }
            }
        }
        return true;
    }
}