/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pacientes;

/**
 *
 * @author erick
 */
public class GestionPacientes {
    private Paciente[] Pacientes;
    private int NroPacientes;

    public GestionPacientes() {
        Pacientes = new Paciente[50];
        NroPacientes = 0;
    }

    public Paciente[] getPacientes() {
        return Pacientes;
    }

    public void setPacientes(Paciente[] Pacientes) {
        this.Pacientes = Pacientes;
    }

    public int getNroPacientes() {
        return NroPacientes;
    }

    public void setNroPacientes(int NroPacientes) {
        this.NroPacientes = NroPacientes;
    }
    
    //Metodos//
    public void AgregarPaciente(Paciente Paciente){
        Pacientes[NroPacientes] = Paciente;
        NroPacientes++;
    }
    
    public Paciente BuscarPaciente(String DNI){
        for (int i = 0; i < NroPacientes; i++) {
            if(Pacientes[i].getDNI().equalsIgnoreCase(DNI)){
                return Pacientes[i];
            }
        }
        return null;
    }
    
    public void EliminarPaciente(Paciente Paciente){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i] = null;
                for (int j = i; j < NroPacientes - 1; j++) {
                    Pacientes[j] = Pacientes[j + 1];
                    
                }
                Pacientes[NroPacientes - 1] = null;
                NroPacientes--;
                break;
            }
            
        }
    }
    
    public void ModificarDNI(Paciente Paciente, String DNI){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i].setDNI(DNI);
                break;
            }
            
        }
    }
    
    public void ModificarNombres(Paciente Paciente, String Nombres){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i].setNombres(Nombres);
                break;
            }
            
        }
    }
    
    public void ModificarApellidos(Paciente Paciente, String Apellidos){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i].setApellidos(Apellidos);
                break;
            }
            
        }
    }
    
    public void ModificarFechaNacimiento(Paciente Paciente, String FechaNacimiento){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i].setFechaNacimiento(FechaNacimiento);
                break;
            }
            
        }
    }
    
    public void ModificarSexo(Paciente Paciente, String Sexo){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i].setSexo(Sexo);
                break;
            }
            
        }
    }
    
    public void ModificarDatosDeContacto(Paciente Paciente, String DatosDeContacto){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i].setDatosDeContacto(DatosDeContacto);
                break;
            }
            
        }
    }
    
    public void ModificarContactoDeEmergencia(Paciente Paciente, String ContactoDeEmergencia){
        for (int i = 0; i < NroPacientes; i++) {
            if (Pacientes[i] == Paciente){
                Pacientes[i].setContactoDeEmergencia(ContactoDeEmergencia);
                break;
            }
            
        }
    }
}
