/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALARCON
 */
public  class Consultorio {
    private int codigo;
    private String especialidad;
    private EstadoConsultorio estado;

    public Consultorio(int numero, String especialidad, EstadoConsultorio estado){
        if(numero <= 0){
            System.out.println("Número de habitación inválido.");
            this.codigo = 0;
        }else{
            this.codigo=numero;
        }
        this.especialidad=especialidad;
        this.estado=EstadoConsultorio.DISPONIBLE;
    }

    public void setCodigo(int numero) {
        this.codigo = codigo;
    }

    public void setEspecialidad(String tipo) {
        this.especialidad = especialidad;
    }

    public void setEstado(EstadoConsultorio estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public EstadoConsultorio getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Numero: " + codigo + ", Especialidad: " + especialidad + ", Estado de consultorio: " + estado;
    }
}
