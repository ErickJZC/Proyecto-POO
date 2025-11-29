/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Gestion.GestionCitas;
import Gestion.GestionConsultorios;
import Gestion.GestionEmpleados;
import Gestion.GestionFacturacion;
import Gestion.GestionHistoriasClinicas;
import Gestion.GestionPacientes;
import javax.swing.JFrame;
import javax.swing.JPanel;
import GUI.LoginPanel;
import Modelo.Administrador;
import Modelo.Cajero;
import Modelo.Cita;
import Modelo.Consulta;
import Modelo.Consultorio;
import Modelo.Empleado;
import Modelo.Enfermero;
import Modelo.EstadoCita;
import Modelo.EstadoConsultorio;
import Modelo.Medico;
import Modelo.ModalidadCita;
import Modelo.Orden;
import Modelo.Paciente;
import Modelo.Recepcionista;
import static Modelo.RolEmpleado.CAJERO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author erick
 */
public class MainFrame extends JFrame {

    private GestionEmpleados gestionEmpleados;
    private GestionConsultorios gestionConsultorios;
    private GestionCitas gestionCitas;
    private GestionPacientes gestionPacientes;
    private GestionHistoriasClinicas gestionHistorias;
    private GestionFacturacion gestionFacturacion;

    public MainFrame() {
        gestionEmpleados = new GestionEmpleados();
        gestionConsultorios = new GestionConsultorios();
        gestionCitas = new GestionCitas();
        gestionPacientes = new GestionPacientes();
        gestionHistorias = new GestionHistoriasClinicas();
        gestionFacturacion = new GestionFacturacion();

        prepararDatosDePrueba();

        setTitle("Sistema de Gestión Clínica");
        setSize(1000, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarLoginPanel();
    }

    public void mostrarLoginPanel() {
        LoginPanel loginPanel = new LoginPanel(this);
        setContentPane(loginPanel);
        revalidate();
        repaint();
    }

    public void login(int dni, String password) {
        Empleado empleado = gestionEmpleados.autenticar(dni, password);

        if (empleado != null) {
            mostrarHomePanel(empleado);
        } else {
            JOptionPane.showMessageDialog(this, "DNI o contraseña incorrectos.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarHomePanel(Empleado empleado) {
        JPanel homePanel;

        switch (empleado.getRolEmpleado()) {
            case ADMINISTRADOR:
                homePanel = new AdminPanel(
                        this,
                        gestionEmpleados,
                        gestionConsultorios,
                        gestionCitas,
                        gestionFacturacion,
                        empleado
                );
                break;
            case RECEPCIONISTA:
                homePanel = new RecepcionistaPanel(
                        this,
                        gestionCitas,
                        gestionConsultorios,
                        gestionPacientes,
                        gestionEmpleados
                );
                break;
            default:
                return;
        }

        setContentPane(homePanel);
        revalidate();
        repaint();
    }

    private void prepararDatosDePrueba() {
        gestionEmpleados.crearEmpleado(new Administrador(11111111, "Admin", "Principal", "admin"));
        gestionEmpleados.crearEmpleado(new Recepcionista(22222222, "Recep", "Cionista", "recep"));
        Medico medico1 = new Medico(33333333, "Carlos", "Cardio", "medico", "Cardiología");
        gestionEmpleados.crearEmpleado(medico1);
        gestionEmpleados.crearEmpleado(new Cajero(55555555, "Cajero", "Uno", "caja"));
        gestionEmpleados.crearEmpleado(new Enfermero(66666666, "Javier", "Enfermero", "enfer"));

        Consultorio consultorio1 = new Consultorio(101, "Cardiología", EstadoConsultorio.DISPONIBLE);
        gestionConsultorios.crearConsultorio(consultorio1);

        Paciente paciente1 = new Paciente(71234567, "Juan", "Perez", "1990/05/15", "Masculino", "987654321", "juan.perez@email.com", "Maria Perez");
        gestionPacientes.crearPaciente(paciente1);

        Cita citaAtendida = new Cita("2024/05/21 11:00", medico1, consultorio1, paciente1, ModalidadCita.PRESENCIAL);
        citaAtendida.setEstado(EstadoCita.ATENDIDA);
        gestionCitas.getCitas().add(citaAtendida);

        gestionHistorias.agregarConsulta(paciente1, new Consulta("2024/05/21", "Dolor de pecho", "Hipertensión", "PA: 140/90", "Normal", "Angina", "Reposo", medico1));
        gestionHistorias.agregarOrden(paciente1, new Orden("2024/05/21", "Laboratorio", "Perfil lipídico", medico1));

        gestionFacturacion.crearFactura(citaAtendida, 75.0, "Tarjeta");
    }
}
