package finanmex.Licenciado.model;

import java.util.Date;


public class aval {
    private int id_aval;
    private String nombres;
    private String apellidos;
    private Date nacimiento;
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String parentesco;
    private String imagen;
    private int id_acreedor;
    
    public aval(){
        
    }
    
    public aval(int id_aval, String nombres, String apellidos, String direccion, String telefono, String imagen, String parentesco, Date nacimiento){
        this.id_aval = id_aval;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.parentesco = parentesco;
        
    }
    
    public aval(String nombres,String apellidos,String fecha_nacimiento,String direccion,String telefono,String parentesco,String imagen){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.parentesco = parentesco;

    }
    
    public aval(String nombres,String apellidos,String fecha_nacimiento,String direccion,String telefono,String imagen,String parentesco,int id_aval){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.parentesco = parentesco;
        this.id_aval = id_aval;
    }
    
    public int getId_aval(){
        return id_aval;
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
      
    public String getParentesco(){
        return parentesco;
    }
    
    public String getImagen(){
        return imagen;
    }
  
    public int getId_acreedor(){
        return id_acreedor;
    }
    
    
    public void setId_aval(int id_aval){
        this.id_aval = id_aval;
    }
    
    public void setNombres( String nombres){
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
    
    public void setParentesco(String parentesco){
        this.parentesco = parentesco;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    public void setId_acreedor(int id_acreedor){
        this.id_acreedor = id_acreedor;
    }
}
