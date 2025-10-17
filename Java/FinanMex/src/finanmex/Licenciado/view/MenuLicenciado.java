package finanmex.Licenciado.view;


import finanmex.Licenciado.controller.AcreedorController;
import finanmex.Licenciado.controller.AvalController;
import finanmex.Licenciado.controller.CoordinadoraController;
import finanmex.Licenciado.controller.DevolucionController;
import finanmex.Licenciado.controller.PrestamoController;
import finanmex.Licenciado.controller.RenovacionController;
import finanmex.Licenciado.model.licenciado;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import finanmex.Licenciado.model.AcreedorDAO;
import finanmex.Licenciado.model.AvalDAO;
import finanmex.Licenciado.model.CoordinadoraDAO;
import finanmex.Licenciado.model.DevolucionDAO;
import finanmex.Licenciado.model.PrestamoDAO;
import finanmex.Licenciado.model.RenovacionDAO;

public class MenuLicenciado extends JFrame{
    Font Titulo = new Font(" ",Font.BOLD,20);
    Font Letras = new Font(" ",Font.BOLD,14);
    licenciado li = new licenciado();
    public String ids;
    // Nombramos las variables con su tipo y nombre
    // Los JLabel son solo texto lo que se mestra en la pantalla
    private JLabel labelTitulo,  labelCoordinadora;
    // Los JButton son los botones que agregamos en la pantalla
    private JButton btnAcreedor, btnPrestamo, btnRenovacion, btnAval, btnDevolucion,
    btnConsultas, btnImprimirRegistro, btnRestaurarContrasenas, btnCoordinadoras, btnMovimiento;
    
    
    
    public MenuLicenciado(){
        // En esta seccion le colocamos siertos valores a la ventana
        // Con el set Title le colocamos un titulo a la ventana
        setTitle("Menu principal");
        // Con el setDefaultCloseOperation le damos funcionamiento a la X de la esquina para cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Con el setSize le ponemos un tamaño a la ventana
        setSize(586, 450);
        // Con el setLocationRelativeTo nos sirve para colocar la ubicacion donde queremos que aparezca
        setLocationRelativeTo(null);
        // Con setLayout le colocamos un tipo de distribucion
        setLayout(null);
        // Con el setResizable que lo utilizamo para bloquear la modificacion del tamaño
        setResizable(false);
        
        // Se crea el un Label con sus respectivas propiedades
        labelTitulo = new JLabel("Menu Principal", SwingConstants.CENTER);
        // Le colocamos siertas propiedades a las letras
        labelTitulo.setFont(Titulo);
        // Le damos ubicacion y tamaño al label, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        labelTitulo.setBounds(210, 10, 150, 40);
        add(labelTitulo);
        
        btnAcreedor = new JButton("Acreedor");
        // Le colocamos siertas propiedades a las letras
        btnAcreedor.setFont(Letras);
        btnAcreedor.setBounds(30, 90, 150, 40);
        add(btnAcreedor);
        btnAcreedor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AltasAcreedor AA = new AltasAcreedor();
                setVisible(false);
                AcreedorDAO AD = new AcreedorDAO();
                AcreedorController IN = new AcreedorController(AA, AD);
                
            }
        });
        
        btnCoordinadoras = new JButton("Coordinadoras");
        // Le colocamos siertas propiedades a las letras
        btnCoordinadoras.setFont(Letras);
        btnCoordinadoras.setBounds(210, 90, 150, 40);
        add(btnCoordinadoras);
        btnCoordinadoras.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AltasCoordinadora AC = new AltasCoordinadora();
                setVisible(false);
                CoordinadoraDAO CD = new CoordinadoraDAO();
                CoordinadoraController CC = new CoordinadoraController(AC,CD);
                
                
            }
        });
        
        
        btnAval = new JButton("Aval");
        btnAval.setBounds(390, 90, 150, 40);
        // Le colocamos siertas propiedades a las letras
        btnAval.setFont(Letras);
        add(btnAval);
        btnAval.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AltasAval AA = new AltasAval();
                setVisible(false);
                AvalDAO AD = new AvalDAO();
                AvalController AC = new AvalController(AA,AD);
            }
        });
        
        btnPrestamo = new JButton("Prestamos");
        btnPrestamo.setBounds(30, 150, 150, 40);
        btnPrestamo.setFont(Letras);
        add(btnPrestamo);
        btnPrestamo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroPrestamo RP = new RegistroPrestamo();
                PrestamoDAO PD = new PrestamoDAO();
                PrestamoController PC = new PrestamoController(RP,PD);
                setVisible(false);
                
            }
        });
        
        btnRenovacion = new JButton("Renovacion");
        btnRenovacion.setBounds(210, 150, 150, 40);
        btnRenovacion.setFont(Letras);
        add(btnRenovacion);
        btnRenovacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroRenovacion RR = new RegistroRenovacion();
                setVisible(false);
                RenovacionDAO RD = new RenovacionDAO();
                RenovacionController RC = new RenovacionController(RR,RD);
                
            }
        });
        
        
        
        btnDevolucion = new JButton("Devolucion");
        btnDevolucion.setBounds(390, 150, 150, 40);
        btnDevolucion.setFont(Letras);
        add(btnDevolucion);
        btnDevolucion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroDevolucion RD = new RegistroDevolucion();
                DevolucionDAO DD = new DevolucionDAO();
                DevolucionController DC = new DevolucionController(RD,DD);
                setVisible(false);
                
            }
        });
        
        
        btnConsultas = new JButton("Consultas");
        btnConsultas.setBounds(133, 210, 150, 40);
        btnConsultas.setFont(Letras);
        add(btnConsultas);
        btnConsultas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuConsultas MC = new MenuConsultas();
                setVisible(false);
                
            }
        });
        
        btnImprimirRegistro = new JButton("Registros");
        btnImprimirRegistro.setBounds(303, 210, 150, 40);
        btnImprimirRegistro.setFont(Letras);
        add(btnImprimirRegistro);
        btnImprimirRegistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuRegistros MR = new MenuRegistros();
                setVisible(false);
                
            }
        });
        
        btnRestaurarContrasenas = new JButton("Restaurar Contraseña");
        btnRestaurarContrasenas.setBounds(208, 270, 170, 40);
        btnRestaurarContrasenas.setFont(new Font("", Font.BOLD, 12));
        add(btnRestaurarContrasenas);
        
        // Se crea el un Label con sus respectivas propiedades
        labelCoordinadora = new JLabel("Coordinadora: " , SwingConstants.RIGHT);
        // Le damos ubicacion y tamaño al label, setBounds(Izq o Der, Arr o Aba, Largo, Ancho)
        labelCoordinadora.setBounds(300, 330, 170, 30);
        add(labelCoordinadora);
        
        
        setVisible(true);
    }
    
    public void setIdenti(String ids){
        this.ids = ids;
    }
    
    public String getIdenti(){
        return this.ids;
    }

   public static void main (String [] Mex){
       MenuLicenciado MP = new MenuLicenciado();
   }
    
    
}
