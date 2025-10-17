package finanmex.Licenciado.model;

import java.util.Date;

public class prestamo {
    private int id_prestamo;
    private double monto;
    private double interes;
    private boolean estatus = false;
    private int semanaApagar;
    private Date fecha;
    private String Fecha;


    private double monto_total;
    private double abono_semanal;
    private double monto_interes;
    private int id_cordi;
    private int id_acreedor;
    private int id_aval;

    public prestamo(double monto, double interes, int semanaApagar, String Fecha, double monto_total, double abono_semanal, double monto_interes, int id_acreedor, int id_aval, boolean estatus) {
        this.monto = monto;
        this.interes = interes;
        this.semanaApagar = semanaApagar;
        this.Fecha = Fecha;
        this.monto_total = monto_total;
        this.abono_semanal = abono_semanal;
        this.monto_interes = monto_interes;
        this.id_acreedor = id_acreedor;
        this.id_aval = id_aval;
        this.estatus = false;
    }
    
    public prestamo(){
        
    }
    
    public prestamo(int id_prestamo, double monto, double interes, boolean estatus, int semanaApagar, Date fecha, double monto_total, double abono_semanal, double monto_interes, int id_cordi, int id_acreedor, int id_aval){
        this.id_prestamo = id_prestamo;
        this.monto = monto;
        this.interes = interes;
        this.estatus = estatus;
        this.semanaApagar = semanaApagar;
        this.fecha = fecha;
        this.monto_total = monto_total;
        this.abono_semanal = abono_semanal;
        this.monto_interes = monto_interes;
        this.id_cordi = id_cordi;
        this.id_acreedor = id_acreedor;
        this.id_aval = id_aval;
           
    }
    
    public int getId_prestamo(){
      return id_prestamo;  
    }
    
    public double getMonto(){
        return monto;
    }
    
    public double getInteres(){
        return interes;
    }
    
    public boolean getEstatus(){
        return estatus;
    }
    
    public int getSemanaApagra(){
        return semanaApagar;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public String getFechaS() {
        return Fecha;
    }
    
    public void setFechaS(String Fecha) {
        this.Fecha = Fecha;
    }
    
    public double getMonto_total(){
        return monto_total;
    }
    
    public double getAbono_semanal(){
        return abono_semanal;
    }
    
    public double getMonto_interes(){
        return monto_interes;
    }
    
    public int getId_cordi(){
        return id_cordi;
    }
    
    public int getId_acreedor(){
        return id_acreedor;
    }
    
    public int getId_aval(){
        return id_aval;
    }
    
    
    public void setId_prestamo(int id_prestamo){
        this.id_prestamo= id_prestamo;
    }
    
    public void setMonto(double monto){
        this.monto= monto;
    }
    
    public void setInteres(double interes){
        this.interes= interes;
    }
    
        public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public void setAbono_semanal(double abono_semanal) {
        this.abono_semanal = abono_semanal;
    }

    public void setMonto_interes(double monto_interes) {
        this.monto_interes = monto_interes;
    }
    
    public void setEstatus(boolean estatus){
        this.estatus= false;
    }
    
    public void setSemanaApagar(int semanasApagar){
        this.semanaApagar= semanasApagar;
    }
    
    public void setFecha(Date fecha){
        this.fecha= fecha;
    }
    
    public void setId_cordi(int id_coordinadora){
        this.id_cordi= id_coordinadora;
    }
    
    public void setId_acreedor(int id_acreedor){
        this.id_acreedor= id_acreedor;
    }
    
    public void setId_aval(int id_aval){
        this.id_aval= id_aval;
    }
    
    public double monto_Total(double monto,double monto_interes){
        monto_total = monto + monto_interes;
        return monto_total;
    }
    
    public double monto_interes(double interes,double monto){
        monto_interes = (interes / 100) * monto;
        return monto_interes;
    }
    
    public double Abono(double monto_total,int semanaApagar){
        abono_semanal = monto_total/semanaApagar;
        return abono_semanal;
    }
}
