package finanmex.Licenciado.view;

import finanmex.Licenciado.model.HistorialDAO;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistorialAcreedor extends JFrame{
    HistorialDAO H= new HistorialDAO();
    public JLabel nombre,historial,tituloTabla1,tituloTabla2;
    public JPanel P1, P2, P3, P4;
    public JButton btnSalir;
    public JTable tablaPres, tablaDevo;
    public DefaultTableModel modeloTablaPres, modeloTablaDevo;
    public String columnasPres[] = {"ID", "Fecha", "Cantidad prestada", "Interes"};
    public String columnasDevo[] = {"ID", "Fecha", "Cantidad devuelta", "Mora"};
    
    public HistorialAcreedor(){
        setTitle("Historial acreedor");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,500);
        setLocationRelativeTo(null);
        setVisible(true);
        
        P1 = new JPanel(new GridLayout(1,2));
        historial = new JLabel("Historial acreedor");
        historial.setFont(new Font("Arieal", Font.BOLD, 20));
        nombre = new JLabel("Aqui va el nombre del acreedor");
        nombre.setFont(new Font("Arieal", Font.BOLD, 20));
        P1.add(historial);
        P1.add(nombre);    
        add(P1, BorderLayout.NORTH);
        
        P2 = new JPanel(new GridLayout(2,2));
        tituloTabla1 = new JLabel("Tabla Prestamo");
        tituloTabla1.setFont(new Font("Arieal", Font.BOLD, 10));
        P2.add(tituloTabla1);
        tablaPres = new JTable();
        H.MostrarPrestamo(tablaPres);
        tituloTabla2 = new JLabel("Tabla Devolucion");
        tituloTabla2.setFont(new Font("Arieal", Font.BOLD, 10));
        P2.add(tituloTabla2);
        

        P2.add(new JScrollPane(tablaPres));
        tablaDevo = new JTable();
        H.MostrarDevolucion(tablaDevo);
        P2.add(new JScrollPane(tablaDevo));
               
        
        
        add(P2, BorderLayout.CENTER);
        
        P3 = new JPanel();
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuConsultas  MC = new MenuConsultas();
               setVisible(false);
            }
        });
        
        P3.add(btnSalir);
        add(P3, BorderLayout.SOUTH);
        setVisible(true);
        
    }
    
    
    
    public static void main(String [] M){
        HistorialAcreedor Is = new HistorialAcreedor();
    }
}
