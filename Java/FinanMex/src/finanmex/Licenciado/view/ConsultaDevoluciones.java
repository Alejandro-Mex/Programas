package finanmex.Licenciado.view;
import finanmex.Licenciado.model.DevolucionDAO;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class ConsultaDevoluciones extends JFrame{
    DevolucionDAO PD = new DevolucionDAO();
    public JButton btnBorrar, btnModificar, btnSalir;
    public JTable tabla;
    public String columnas[] = {"Id","Nombres","Abono","Saldo restante","Semanas restantes", "Mora"};
    public JLabel Devoluciones, esp1, esp2;
    public DefaultTableModel modeloTabla;

    public ConsultaDevoluciones(){
        setTitle("Consulta devoluciones");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,500);
        setLocationRelativeTo(null);
        setVisible(true);

        Devoluciones= new JLabel("   Consultas devoluciones");
        Devoluciones.setBounds(100, 100, 150, 300);
        Devoluciones.setFont(new Font("Ariel", Font.BOLD,20));
        
        tabla = new JTable();
        PD.MostrarDevolucion(tabla);
        /*
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(columnas);
        tabla = new JTable(modeloTabla);
        */
        JPanel botones = new JPanel();
        botones.add(btnBorrar = new JButton("   Borrar   "));
        btnBorrar.setFont(new Font("Arie",Font.BOLD,20));
        
        botones.add(btnSalir = new JButton("   Salir   "));
        btnSalir.setFont(new Font("Arie",Font.BOLD,20));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuConsultas  MC = new MenuConsultas();
               setVisible(false);
            }
        });
        
        
        add(esp1 = new JLabel("          "), BorderLayout.WEST);
        add(esp2 = new JLabel("          "), BorderLayout.EAST);
        add(Devoluciones, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
        
        setVisible(true);
        
    }
    public void addEliminarDevolucion(ActionListener listener){
        btnBorrar.addActionListener(listener);
    }
    public static void main(String [] Mex){
        ConsultaDevoluciones CD = new ConsultaDevoluciones();
    }

}

