package finanmex.Licenciado.model;
import java.util.Date;


public class renovacion {
    private int id_Renovacion;
    private int id_acreedor;
    private boolean Status;
    private double saldo_restante;
    private double monto_solicitado;
    private int semanas_pagar;
    private Date fecha;
    private String Fecha;

    public renovacion() {
    }
    
    

    public renovacion(int id_acreedor, boolean Status, double saldo_restante, double monto_solicitado, int semanas_pagar, String Fecha) {
        this.id_acreedor = id_acreedor;
        this.Status = Status;
        this.saldo_restante = saldo_restante;
        this.monto_solicitado = monto_solicitado;
        this.semanas_pagar = semanas_pagar;
        this.Fecha = Fecha;
    }
    
    public renovacion(int id_Renovacion, int id_acreedor, boolean Status, double saldo_restante, double monto_solicitado, int semanas_pagar, Date fecha){
        this.id_Renovacion = id_Renovacion;
        this.id_acreedor = id_acreedor;
        this.Status = Status;
        this.saldo_restante = saldo_restante;
        this.monto_solicitado = monto_solicitado;
        this.semanas_pagar = semanas_pagar; 
    }
    
    public int getId_Renovacion(){
        return id_Renovacion;
    }
    
    public int getId_acreedor(){
        return id_acreedor;
    }
    
    public boolean getStatus(){
        return Status;
    }
    
    public double getSaldo_restante(){
        return saldo_restante;
    }
    
    public double getMonto_solicitado(){
        return monto_solicitado;
    }
    
    public int getSemanas_pagar(){
        return semanas_pagar;
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
    
    
    public void setId_Renovacion(int id_Renovacion){
        this.id_Renovacion = id_Renovacion;
    }
    
    public void setId_acreedor(int id_acreedor){
        this.id_acreedor = id_acreedor;
    }
    
    public void setStatus(boolean Status){
        this.Status = Status;
    }
    
    public void setSaldo_restante(double saldo_restante){
        this.saldo_restante =saldo_restante;
    }
    
    public void setMonto_solicitado(double monto_solicitado){
        this.monto_solicitado = monto_solicitado;
    }
    
    public void setSemanas_pagar(int semanas_pagar){
        this.semanas_pagar = semanas_pagar;
    }
}
