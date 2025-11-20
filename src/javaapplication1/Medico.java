/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author erick
 */
public class Medico extends Empleado {
    private String Especialidad;
    private int NroConsultas;

    public Medico(String DNI, String Nombres, String Apellidos, String Rol, String DatosDeContacto, String Especialidad) {
        super(DNI, Nombres, Apellidos, Rol, DatosDeContacto);
        this.Especialidad = Especialidad;
        this.NroConsultas = 0;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    @Override
    public void VerInfo() {
            super.VerInfo();
            System.out.println("Especialidad: " + Especialidad);
            System.out.println("Numero de consultas: " + NroConsultas);
    }
    
    
}
