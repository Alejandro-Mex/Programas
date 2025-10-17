package finanmex.Licenciado.view;

import finanmex.Licenciado.controller.AcreedorController;
import finanmex.Licenciado.model.AcreedorDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ConsultaAcreedores extends JFrame {
    AcreedorDAO AD = new AcreedorDAO();
    public JButton btnBorrar, btnEditar, btnSalir;
    public JTable tabla;
    public DefaultTableModel modeloTabla;
    public JLabel esp1,esp2;

    public ConsultaAcreedores() {
        setTitle("Consulta de Acreedores");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        tabla = new JTable();
        AD.MostrarAcreedores(tabla);
        tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        
        
        
        JPanel panelEntradas = new JPanel(new GridLayout(3, 2));
        JLabel labelTitulo = new JLabel("Consulta de acreedores", SwingConstants.CENTER);
        panelEntradas.add(labelTitulo);

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
                String direccion = tabla.getValueAt(id, 3).toString();
                String telefono = tabla.getValueAt(id, 4).toString();
                String correo = tabla.getValueAt(id, 5).toString();
                String fecha = tabla.getValueAt(id, 6).toString();
                String ruta = tabla.getValueAt(id, 7).toString();
                
                
                
                ModificarAcreedor MA = new ModificarAcreedor(idst,nombre,apellido,direccion,telefono,correo,fecha,ruta);
                AcreedorDAO AD = new AcreedorDAO();
                AcreedorController AC = new AcreedorController(MA,AD);
                setVisible(false);
                System.out.println(ids);
                System.out.println(getSelect());
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
        /*
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"Id", "Nombre", "Apellidos","Correo", "Telefono", "Direccion", "Fecha de nacimiento"});
        modeloTabla.addRow(new Object[]{A.getId_acreedor(),A.getNombres(),A.getApellidos(),A.getCorreo(),A.getTelefono(),A.getDireccion(),A.getNacimiento()});
        */
        
        
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
    
    public void addEliminarAcreedor(ActionListener listender){
        btnBorrar.addActionListener(listender);
        
    }
    
    public void showError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String [] MEX){
        ConsultaAcreedores CA = new ConsultaAcreedores();
    }
}