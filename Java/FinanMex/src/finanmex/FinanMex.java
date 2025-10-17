package finanmex;

import finanmex.Licenciado.controller.UsuarioController;
import finanmex.Licenciado.model.UsuarioDAO;
import finanmex.Licenciado.view.InicioSecion;
public class FinanMex {

    public static void main(String[] args) {
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Error al cargar el driver de Mysql");
            e.printStackTrace();
            return;
        }
         
        
         
         UsuarioDAO USD = new UsuarioDAO();
         InicioSecion IS = new InicioSecion();
         
        UsuarioController INC = new UsuarioController(IS, USD);
         
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            IS.setVisible(true);
            }
        });
    }
    
}
