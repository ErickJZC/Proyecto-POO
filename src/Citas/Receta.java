/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Citas;

/**
 *
 * @author ALARCON
 */
public class Receta {
    private String Medicamentos;
    private String Dosis;
    private String Frecuencia;
    private String Duracion;
    private OrdenLab OrdenLaboratorio;
    
    public Receta(String Medicamentos, String Dosis, String Frecuencia, String Duracion) {
        this.Medicamentos = Medicamentos;
        this.Dosis = Dosis;
        this.Frecuencia = Frecuencia;
        this.Duracion = Duracion;
}
    public Receta(String Medicamentos, String Dosis, String Frecuencia, String Duracion, OrdenLab OrdenLaboratorio) {
        this.Medicamentos = Medicamentos;
        this.Dosis = Dosis;
        this.Frecuencia = Frecuencia;
        this.Duracion = Duracion;
        this.OrdenLaboratorio = OrdenLaboratorio;
}
    public void setOrdenLaboratorio(OrdenLab OrdenLaboratorio) {
        if (this.OrdenLaboratorio == null) {
            this.OrdenLaboratorio = OrdenLaboratorio;
        } else {
            System.out.println("La receta ya tiene una orden de laboratorio asignada.");
        }
    }

    public OrdenLab getOrdenLaboratorio() {
        return OrdenLaboratorio;
    }

    public String getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(String Medicamentos) {
        this.Medicamentos = Medicamentos;
    }

    public String getDosis() {
        return Dosis;
    }

    public void setDosis(String Dosis) {
        this.Dosis = Dosis;
    }

    public String getFrecuencia() {
        return Frecuencia;
    }

    public void setFrecuencia(String Frecuencia) {
        this.Frecuencia = Frecuencia;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }


}
