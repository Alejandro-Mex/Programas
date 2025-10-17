package finanmex.Licenciado.model;

import java.util.Date;

public class movimiento {
    private int id_movimiento;
    private String tipoMovimiento;
    private double saldo;
    private double abono;
    private Date fecha;
    private double SemanaRestantes;
    private double mora;
    private int id_devolucion;
    private int id_prestamo;
    private int id_acreedor;
    
    public movimiento(int id_movimiento, String tipoMovimiento, double saldo, double abono, Date fecha, double SemanaRestantes, double mora, int id_devolucion, int id_prestamo, int id_acreedor){
        this.id_movimiento = id_movimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.saldo = saldo;
        this.abono = abono;
        this.fecha = fecha;
        this.SemanaRestantes = SemanaRestantes;
        this.mora = mora;
        this.id_devolucion = id_devolucion;
        this.id_prestamo = id_prestamo;
        this.id_acreedor = id_acreedor;
    }
    
    public int getId_movimiento(){
        return id_movimiento;
    }
    
    public String getTipoMovimiento(){
        return tipoMovimiento;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public double getAbono(){
        return abono;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public double getSemanaRestantes(){
        return SemanaRestantes;
    }
    
    public double getMora(){
        return mora;
    }
    
    public int getId_devolucion(){
        return id_devolucion;
    }
    
    public int getId_prestamo(){
        return id_prestamo;
    }
    
    public int getId_acreedor(){
        return id_acreedor;
    }
    
    
    public void setId_movimiento(int id_movimiento){
        this.id_movimiento = id_movimiento;
    }
    
    public void setTipoMovimiento(String tipoMovimiento){
        this.tipoMovimiento = tipoMovimiento;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public void setAbono(double abono){
        this.abono = abono;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public void setSemanaRestantes(double SemanasRestantes){
        this.SemanaRestantes = SemanasRestantes;
    }
    
    public void setMora(double mora){
        this.mora = mora;
    }
    
    public void setId_devolucion(int id_devolucion){
        this.id_devolucion = id_devolucion;
    }
    
    public void setId_prestamo(int id_prestamo){
        this.id_prestamo = id_prestamo;
    }
    
    public void setId_acreedor(int id_acreedor){
        this.id_acreedor = id_acreedor;
    }
}
