/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Modelo.Cita;
import Modelo.EstadoCita;
import Modelo.Factura;
import Modelo.HistoriaClinica;
import Modelo.Orden;
import java.util.ArrayList;

/**
 *
 * @author ALARCON
 */
public class GestionFacturacion {

    private ArrayList<Factura> facturas;

    private static final double PRECIO_CONSULTA = 50.0;
    private static final double PRECIO_ORDEN_LABORATORIO = 25.0;
    private static final double PRECIO_ORDEN_IMAGEN = 75.0;

    public GestionFacturacion() {
        this.facturas = new ArrayList<>();
    }

    public double calcularTotal(Cita cita, HistoriaClinica historia) {
        double total = PRECIO_CONSULTA;

        if (historia != null) {
            for (Orden orden : historia.getOrdenes()) {
                if (orden.getFecha().equals(cita.getFechaHora().substring(0, 10))) {
                    if (orden.getTipo().equals("Laboratorio")) {
                        total += PRECIO_ORDEN_LABORATORIO;
                    } else if (orden.getTipo().equals("Imagen")) {
                        total += PRECIO_ORDEN_IMAGEN;
                    }
                }
            }
        }
        return total;
    }

    public Factura crearFactura(Cita cita, double total, String metodoPago) {
        Factura nuevaFactura = new Factura(
                cita.getFechaHora().substring(0, 10),
                cita.getPaciente(),
                total,
                metodoPago,
                cita
        );
        facturas.add(nuevaFactura);

        cita.setEstado(EstadoCita.COMPLETADA);

        return nuevaFactura;
    }
    
    public static double getPRECIO_CONSULTA() {
        return PRECIO_CONSULTA;
    }

    public static double getPRECIO_ORDEN_LABORATORIO() {
        return PRECIO_ORDEN_LABORATORIO;
    }

    public static double getPRECIO_ORDEN_IMAGEN() {
        return PRECIO_ORDEN_IMAGEN;
    }

    public ArrayList<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }
}
