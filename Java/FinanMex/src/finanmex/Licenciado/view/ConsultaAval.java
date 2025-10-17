package finanmex.Licenciado.view;

import finanmex.Licenciado.controller.AvalController;
import finanmex.Licenciado.model.AvalDAO;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ConsultaAval extends JFrame {
    AvalDAO AD = new AvalDAO();
    public JButton btnBorrar, btnEditar, btnSalir;
    public JTable tabla;
    public DefaultTableModel modeloTabla;
    public JLabel esp1,esp2;
    
    public ConsultaAval(){
        setTitle("Consulta de Avales");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel panelEntradas = new JPanel(new GridLayout(3, 2));
        JLabel labelTitulo = new JLabel("Consulta de Avales", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Ariel",Font.BOLD,20));
        panelEntradas.add(labelTitulo);
        
        tabla = new JTable();
        AD.MostrarAval(tabla);
        tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);

        
        JPanel panelBotones = new JPanel();

        btnBorrar = new JButton("Borrar");
        
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int id = tabla.getSelectedRow();
                int ids = Integer.parseInt(tabla.getValueAt(id, 0).toString());
                String idst = tabla.getValueAt(id, 0).toString();
                String nombre = tabla.getValueAt(id, 1).toString();
                String apellido = tabla.getValueAt(id, 2).toString();
                String fecha = tabla.getValueAt(id, 3).toString();                
                String direccion = tabla.getValueAt(id, 4).toString();
                String telefono = tabla.getValueAt(id, 5).toString();
                String parentesco = tabla.getValueAt(id, 6).toString();
                String ruta = tabla.getValueAt(id, 7).toString();
                
                ModificarAval MA = new ModificarAval(idst,nombre,apellido,fecha,direccion,telefono,parentesco,ruta);
                AvalDAO AD = new AvalDAO();
                AvalController AC = new AvalController(MA,AD);
                setVisible(false);
            }
        });
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuConsultas  MC = new MenuConsultas();
               setVisible(false);
               
            }
        });
        panelBotones.add(btnBorrar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnSalir);


        add(panelEntradas, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        esp1 = new JLabel("          ");
        esp2 = new JLabel("          ");
        add(esp1, BorderLayout.WEST);
        add(esp2, BorderLayout.EAST);


        setVisible(true);
    }
    
    public int getSelect(){
        int selecion = tabla.getSelectedRow();
        int id = Integer.parseInt(tabla.getValueAt(selecion, 0).toString());
        if(id >= 0){
            return id;
            
        }
        return -1;
    }
    
    public void addEliminarAval(ActionListener listender){
        btnBorrar.addActionListener(listender);
    }
    
    public static void main(String [] MEX){
        ConsultaAval CA = new ConsultaAval();
    }
}