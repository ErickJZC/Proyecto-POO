/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author erick
 */
public class GestionEmpleados {
    private Empleado[] Empleados;
    private int NroEmpleados;
    private Medico[] Medicos;
    private int NroMedicos;

    public GestionEmpleados() {
        this.Empleados = new Empleado[20];
        this.NroEmpleados = 0;
        this.Medicos = new Medico[20];
        this.NroMedicos = 0;
        
    }

    public Medico[] getMedicos() {
        return Medicos;
    }

    public void setMedicos(Medico[] Medicos) {
        this.Medicos = Medicos;
    }

    public int getNroMedicos() {
        return NroMedicos;
    }

    public void setNroMedicos(int NroMedicos) {
        this.NroMedicos = NroMedicos;
    }

    public Empleado[] getEmpleados() {
        return Empleados;
    }

    public void setEmpleados(Empleado[] Empleados) {
        this.Empleados = Empleados;
    }

    public int getNroEmpleados() {
        return NroEmpleados;
    }

    public void setNroEmpleados(int NroEmpleados) {
        this.NroEmpleados = NroEmpleados;
    }
    
    //Simple informacion
    public void VerInfo(){
        System.out.println("Numero de empleados: " + NroEmpleados);
        System.out.println("Empleados: ");
        for (int i = 0; i < NroEmpleados; i++) {
            Empleados[i].VerInfo();
            System.out.println("Posición: " + i);
            System.out.println("");
        }
        
        System.out.println("Numero de medicos: " + NroMedicos);
        System.out.println("Medicos");
        for (int i = 0; i < NroMedicos; i++) {
            Medicos[i].VerInfo();
            System.out.println("Posicion: " + i);
            System.out.println("");
        }
    }
    
    //METODOS//
    
    //BuscarEmpleado o Medico se usa para los metodos siguientes//
    public Empleado BuscarEmpleado(String DNI){
        for (int i = 0; i < NroEmpleados; i++) {
            if (Empleados[i].getDNI().equalsIgnoreCase(DNI)){
                return Empleados[i];
            }
        }
       
        return null;
        
    }
    
    public Medico BuscarMedico(String DNI){
        for (int i = 0; i < NroMedicos; i++) {
            if (Medicos[i].getDNI().equalsIgnoreCase(DNI)){
                return Medicos[i];
            }
        }
        return null;
    }
    
//Agregar Empleado o Medicos//
    
    public void AgregarEmpleado(Empleado Empleado){
        Empleados[NroEmpleados] = Empleado;
        NroEmpleados++;
    }
    
    public void AgregarEmpleado(Medico Medico){
        Medicos[NroMedicos] = Medico;
        NroMedicos++;
    }
    
//Eliminar Empleado o Medicos
    
    public void EliminarEmpleado(Empleado Empleado){
        for (int i = 0; i < NroEmpleados; i++) {
            if (Empleados[i] == Empleado){
                Empleados[i] = null;
                for (int j = i; j < NroEmpleados - 1; j++) {
                    Empleados[j] = Empleados[j + 1];
                    
                }
            }
            Empleados[NroEmpleados - 1] = null;
            NroEmpleados--;
        }
    }
    
    public void EliminarEmpleado(Medico Medico){
        for (int i = 0; i < NroEmpleados; i++) {
            if (Medicos[i] == Medico){
                Medicos[i] = null;
                for (int j = i; j < NroEmpleados - 1; j++) {
                    Medicos[j] = Medicos[j + 1];
                    
                }
            }
            Medicos[NroMedicos - 1] = null;
            NroMedicos--;
        }
    }
    
    //Modificar DNI//
    
    public void ModificarDNI(Empleado Empleado, String DNI){
        for (int i = 0; i < NroEmpleados; i++) {
            if(Empleados[i] == Empleado){
                Empleados[i].setDNI(DNI);
            }
        }
    }
    
    public void ModificarDNI(Medico Medico, String DNI){
        for (int i = 0; i < NroMedicos; i++) {
            if(Medicos[i] == Medico){
                Medicos[i].setDNI(DNI);
            }
        }
    }
    
    //Modificar Nombres//
    
    public void ModificarNombres(Empleado Empleado, String Nombres){
        for (int i = 0; i < NroEmpleados; i++) {
            if(Empleados[i] == Empleado){
                Empleados[i].setNombres(Nombres);
            }
        }
    }
    
    public void ModificarNombres(Medico Medico, String Nombres){
        for (int i = 0; i < NroMedicos; i++) {
            if(Medicos[i] == Medico){
                Medicos[i].setNombres(Nombres);
            }
        }
    }
    
    //Modificar Apellidos//
    
    public void ModificarApellidos(Empleado Empleado, String Apellidos){
        for (int i = 0; i < NroEmpleados; i++) {
            if(Empleados[i] == Empleado){
                Empleados[i].setApellidos(Apellidos);
            }
        }
    }
    
    public void ModificarApellidos(Medico Medico, String Apellidos){
        for (int i = 0; i < NroMedicos; i++) {
            if(Medicos[i] == Medico){
                Medicos[i].setApellidos(Apellidos);
            }
        }
    }
    
    //Modificar Rol//
    
    public void ModificarRol(Empleado Empleado, String ROL){
        for (int i = 0; i < NroEmpleados; i++) {
            if(Empleados[i] == Empleado){
                Empleados[i].setRol(ROL);
            }
        }
    }
    
    public void ModificarRol(Medico Medico, String ROL){
        for (int i = 0; i < NroMedicos; i++) {
            if(Medicos[i] == Medico){
                Medicos[i].setRol(ROL);
            }
        }
    }
    
    //Modificar datos de contacto
    
    public void ModificarDatosDeContacto(Empleado Empleado, String DatosDeContacto){
        for (int i = 0; i < NroEmpleados; i++) {
            if(Empleados[i] == Empleado){
                Empleados[i].setDatosDeContacto(DatosDeContacto);
            }
        }
    }
    
    public void ModificarDatosDeContacto(Medico Medico, String DatosDeContacto){
        for (int i = 0; i < NroMedicos; i++) {
            if(Medicos[i] == Medico){
                Medicos[i].setDatosDeContacto(DatosDeContacto);
            }
        }
    }
    
    //Modificar Especialidad (solo para medicos)
    
    public void ModificarEspecialidad(Medico Medico, String Especialidad){
        for (int i = 0; i < NroEmpleados; i++) {
            if(Medicos[i] == Medico){
               Medicos[i].setEspecialidad(Especialidad);
            }
        }
    }
}
