/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public class Paciente {
    private int DNI;
    private String nombres;
    private String apellidos;
    private String fechaDeNacimiento; // yyyy/mm/dd
    private String sexo;
    private String telefono;
    private String correo;
    private String contactoEmergencia;

    public Paciente(int DNI, String nombres, String apellidos, String fechaDeNacimiento, String sexo, String telefono, String correo, String contactoEmergencia) {
        if (DNI < 10000000 || DNI > 99999999) {
            System.out.println("El DNI es incorrecto");
            this.DNI = 0;
        } else {
            this.DNI = DNI;
        }
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
        this.contactoEmergencia = contactoEmergencia;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setDNI(int DNI) {
        if (DNI >= 10000000 && DNI <= 99999999) {
            this.DNI = DNI;
        } else {
            System.out.println("DNI inválido");
        }
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    @Override
    public String toString() {
        return "DNI: " + DNI +
                ", Nombres: " + nombres +
                ", Apellidos: " + apellidos;
    }
}