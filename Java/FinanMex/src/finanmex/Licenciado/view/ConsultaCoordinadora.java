/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finanmex.Licenciado.view;

import finanmex.Licenciado.controller.CoordinadoraController;
import finanmex.Licenciado.model.CoordinadoraDAO;
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

public class ConsultaCoordinadora extends JFrame{
    CoordinadoraDAO CD = new CoordinadoraDAO();
    public JButton btnBorrar, btnEditar, btnSalir;
    public JTable tabla;
    public DefaultTableModel modeloTabla;
    public JLabel esp1,esp2;
    
    public ConsultaCoordinadora(){
        setTitle("Consulta de coordinadora");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tabla = new JTable();
        CD.MostrarCoordinadoras(tabla);
        tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        
        JPanel panelEntradas = new JPanel(new GridLayout(3, 2));
        JLabel labelTitulo = new JLabel("Consulta de coordinadora", SwingConstants.CENTER);
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
                String fecha = tabla.getValueAt(id, 3).toString();
                String direccion = tabla.getValueAt(id, 4).toString();
                String telefono = tabla.getValueAt(id, 5).toString();
                String ruta = tabla.getValueAt(id, 6).toString();
                
                
                
                ModificarCoordinadora MC = new ModificarCoordinadora(idst,nombre,apellido,direccion,telefono,fecha,ruta);
                CoordinadoraDAO CD = new CoordinadoraDAO();
                CoordinadoraController CC = new CoordinadoraController(MC,CD);
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
    
    public void addEliminarCoordinadora(ActionListener listender){
        btnBorrar.addActionListener(listender);
    }
    
    public static void main(String [] MEX){
        ConsultaCoordinadora CC = new ConsultaCoordinadora();
    }
    
}
