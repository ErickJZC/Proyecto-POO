/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author erick
 */
public class Empleado {
    protected String DNI;
    protected String Nombres;
    protected String Apellidos;
    protected String Rol;
    protected String DatosDeContacto;

    public Empleado(String DNI, String Nombres, String Apellidos, String Rol, String DatosDeContacto) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Rol = Rol;
        this.DatosDeContacto = DatosDeContacto;
    }

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

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getDatosDeContacto() {
        return DatosDeContacto;
    }

    public void setDatosDeContacto(String DatosDeContacto) {
        this.DatosDeContacto = DatosDeContacto;
    }
    
    public void VerInfo(){
        System.out.println("DNI: " + DNI);
        System.out.println("Nombres: " + Nombres);
        System.out.println("Apellidos: " + Apellidos);
        System.out.println("Rol: " + Rol);
        System.out.println("Datos de contacto: " + DatosDeContacto);
        
    }
        
}
