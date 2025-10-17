package finanmex.Licenciado.view;
// Importamos las clases necesarias para las variables que usamos
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InicioSecion extends JFrame{ 
    // Nombramos las variables con su tipo y nombre
    // Los JLabel son solo texto lo que se mestra en la pantalla
    public JLabel labelTitulo, labelUsuario, labelContrasena;
    // Los JTextField nos sirven insertar texto 
    public JTextField campoUsuario;
    // Lo mismo que el anterior solo que oculta el testo que se escribe
    public JPasswordField campoContrasena;
    // Los JButton son los botones que agregamos en la pantalla
    public JButton botonLogin;
    
    public InicioSecion() {
        // En esta seccion le colocamos siertos valores a la ventana
        // Con el set Title le colocamos un titulo a la ventana
        setTitle("Inicio de sesion");
        // Con el setDefaultCloseOperation le damos funcionamiento a la X de la esquina para cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Con el setSize le ponemos un tamaño a la ventana
        setSize(500, 300);
        // Con el setLocationRelativeTo nos sirve para colocar la ubicacion donde queremos que aparezca
        setLocationRelativeTo(null);
        // Con setLayout le colocamos un tipo de distribucion
        setLayout(null);
        // Con el setResizable que lo utilizamo para bloquear la modificacion del tamaño
        setResizable(false);
        
        // Se crea el un Label con sus respectivas propiedades
        labelTitulo = new JLabel("FinanMex", SwingConstants.CENTER);
        labelTitulo.setFont(new Font(" ",Font.BOLD,20));
        // Le damos ubicacion y tamaño al label, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        labelTitulo.setBounds(175, 10, 150, 30);
        // Agregamos el label a la ventana
        add(labelTitulo);
        
        // Se crea el un Label con sus respectivas propiedades
        labelUsuario = new JLabel("Usuario:");
        labelUsuario.setFont(new Font(" ",Font.BOLD,20));
        // Le damos ubicacion y tamaño al label, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        labelUsuario.setBounds(50, 60, 120, 30);
        // Agregamos el label a la ventana
        add(labelUsuario);
        
        // Creamos el TextField donde podemos ingresar los datos
        campoUsuario = new JTextField(100);
        campoUsuario.setFont(new Font(" ",Font.ROMAN_BASELINE,15));
        // Le damos ubicacion y tamaño al TextField, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        campoUsuario.setBounds(180, 60, 200, 30);
        // Agregamos el label a la ventana
        add(campoUsuario);
        
        // Se crea el un Label con sus respectivas propiedades
        labelContrasena = new JLabel("Contraseña:");
        labelContrasena.setFont(new Font(" ",Font.BOLD,20));
        // Le damos ubicacion y tamaño al label, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        labelContrasena.setBounds(50, 100, 120, 30);
        // Agregamos el label a la ventana
        add(labelContrasena);
        
        // Creamos el PassworField donde colocaremso la contraseña deñ usuario
        campoContrasena = new JPasswordField(100);
        campoContrasena.setFont(new Font(" ",Font.ROMAN_BASELINE,15));
        // Le damos ubicacion y tamaño al PasswordField, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        campoContrasena.setBounds(180, 100, 200, 30);
        // Agregamos el label a la ventana
        add(campoContrasena);
        
        // Creamos el boton que se utiliza para poder acceder al menu principal
        botonLogin = new JButton("Iniciar sesion");
        botonLogin.setFont(new Font(" ",Font.BOLD,18));
        // Le damos ubicacion y tamaño al Button, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        botonLogin.setBounds(175, 160, 150, 50);
        // Agregamos el label a la ventana
        add(botonLogin);
        
        // Con el setVisible lo utilizamos para poder ver la pantalla
        setVisible(true);
        
    }
    
    /*Para poder extraer el usuario y contraseña debemos crear un gets con los que mandamos lo
    que pogamos en el JTextField*/
    // Este get manda el usuario que ingresamos en el JTextField
    public String getCampoUsuario(){
        // Con el getText leemos el dato puesto en el campo de usuario
        return campoUsuario.getText();
    }
    
    // Este get manda la contraseña que ingresasmos en el JPassworField
    public String getCampoContrasena(){
        // // Con el getText leemos el dato puesto en el campo de contraseña
        return campoContrasena.getText();
    }
    
    // Con este le damos fucionabilidad a el boton de inicio
    public void addInicio(ActionListener listener){
        botonLogin.addActionListener(listener);
    }
    
    public static void main(String [] Mex){
        InicioSecion Is = new InicioSecion();
    }

}