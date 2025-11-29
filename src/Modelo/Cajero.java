/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public class Cajero extends Empleado {
    public Cajero(int DNI, String nombres, String apellidos, String password) {
        super(DNI, nombres, apellidos, RolEmpleado.CAJERO, password);
    }

    @Override
    public String obtenerTipoEmpleado() {
        return "Cajero";
    }
}