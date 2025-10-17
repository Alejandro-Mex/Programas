package finanmex.Licenciado.model;

import java.util.Date;

public class devolucion {
    private int id_devolucion;
    private double abono;
    private double mora;
    private int semanaPagada;
    private Date fecha;
    private String fechas;
    private double SaldoRestante;
    private int SemanasRestantes;
    private int id_cordi;
    private int id_prestamo;
    private int id_acreedor;

    public devolucion() {
    }
    
    public devolucion(int id_devolucion, double abono, double mora, int semanaPagada, Date fecha, double SaldoRestante, int SemanasRestantes, int id_cordi, int id_prestamo, int id_acreedor ){
        this.id_devolucion = id_devolucion;
        this.abono = abono;
        this.mora = mora;
        this.semanaPagada = semanaPagada;
        this.fecha = fecha;
        this.SaldoRestante = SaldoRestante;
        this.SemanasRestantes = SemanasRestantes;
        this.id_cordi = id_cordi;
        this.id_prestamo = id_prestamo;
        this.id_acreedor = id_acreedor;
    }
    
    public devolucion(double abono,double mora,int semanaPagada,String fechas,double SaldoRestante,int SemanasRestantes,int id_acreedor){
        this.abono = abono;
        this.mora = mora;
        this.semanaPagada = semanaPagada;
        this.fechas = fechas;
        this.SaldoRestante = SaldoRestante;
        this.SemanasRestantes = SemanasRestantes;
        this.id_acreedor = id_acreedor;
    }
    
    public int getId_devolucion(){
        return id_devolucion;
    }
    
    public double getAbono(){
        return abono;
    }
    
    public double getMora(){
        return mora;
    }
    
    public int getSemanaPagada(){
        return semanaPagada;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public double getSaldoRestante(){
        return SaldoRestante;
    }
    
    public int getSemanasRestantes(){
        return SemanasRestantes;
    }
    
    public int getId_cordi(){
        return id_cordi;
    }
    
    public int getId_prestamo(){
        return id_prestamo;
    }
    
    public int getId_acreedor(){
        return id_acreedor;
    }
    
    public String getFechas(){
        return fechas;
    }
    
    
    public void setId_devolucion(int id_devolucion){
        this.id_devolucion = id_devolucion;
    }
    
    public void setAbono(double abono){
        this.abono = abono;
    }
    
    public void setMora(double mora){
        this.mora = mora;
    }
    
    public void setSemanaPagada(int semanaPagada){
        this.semanaPagada = semanaPagada;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public void setSaldoRestante(double SaldoRestante){
        this.SaldoRestante = SaldoRestante;
    }
    
    public void setSemanasRestantes(int SemanasRestantes){
        this.SemanasRestantes = SemanasRestantes;
    }
    
    public void setId_cordi(int id_coordinadora){
        this.id_cordi = id_coordinadora;
    }
    
    public void setId_prestamo(int id_prestamo){
        this.id_prestamo = id_prestamo;
    }
    
    public void setId_acreedor(int id_acreedor){
        this.id_acreedor = id_acreedor;
    }
    
    public void setFechas(String fechas){
        this.fechas = fechas;
    }
}
