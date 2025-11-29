/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Modelo.Consultorio;
import Modelo.EstadoConsultorio;
import java.util.ArrayList;

/**
 *
 * @author ALARCON
 */
public class GestionConsultorios {
    private ArrayList<Consultorio> consultorios;

    public GestionConsultorios() {
        consultorios = new ArrayList<>();
    }

    public ArrayList<Consultorio> getConsultorios() {
        return consultorios;
    }

    public Consultorio buscarPorCodigo(Integer codigo) {
        for (Consultorio consultorio : consultorios) {
            if (codigo == consultorio.getCodigo()) {
                return consultorio;
            }
        }
        return null;
    }

    public ArrayList<Consultorio> buscarPorEspecialidad(String especialidad) {
        ArrayList<Consultorio> consultoriosPorEspecialidad = new ArrayList<>();
        for (Consultorio consultorio : consultorios) {
            if (consultorio.getEspecialidad() == especialidad) {
                consultoriosPorEspecialidad.add(consultorio);
            }
        }
        return consultoriosPorEspecialidad;
    }

    public boolean crearConsultorio(Consultorio consultorio) {
        if (buscarPorCodigo(consultorio.getCodigo()) != null) {
            System.err.println("Error: Ya existe una habitación con el número " + consultorio.getCodigo());
            return false;
        }
        consultorios.add(consultorio);
        return true;
    }

    public boolean modificarConsultorio(Integer numero, String tipo, Integer capacidadMaxima, Double precioPorNoche, EstadoConsultorio estadoConsultorio, Integer nuevoCodigo) {
        Consultorio habitacion = buscarPorCodigo(numero);
        if (habitacion == null) {
            return false;
        }

        if (nuevoCodigo != null && !nuevoCodigo.equals(numero) && buscarPorCodigo(nuevoCodigo) != null) {
            System.err.println("Error: El nuevo número de habitación ya está en uso.");
            return false;
        }

        if (tipo != null) habitacion.setEspecialidad(tipo);
        if (estadoConsultorio != null) habitacion.setEstado(estadoConsultorio);
        if (nuevoCodigo != null) habitacion.setCodigo(nuevoCodigo);

        return true;
    }

    public boolean eliminarConsultorio(Integer codigo) {
        Consultorio consultorio = buscarPorCodigo(codigo);
        if (consultorio != null) {
            consultorios.remove(consultorio);
            return true;
        }
        return false;
    }

    public void listarConsultorios() {
        for (Consultorio consultorio : consultorios) {
            System.out.println(consultorio);
        }
    }

    public void generarReporteOcupacion() {
        System.out.println("--- Reporte de Ocupación de Habitaciones ---");
        if (consultorios.isEmpty()) {
            System.out.println("No hay habitaciones registradas en el hotel.");
            return;
        }

        int disponibles = 0;
        int ocupadas = 0;
        int enMantenimiento = 0;

        for (Consultorio consultorio : consultorios) {
            System.out.println(" - Habitación " + consultorio.getCodigo() + ": " + consultorio.getEstado());
            switch (consultorio.getEstado()) {
                case DISPONIBLE:
                    disponibles++;
                    break;
                case OCUPADO:
                    ocupadas++;
                    break;
                case MANTENIMIENTO:
                    enMantenimiento++;
                    break;
            }
        }

        System.out.println("\n--- Resumen de Ocupación ---");
        System.out.println("Total de Habitaciones: " + consultorios.size());
        System.out.println("Ocupadas: " + ocupadas);
        System.out.println("Disponible: " + disponibles);
        System.out.println("En Mantenimiento: " + enMantenimiento);
    }
}
