package finanmex.Licenciado.model;

import java.util.Date;


public class acreedor {
    private int id_acreedor;
    private String nombres;
    private String apellidos;
    private String correo;
    private String fecha_nacimiento;
    private Date nacimiento;
    private String direccion;
    private String telefono;
    private String imagen;
    private int id_cordi;
    
    public acreedor(){
        
    }
    
    public acreedor(int id_acreedor, String nombres, String apellidos, String correo, String telefono, String direccion, Date nacimiento){
        this.id_acreedor = id_acreedor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;

    }
    
    public acreedor(String nombres, String apellidos, String correo, String fecha_nacimiento, String direccion, String telefono, String imagen){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }
    
    public acreedor(String nombres, String apellidos, String correo, String fecha_nacimiento, String direccion, String telefono, String imagen,int id_acreedor){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.id_acreedor = id_acreedor;
    }
    public int getId_acreedor(){
        return id_acreedor;
    }
    
    public String getNombres(){
        return nombres;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public String getFecha_nacimiento(){
        return fecha_nacimiento;
    }
    
    public Date getNacimiento(){
        return nacimiento;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public String getImagen (){
        return imagen;
    }
    
    public int getId_cordi(){
        return id_cordi;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    
    public void setId_acreedor(int id_acreedor){
        this.id_acreedor = id_acreedor;
    }
    
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public void setFecha_nacimiento(String fecha_nacimiento){
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public void setNacimiento(Date nacimiento){
        this.nacimiento = nacimiento;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    public void setId_cordi(int id_cordi){
        this.id_cordi = id_cordi;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
}
