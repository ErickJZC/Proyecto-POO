/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author ALARCON
 */
public class HistoriaClinica {
    private Paciente paciente;
    private ArrayList<Consulta> consultas;
    private ArrayList<Receta> recetas;
    private ArrayList<Orden> ordenes;

    public HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
        this.consultas = new ArrayList<>();
        this.recetas = new ArrayList<>();
        this.ordenes = new ArrayList<>();
    }

    public void agregarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }

    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }
}
