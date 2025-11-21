/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultorios;

/**
 *
 * @author erick
 */
public class Consultorio {
    private String Codigo;
    private String Especialidad;
    private String Estado;

    public Consultorio(String Codigo, String Especialidad) {
        this.Codigo = Codigo;
        this.Especialidad = Especialidad;
        this.Estado = "Disponible";
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
