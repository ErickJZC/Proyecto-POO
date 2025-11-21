/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pacientes;

/**
 *
 * @author erick
 */
public class Paciente {
    private String DNI;
    private String Nombres;
    private String Apellidos;
    private String FechaNacimiento;
    
    private String Sexo;
    
    private String DatosDeContacto;
    private String ContactoDeEmergencia;

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getDatosDeContacto() {
        return DatosDeContacto;
    }

    public void setDatosDeContacto(String DatosDeContacto) {
        this.DatosDeContacto = DatosDeContacto;
    }

    public String getContantoDeEmergencia() {
        return ContactoDeEmergencia;
    }

    public void setContactoDeEmergencia(String ContactoDeEmergencia) {
        this.ContactoDeEmergencia = ContactoDeEmergencia;
    }

    public Paciente(String DNI, String Nombres, String Apellidos, String FechaNacimiento, String Sexo, String DatosDeContacto, String ContantoDeEmergencias) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.FechaNacimiento = FechaNacimiento;
        this.Sexo = Sexo;
        this.DatosDeContacto = DatosDeContacto;
        this.ContactoDeEmergencia = ContantoDeEmergencias;
    }
    
    
}
