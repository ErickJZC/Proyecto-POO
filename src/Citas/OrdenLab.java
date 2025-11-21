/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Citas;

/**
 *
 * @author ALARCON
 */
public class OrdenLab {
    private String TomaMuestra;
    private String RealizacionEstudio;
    private String Resultado;
    private String Estado;
    private float PrecioOrden;

    public OrdenLab(String TomaMuestra, String RealizacionEstudio, String Estado, float PrecioOrden) {
        this.TomaMuestra = TomaMuestra;
        this.RealizacionEstudio = RealizacionEstudio;
        this.Estado = "Pendiente"; //incialmente sera pendiente
        this.PrecioOrden = PrecioOrden;
    }

    public String getTomaMuestra() {
        return TomaMuestra;
    }

    public void setTomaMuestra(String TomaMuestra) {
        this.TomaMuestra = TomaMuestra;
    }

    public String getRealizacionEstudio() {
        return RealizacionEstudio;
    }

    public void setRealizacionEstudio(String RealizacionEstudio) {
        this.RealizacionEstudio = RealizacionEstudio;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public float getPrecioOrden() {
        return PrecioOrden;
    }

    public void setPrecioOrden(float PrecioOrden) {
        this.PrecioOrden = PrecioOrden;
    }
    
    
}
