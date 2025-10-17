package finanmex.Licenciado.view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Movimiento extends JFrame{
    public JLabel Titulo, esp1,esp2;
    public JButton btnSalir;
    public JTable tabla;
    public String columnas[] = {"ID","Nombre","Tipo de movimiento","Saldo","Abono","Fecha","Semanas Restantes","Mora" };
    public DefaultTableModel modelo;
    
    public Movimiento(){
        setTitle("Movimientos del dia");
        setLayout(new BorderLayout());
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Titulo = new JLabel("    Historial de movimientos");
        Titulo.setFont(new Font("Arial",Font.BOLD,20));
        add(Titulo,BorderLayout.NORTH);
        esp1 = new JLabel("          ");
        esp2 = new JLabel("          ");
        add(esp1, BorderLayout.WEST);
        add(esp2, BorderLayout.EAST);
        
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        
        JPanel p = new JPanel();
        btnSalir = new JButton("     Salir     ");
        btnSalir.setFont(new Font("Arie",Font.BOLD,20));
        p.add(btnSalir);
        add(p, BorderLayout.SOUTH);
        
        
        setVisible(true);
        
    }
    
    public static void main(String [] Mex){
        Movimiento M = new Movimiento();
    }
}
