package finanmex.Licenciado.model;


import java.util.Date;

public class coordinadora {
    private int id_cordi;
    private String nombres;
    private String apellidos;
    private String fecha_nacimiento;
    private Date nacimiento;
    private String direccion;
    private String telefono;
    private String imagen;
    
    public coordinadora(){
        
    }
    
    public coordinadora (int id_cordi, String nombres, String apellidos, Date nacimiento, String direccion, String telefono, String imagen){
        this.id_cordi = id_cordi;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }
    
    public coordinadora(String nombres, String apellidos, String fecha_nacimiento, String direccion, String telefono, String imagen){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }
    
        public coordinadora(String nombres, String apellidos, String fecha_nacimiento, String direccion, String telefono, String imagen, int id_cordi){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.id_cordi = id_cordi;
    }
    
    public int getId_cordi(){
        return id_cordi;
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
    
    public String getImagen(){
        return imagen;
    }
    
    
    public void setId_cordi(int id_cordi){
        this.id_cordi = id_cordi;
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
            
}
