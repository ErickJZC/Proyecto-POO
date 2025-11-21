/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Citas;
import Pacientes.Paciente;
import Consultorios.Consultorio;
import Empleados.Medico;
/**
 *
 * @author ALARCON
 */
public class Cita{
    private String Fecha;      // dd/mm/aaaa
    private String Hora;       // hh:mm
    private Paciente Paciente;
    private Medico Medico;
    private Consultorio Consultorio;

    private String Estado;     // Programada, Confirmada, etc.

    // Datos que se llenan DURANTE la consulta
    private String Motivo;
    private String Antecedentes;
    private String SignosVitales;
    private String ExamenFisico;
    private String Diagnostico;
    private String Plan;
    private String ResumenClinico;

    private Receta Receta;

    private float Precio;
    private String MetodoPago; // Efectivo, Tarjeta

    public Cita(String Fecha, String Hora, Paciente Paciente, Medico Medico, Consultorio Consultorio, float Precio, String MetodoPago, String estadoInicial) {
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Paciente = Paciente;
        this.Medico = Medico;
        this.Consultorio = Consultorio;
        this.Precio = Precio;
        this.MetodoPago = MetodoPago;
        
        setEstado(estadoInicial);
        
        Motivo = "";
        Antecedentes = "";
        SignosVitales = "";
        ExamenFisico = "";
        Diagnostico = "";
        Plan = "";
        ResumenClinico = "";
        Receta = null;
    }
    public void setEstado(String Estado) {
            switch (Estado) {
                case "Programada":
                case "Confirmada":
                case "En sala":
                case "Atendida":
                case "Cancelada":
                case "No show":
                    this.Estado = Estado;
                    break;

                default:
                    System.out.println("Estado inválido. Se asigna 'Programada'.");
                    this.Estado = "Programada";
                    break;
            }
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getAntecedentes() {
        return Antecedentes;
    }

    public void setAntecedentes(String Antecedentes) {
        this.Antecedentes = Antecedentes;
    }

    public String getSignosVitales() {
        return SignosVitales;
    }

    public void setSignosVitales(String SignosVitales) {
        this.SignosVitales = SignosVitales;
    }

    public String getExamenFisico() {
        return ExamenFisico;
    }

    public void setExamenFisico(String ExamenFisico) {
        this.ExamenFisico = ExamenFisico;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getPlan() {
        return Plan;
    }

    public void setPlan(String Plan) {
        this.Plan = Plan;
    }

    public String getResumenClinico() {
        return ResumenClinico;
    }

    public void setResumenClinico(String ResumenClinico) {
        this.ResumenClinico = ResumenClinico;
    }

    public Receta getReceta() {
        return Receta;
    }

    public void setReceta(Receta Receta) {
        this.Receta = Receta;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }
    
}