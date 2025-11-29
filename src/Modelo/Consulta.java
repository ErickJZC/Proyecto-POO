/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public class Consulta {
    private String fecha; // Formato yyyy/mm/dd
    private String motivo;
    private String antecedentes;
    private String signosVitales;
    private String examenFisico;
    private String diagnostico;
    private String plan;
    private Medico medico;

    public Consulta(String fecha, String motivo, String antecedentes, String signosVitales, String examenFisico, String diagnostico, String plan, Medico medico) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.antecedentes = antecedentes;
        this.signosVitales = signosVitales;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.plan = plan;
        this.medico = medico;
    }

    // Getters y Setters
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getAntecedentes() { return antecedentes; }
    public void setAntecedentes(String antecedentes) { this.antecedentes = antecedentes; }
    public String getSignosVitales() { return signosVitales; }
    public void setSignosVitales(String signosVitales) { this.signosVitales = signosVitales; }
    public String getExamenFisico() { return examenFisico; }
    public void setExamenFisico(String examenFisico) { this.examenFisico = examenFisico; }
    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    @Override
    public String toString() {
        // Formato para mostrar en la JList
        return "Fecha: " + fecha + " - Dr. " + medico.getApellidos();
    }
}