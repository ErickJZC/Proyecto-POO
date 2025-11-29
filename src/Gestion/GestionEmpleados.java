/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Modelo.Empleado;
import Modelo.RolEmpleado;
import java.util.ArrayList;

/**
 *
 * @author ALARCON
 */
public class GestionEmpleados {
    private ArrayList<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public Empleado buscarPorDNI(Integer DNI) {
        for (Empleado empleado : empleados) {
            if (DNI.equals(empleado.getDNI())) {
                return empleado;
            }
        }
        return null;
    }

    public Empleado autenticar(int DNI, String password) {
        Empleado empleado = buscarPorDNI(DNI);
        if (empleado != null && empleado.checkPassword(password)) {
            return empleado;
        }
        return null;
    }

    public boolean crearEmpleado(Empleado empleado) {
        if (buscarPorDNI(empleado.getDNI()) != null) {
            System.err.println("Error de lógica: Se intentó crear un empleado que ya existe con DNI " + empleado.getDNI());
            return false;
        }
        empleados.add(empleado);
        return true;
    }

    public boolean modificarEmpleado(int DNI, String nombres, String apellidos, String password, RolEmpleado rol, Integer nuevoDNI) {
        Empleado empleado = buscarPorDNI(DNI);

        if (empleado == null) {
            System.err.println("Error: No se encontró el empleado a modificar con DNI " + DNI);
            return false;
        }

        if (nuevoDNI != null && !nuevoDNI.equals(DNI) && buscarPorDNI(nuevoDNI) != null) {
            System.err.println("Error: El nuevo DNI " + nuevoDNI + " ya está en uso.");
            return false;
        }

        empleado.setNombres(nombres);
        empleado.setApellidos(apellidos);
        empleado.setRolEmpleado(rol);

        if (password != null && !password.isEmpty()) {
            empleado.setPassword(password);
        }

        if (nuevoDNI != null) {
            empleado.setDNI(nuevoDNI);
        }

        return true;
    }

    public boolean eliminarEmpleado(Integer DNI) {
        Empleado empleado = buscarPorDNI(DNI);
        if (empleado != null) {
            empleados.remove(empleado);
            return true;
        }
        return false;
    }

    public void listarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}