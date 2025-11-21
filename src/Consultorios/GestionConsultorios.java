/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultorios;

/**
 *
 * @author erick
 */
public class GestionConsultorios {
    private Consultorio[] Consultorios;
    private int NroConsultorios;
    private HorarioDeAtencion[] HorariosDeAtencion;
    private int NroHorariosDeAtencion;

    public GestionConsultorios() {
        this.Consultorios = new Consultorio[20];
        this.NroConsultorios = 0;
        this.HorariosDeAtencion = new HorarioDeAtencion[20];
        this.NroHorariosDeAtencion = 0;
    }

    public Consultorio[] getConsultorios() {
        return Consultorios;
    }

    public void setConsultorios(Consultorio[] Consultorios) {
        this.Consultorios = Consultorios;
    }

    public int getNroConsultorios() {
        return NroConsultorios;
    }

    public void setNroConsultorios(int NroConsultorios) {
        this.NroConsultorios = NroConsultorios;
    }

    public HorarioDeAtencion[] getHorariosDeAtencion() {
        return HorariosDeAtencion;
    }

    public void setHorariosDeAtencion(HorarioDeAtencion[] HorariosDeAtencion) {
        this.HorariosDeAtencion = HorariosDeAtencion;
    }

    public int getNroHorariosDeAtencion() {
        return NroHorariosDeAtencion;
    }

    public void setNroHorariosDeAtencion(int NroHorariosDeAtencion) {
        this.NroHorariosDeAtencion = NroHorariosDeAtencion;
    }
    
    //Metodos//
    
    public void AgregarConsultorio(Consultorio Consultorio){
        Consultorios[NroConsultorios] = Consultorio;
        NroConsultorios++;
        
    }
    
    public Consultorio BuscarConsultorio(String Codigo){
        for (int i = 0; i < NroConsultorios; i++) {
            if(Consultorios[i].getCodigo().equalsIgnoreCase(Codigo)){
                return Consultorios[i];
            }
                
        }
        return null;
    }
    
    public void EliminarConsultorio(Consultorio Consultorio){
        for (int i = 0; i < NroConsultorios; i++) {
            if (Consultorios[i] == Consultorio){
                Consultorios[i] = null;
                for (int j = i; j < NroConsultorios - 1; j++) {
                    Consultorios[j] = Consultorios[j + 1];
                    
                }
                Consultorios[NroConsultorios - 1] = null;
                NroConsultorios--;
                break;
            }
            
        }
    }
    
    public void ModificarCodigo(Consultorio Consultorio, String Codigo){
        for (int i = 0; i < NroConsultorios; i++) {
            if(Consultorios[i] == Consultorio){
                Consultorios[i].setCodigo(Codigo);
                break;
            }
            
        }
    }
    
    public void ModificarEspecialidad(Consultorio Consultorio, String Especialidad){
        for (int i = 0; i < NroConsultorios; i++) {
            if(Consultorios[i] == Consultorio){
                Consultorios[i].setEspecialidad(Especialidad);
                break;
            }
            
        }
    }
    
    public void ModificarEstado(Consultorio Consultorio, String Estado){
        for (int i = 0; i < NroConsultorios; i++) {
            if(Consultorios[i] == Consultorio){
                Consultorios[i].setEstado(Estado);
                break;
            }
            
        }
    }
    
    public void AgregarHorarioDeAtencion(HorarioDeAtencion HorarioDeAtencion){
        HorariosDeAtencion[NroHorariosDeAtencion] = HorarioDeAtencion;
        NroHorariosDeAtencion++;
    }
    
    
}
