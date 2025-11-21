/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultorios;

import Empleados.Medico;


public class HorarioDeAtencion {
    private String Horario;
    private Consultorio Ambiente;
    private Medico MedicoAcargo;

    public HorarioDeAtencion(String Horario, Consultorio Ambiente, Medico MedicoAcargo) {
        this.Horario = Horario;
        this.Ambiente = Ambiente;
        this.MedicoAcargo = MedicoAcargo;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public Consultorio getAmbiente() {
        return Ambiente;
    }

    public void setAmbiente(Consultorio Ambiente) {
        this.Ambiente = Ambiente;
    }

    public Medico getMedicoAcargo() {
        return MedicoAcargo;
    }

    public void setMedicoAcargo(Medico MedicoAcargo) {
        this.MedicoAcargo = MedicoAcargo;
    }
}
