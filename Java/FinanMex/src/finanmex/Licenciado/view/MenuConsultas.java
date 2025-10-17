package finanmex.Licenciado.view;
import finanmex.Licenciado.controller.AcreedorController;
import finanmex.Licenciado.controller.AvalController;
import finanmex.Licenciado.controller.CoordinadoraController;
import finanmex.Licenciado.controller.PrestamoController;
import finanmex.Licenciado.controller.RenovacionController;
import finanmex.Licenciado.controller.UsuarioController;
import finanmex.Licenciado.model.AcreedorDAO;
import finanmex.Licenciado.model.AvalDAO;
import finanmex.Licenciado.model.CoordinadoraDAO;
import finanmex.Licenciado.model.PrestamoDAO;
import finanmex.Licenciado.model.RenovacionDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuConsultas extends JFrame{
    
    public MenuConsultas(){
        setTitle("Menu consultas");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel labelTitulo = new JLabel("Menu de Consultas", SwingConstants.CENTER);
        labelTitulo.setBounds(175, 10, 250, 30);
        add(labelTitulo);
        
        JButton botonConsultaAcreedor = new JButton("Consultas Acreedor");
        botonConsultaAcreedor.setBounds(80, 60, 200, 40);
        add(botonConsultaAcreedor);
        botonConsultaAcreedor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaAcreedores CA = new ConsultaAcreedores();
                
                setVisible(false);
                AcreedorDAO AD = new AcreedorDAO();
                AcreedorController ISN = new AcreedorController(CA,AD);
            }
            
        });
           
     
        
        
        
        JButton botonConsultaRenovacion = new JButton("Consultas Renovacion");
        botonConsultaRenovacion.setBounds(80, 180, 200, 40);
        add(botonConsultaRenovacion);
        botonConsultaRenovacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaRenovacion CR = new ConsultaRenovacion();
                setVisible(false);
                RenovacionDAO AD = new RenovacionDAO();
                RenovacionController ISN = new RenovacionController(CR,AD);
            }
            
        });
        
        JButton botonConsultaAval = new JButton ("Consultas Aval");
        botonConsultaAval.setBounds(350, 60, 200, 40);
        add(botonConsultaAval);
        botonConsultaAval.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaAval CA = new ConsultaAval();
                setVisible(false);
                AvalDAO AD = new AvalDAO();
                AvalController AC = new AvalController(CA,AD);
            }
            
        });
        
        JButton botonConsultaCoordinadora = new JButton ("Consultas Coordinadoras");
        botonConsultaCoordinadora.setBounds(80, 120, 200, 40);
        add(botonConsultaCoordinadora);
        botonConsultaCoordinadora.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ConsultaCoordinadora CC = new ConsultaCoordinadora();
                setVisible(false);
                CoordinadoraDAO CD = new CoordinadoraDAO();
                CoordinadoraController C = new CoordinadoraController(CC,CD);
            }
        });
        
        JButton botonConsultaDevolucion = new JButton ("Consultas Devoluciones");
        botonConsultaDevolucion.setBounds(350, 120, 200, 40);
        add(botonConsultaDevolucion);
        botonConsultaDevolucion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ConsultaDevoluciones CD = new ConsultaDevoluciones();
                setVisible(false);
            }
        });
        
        JButton botonConsultaPrestamo = new JButton("Consultas Prestamo");
        botonConsultaPrestamo.setBounds(350, 180, 200, 40);
        add(botonConsultaPrestamo);
        botonConsultaPrestamo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ConsultaPrestamos CP = new ConsultaPrestamos();
                setVisible(false);
                PrestamoDAO PD = new PrestamoDAO();
                PrestamoController PC = new PrestamoController(CP,PD);
            }
        });
        
        JButton botonHistorialAcreedor = new JButton ("Historial Acreedor");
        botonHistorialAcreedor.setBounds(225, 250, 200, 40);
        add(botonHistorialAcreedor);
        botonHistorialAcreedor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                HistorialAcreedor HA = new HistorialAcreedor();
                setVisible(false);
            }
        });
        
        JButton botonSalir = new JButton ("Salir");
        botonSalir.setBounds(265, 320, 100, 40);
        add(botonSalir);
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuLicenciado MP = new MenuLicenciado();
               setVisible(false);
            }
        });
        setVisible(true);
    }
    public static void main(String [] Mex){
        MenuConsultas MC = new MenuConsultas();
    }
    
}
