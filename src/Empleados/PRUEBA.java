/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Empleados;

/**
 *
 * @author erick
 */
public class PRUEBA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado Jose = new Empleado("09328248", "Jose Tobi", "Zapata Perez", "Recepcionista", "Numero: 922730435");
        GestionEmpleados Gestion = new GestionEmpleados();
        Medico Gabriel = new Medico("70531699", "Gabriel Merino", "Chavez Huerta", "Medico", " Numero: 907821872", "Cardiología");
        Empleado Paco = new Empleado("09324535", "Paco Poco", "Vilca Huaman", "Pendejo", "Numero: 904395535");
        
        Gestion.AgregarEmpleado(Jose);
        Gestion.AgregarEmpleado(Paco);
        Gestion.AgregarEmpleado(Gabriel);
        
        Gestion.VerInfo();
        Gestion.EliminarEmpleado(Gestion.BuscarEmpleado("09328248"));
        System.out.println("");
        
        Gestion.VerInfo();
        
        Gestion.ModificarNombres(Gestion.BuscarMedico("70531699"), "Gabriel Carrasco");
        
        System.out.println("");
        Gestion.VerInfo();
        
        Gabriel.VerInfo();
    }
    
   
}
