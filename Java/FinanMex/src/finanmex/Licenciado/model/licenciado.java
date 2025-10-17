package finanmex.Licenciado.model;


import java.util.Date;

public class licenciado {
   private int id_licenciado;
   private String nombres;
   private String apellidos;
   private Date fecha_nacimiento;
   private String direccion;
   private String telefono;
   private int id_usuario;
   
   public licenciado(){
       
   }
   public licenciado(String apellidos){
       this.apellidos = apellidos;
       
   }
   
   public licenciado(int id_licenciado, String nombres, String apellidos, Date fecha_nacimiento, String direccion, String telefono,int id_usuario){
      this.id_licenciado = id_licenciado;
      this.nombres = nombres;
      this.apellidos = apellidos;
      this.fecha_nacimiento = fecha_nacimiento;
      this.direccion = direccion;
      this.telefono = telefono;
      this.id_usuario = id_usuario;
   }
   
   public int getId_licenciado(){
       return id_licenciado;
   }
   
   public String getNombres(){
       return nombres;
   }
   
   public String getApellidos(){
       return apellidos;
   }
   
   public Date getFecha_Nacimiento(){
       return fecha_nacimiento;
   }
   
   public String getDireccion(){
       return direccion;
   }
   
   public String getTelefono(){
       return telefono;
   }
   
   public int getId_usuario(){
       return id_usuario;
   }
   
   public void setId_licenciados(int id_licenciado){
       this.id_licenciado = id_licenciado;
   }
   
   public void setNombres(String nombres){
       this.nombres = nombres;
   }
   
   public void setApellidos(String apellidos){
       this.apellidos = apellidos;
   }
   
   public void setFecha_nacimiento(Date fecha_nacimiento){
       this.fecha_nacimiento =fecha_nacimiento;
   }
   
   public void setDireccion(String direccion){
       this.direccion = direccion;
   }
   
   public void setTelefono(String telefono){
       this.telefono = telefono;
   }
   
   public void setId_usuario(int id_usuario){
       this.id_usuario = id_usuario;
   }
}
