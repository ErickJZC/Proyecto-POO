/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Modelo.Paciente;
import java.util.ArrayList;

/**
 *
 * @author ALARCON
 */
public class GestionPacientes {
    private ArrayList<Paciente> pacientes;

    public GestionPacientes() {
        this.pacientes = new ArrayList<>();
    }

    public boolean crearPaciente(Paciente paciente) {
        if (buscarPorDNI(paciente.getDNI()) != null) {
            System.err.println("Error: Ya existe un paciente con el DNI " + paciente.getDNI());
            return false;
        }
        pacientes.add(paciente);
        return true;
    }

    public Paciente buscarPorDNI(int dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDNI() == dni) {
                return paciente;
            }
        }
        return null;
    }

    public boolean modificarPaciente(int dniOriginal, Paciente datosNuevos) {
        Paciente pacienteExistente = buscarPorDNI(dniOriginal);
        if (pacienteExistente == null) {
            return false; // No se encontró el paciente a modificar
        }

        // Si el DNI se modifica, verificar que el nuevo no exista ya
        if (dniOriginal != datosNuevos.getDNI() && buscarPorDNI(datosNuevos.getDNI()) != null) {
            return false; // El nuevo DNI ya está en uso
        }

        pacienteExistente.setDNI(datosNuevos.getDNI());
        pacienteExistente.setNombres(datosNuevos.getNombres());
        pacienteExistente.setApellidos(datosNuevos.getApellidos());
        pacienteExistente.setFechaDeNacimiento(datosNuevos.getFechaDeNacimiento());
        pacienteExistente.setSexo(datosNuevos.getSexo());
        pacienteExistente.setTelefono(datosNuevos.getTelefono());
        pacienteExistente.setCorreo(datosNuevos.getCorreo());
        pacienteExistente.setContactoEmergencia(datosNuevos.getContactoEmergencia());
        
        return true;
    }

    public boolean eliminarPaciente(int dni) {
        Paciente paciente = buscarPorDNI(dni);
        if (paciente != null) {
            pacientes.remove(paciente);
            return true;
        }
        return false;
    }

    public ArrayList<Paciente> getPacientes() {
        return new ArrayList<>(pacientes); // Devuelve una copia para evitar modificación externa
    }
}
