package finanmex.Licenciado.view;

import finanmex.Licenciado.model.RenovacionDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ConsultaRenovacion extends JFrame {
    RenovacionDAO RD = new RenovacionDAO();
    public JButton btnBorrar, btnEditar, btnSalir;
    public JTable tabla;
    public DefaultTableModel modeloTabla;
    
    public ConsultaRenovacion(){
        setTitle("Consulta de Renovaciones");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelEntradas = new JPanel(new GridLayout(3, 2));
        JLabel labelTitulo = new JLabel("Consulta de Renovaciones", SwingConstants.CENTER);
        panelEntradas.add(labelTitulo);

        JPanel panelBotones = new JPanel();

        btnBorrar = new JButton("Borrar");
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuConsultas  MC = new MenuConsultas();
               setVisible(false);
            }
        });
        panelBotones.add(btnBorrar);
        panelBotones.add(btnSalir);
        tabla = new JTable();
        RD.MostrarRenovacion(tabla);
        /*
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"Id", "Acreedor", "Status", "Monto Solicitado", "Monto Restante", "Interes"});
        tabla = new JTable(modeloTabla);
        */

        add(panelEntradas, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);


        setVisible(true);
    }
    
    public void addEliminarRenovacion(ActionListener listener){
        btnBorrar.addActionListener(listener);
    }
    
    public static void main(String [] Mex){
        ConsultaRenovacion CR = new ConsultaRenovacion();
    }
    
}
