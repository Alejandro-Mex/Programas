package finanmex.Licenciado.controller;
// Importamos las clases necesarias para las variables que usamos

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import finanmex.Licenciado.model.usuarios;
import finanmex.Licenciado.view.InicioSecion;
import finanmex.Licenciado.model.UsuarioDAO;

public class UsuarioController {
    // Nombramos las variables que utilizaremos para conectar la vista con la fucionabilidad del boton 
    private usuarios us;
    private InicioSecion Is;
    private UsuarioDAO UsD;    
    
    // Construcctor conde madamos la vista y los datos del usuario
    public UsuarioController(InicioSecion Is,UsuarioDAO UsD){
        this.Is = Is;
        this.UsD = UsD;
        this.Is.addInicio(new Inicio());

    }
    
    // Creamos la clase donde le indicamos al boton lo que tiene que hacer y los datos que debe utilizar
    class Inicio implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            // Con este madamos los datos extraidos de la vista y se los mandamos al DAO para que haga sus acciones
            UsD.Inicio(new usuarios(Is.getCampoUsuario(),Is.getCampoContrasena()));
            Is.setVisible(false);
            //UsD.Identificadorlicenciado(new usuarios(Is.getCampoUsuario(),Is.getCampoContrasena()));
            
        }
        
    }
    
    
    
    

    
}
