package finanmex.Licenciado.model;

public class usuarios {
   private int id_usuarios;
   private String usuario;
   private String codigo;
   private String nivel;
   
   public usuarios(){
       
   }
   
   public usuarios(String usuario, String codigo){
       this.usuario = usuario;
       this.codigo = codigo;
   }
   
   public int getId_usurio(){
       return id_usuarios;
   }
   
   public String getUsuario(){
       return usuario;
   }
   
   public String getCodigo(){
       return codigo;
   }
   public String getNivel(){
       return nivel;
   }
   
   
   public void setId_usuarios(int id_usuarios){
       this.id_usuarios = id_usuarios;
   }
   
   public void setUsuario(String usuario){
       this.usuario = usuario;
   }
   
   public void setCodigo(String codigo){
       this.codigo = codigo;
   }
   
   public void setNivel(String nivel){
       this.nivel = nivel;
   }
}
