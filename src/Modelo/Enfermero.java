/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public class Enfermero extends Empleado {
    public Enfermero(int DNI, String nombres, String apellidos, String password) {
        super(DNI, nombres, apellidos, RolEmpleado.ENFERMERO, password);
    }

    @Override
    public String obtenerTipoEmpleado() {
        return "Enfermero";
    }
}