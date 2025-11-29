/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Modelo.Consulta;
import Modelo.HistoriaClinica;
import Modelo.Orden;
import Modelo.Paciente;
import Modelo.Receta;
import java.util.HashMap;

/**
 *
 * @author ALARCON
 */
public class GestionHistoriasClinicas {
    private HashMap<Integer, HistoriaClinica> historias;

    public GestionHistoriasClinicas() {
        this.historias = new HashMap<>();
    }

    public HistoriaClinica getHistoriaClinica(Paciente paciente) {
        if (!historias.containsKey(paciente.getDNI())) {
            HistoriaClinica nuevaHistoria = new HistoriaClinica(paciente);
            historias.put(paciente.getDNI(), nuevaHistoria);
        }
        return historias.get(paciente.getDNI());
    }

    public void agregarConsulta(Paciente paciente, Consulta consulta) {
        HistoriaClinica historia = getHistoriaClinica(paciente);
        historia.agregarConsulta(consulta);
    }

    public void agregarReceta(Paciente paciente, Receta receta) {
        HistoriaClinica historia = getHistoriaClinica(paciente);
        historia.agregarReceta(receta);
    }

    public void agregarOrden(Paciente paciente, Orden orden) {
        HistoriaClinica historia = getHistoriaClinica(paciente);
        historia.agregarOrden(orden);
    }
}
