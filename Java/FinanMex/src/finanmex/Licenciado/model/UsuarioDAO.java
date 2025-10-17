package finanmex.Licenciado.model;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import finanmex.Licenciado.view.InicioSecion;
import finanmex.Coordinadora.view.MenuCoordinadora;
import finanmex.Licenciado.view.MenuLicenciado;


public class UsuarioDAO {
    private Connection connection;
    public licenciado li;
    
    public UsuarioDAO(){
        conectar();
    }
    
    private void conectar(){
        String url ="jdbc:mysql://localhost:3306/finanmex";
        String password ="";
        String username ="root";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado por fin");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null,ex);
        } catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null,ex);
        }

    }

    public void Inicio(usuarios us){
        if(!us.getUsuario().equals("")||!us.getCodigo().equals("")){
            try{
                PreparedStatement ps = connection.prepareStatement("SELECT nivel FROM usuarios WHERE usuario = ? AND codigo = MD5(?);");
                ps.setString(1,us.getUsuario());
                ps.setString(2, us.getCodigo());
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    String nivel = rs.getString("nivel");
                    if(nivel.equalsIgnoreCase("Licenciado")){
                        MenuLicenciado MP = new MenuLicenciado();                
                    } else if (nivel.equalsIgnoreCase("Coordinadora")){
                        MenuCoordinadora MC = new MenuCoordinadora();
                    }
                } else {    
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                    InicioSecion IS = new InicioSecion();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {        
            JOptionPane.showMessageDialog(null, "Debe completar los datos");
            InicioSecion IS = new InicioSecion();
        }
    }
    
    /*public void Identificadorlicenciado(usuarios us){
        
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT id_usuarios FROM usuarios WHERE usuario = ? AND codigo = MD5(?)");
                ps.setString(1,us.getUsuario());
                ps.setString(2, us.getCodigo());
                ResultSet rs = ps.executeQuery();
                rs.next();
                int id = rs.getInt("id_usuarios");
                PreparedStatement as = connection.prepareStatement("SELECT apellidos FROM licenciados WHERE id_usuario = ?");
                as.setInt(1, id);
                ResultSet Ra = as.executeQuery();
                if(Ra.next()){
                    String idn = Ra.getString("apellidos");
                    li.setApellidos(idn);
                    System.out.println(idn);

                }  
                
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    
}
