/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public class Medico extends Empleado {
    private String especialidad;

    public Medico(int DNI, String nombres, String apellidos, String password, String especialidad) {
        super(DNI, nombres, apellidos, RolEmpleado.MEDICO, password);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String obtenerTipoEmpleado() {
        return "Medico";
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad;
    }
}