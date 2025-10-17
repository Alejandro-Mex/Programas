package finanmex.Licenciado.model;

import java.util.Date;

public class historial {
    private int id_prestamo;
    private Date fecha;
    private String Fecha;
    private double cantidadPrestada;
    private double interes;
    private int id_devolucion;
    private double cantidadDevuelta;
    private double mora;
    
    

    public historial(int id_prestamo, Date fecha, String Fecha, double cantidadPrestada, double interes, int id_devolucion, double cantidadDevuelta, double mora) {
        this.id_prestamo = id_prestamo;
        this.fecha = fecha;
        this.Fecha = Fecha;
        this.cantidadPrestada = cantidadPrestada;
        this.interes = interes;
        this.id_devolucion = id_devolucion;
        this.cantidadDevuelta = cantidadDevuelta;
        this.mora = mora;
    }
    
    public historial(){
        
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaS() {
        return Fecha;
    }

    public void setFechaS(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getCantidadPrestada() {
        return cantidadPrestada;
    }

    public void setCantidadPrestada(double cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public double getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    public void setCantidadDevuelta(double cantidadDevolucion) {
        this.cantidadDevuelta = cantidadDevolucion;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }
    
    
    
}
