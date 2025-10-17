package finanmex.Licenciado.view;


import finanmex.Licenciado.model.PrestamoDAO;
import finanmex.Licenciado.model.prestamo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistroPrestamo extends JFrame {
    SimpleDateFormat form =  new SimpleDateFormat("YYYY-MM-dd"); 
    Date fechaActual = new Date();
    String fecha;
    int id;
    prestamo p = new prestamo();
    PrestamoDAO PD = new PrestamoDAO();
    private JLabel labelAcreedor, labelMonto, labelSemanaPagar, labelInteres, labelDocumentos, labelAval, labelAbono,labelmontoInteres,labelTotal;
    private JCheckBox CheckBoxIne, CheckBoxCompDom;
    private JButton botonGuardar, botonCancelar, btnCalcular;
    private JTextField campoMonto, campoSemanaPagar, campoInteres, campoAbono, campomontoInteres,campoTotal,campoEstatus;
    private JComboBox<String> comboA, comboAval;

    public RegistroPrestamo() {
        setTitle("Restro prestamos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        
        labelAcreedor = new JLabel("Acreedor:");
        labelAcreedor.setBounds(30, 20, 160, 30);
        add(labelAcreedor);
        
        comboA = new JComboBox<>();
        PD.MostrarAcreedores(comboA);
        //comboA.setSelectedIndex(PD.getIdAcreedor());
        //id = (int) comboA.getClientProperty(comboA.getSelectedItem());
        comboA.setBounds(30, 50, 300, 22);
        add(comboA);
        
        labelTotal = new JLabel("Total a pagar:");
        labelTotal.setBounds(380, 20, 100, 22);
        add(labelTotal);
        
        campoTotal = new JTextField();
        campoTotal.setText(String.valueOf(p.getMonto_total()));
        campoTotal.setBounds(380, 50, 100, 22);
        campoTotal.setEnabled(false);
        add(campoTotal);
        
        labelMonto = new JLabel("Monto Solicitado:");
        labelMonto.setBounds(30, 70, 160, 30);
        add(labelMonto);
        
        campoMonto = new JTextField();
        campoMonto.setBounds(30, 95, 300, 22);
        add(campoMonto);
        
        labelAbono = new JLabel("Abono semanal:");
        labelAbono.setBounds(380, 70, 100, 30);
        add(labelAbono);
        
        campoAbono = new JTextField();
        campoAbono.setText(String.valueOf(p.getAbono_semanal()));
        campoAbono.setEnabled(false);
        campoAbono.setBounds(380, 100, 100, 22);
        add(campoAbono);
        
        labelmontoInteres = new JLabel("Monto de interes"); 
        labelmontoInteres.setBounds(380, 120, 100, 30);
        add(labelmontoInteres);
        
        campomontoInteres = new JTextField();
        campomontoInteres.setText(String.valueOf(p.getMonto_interes()));
        campomontoInteres.setEnabled(false);
        campomontoInteres.setBounds(380, 150, 100, 22);
        add(campomontoInteres);
        
        labelSemanaPagar = new JLabel ("Semana a pagar:");
        labelSemanaPagar.setBounds(30,120,160,30);
        add(labelSemanaPagar);
        
        campoSemanaPagar = new JTextField();
        campoSemanaPagar.setBounds(30,145,140,22);
        add(campoSemanaPagar);
        
        labelInteres = new JLabel ("Interes:");
        labelInteres.setBounds(205,120,150,30);
        add(labelInteres);
        
        campoInteres = new JTextField();
        
        campoInteres.setBounds(205, 145,140,22);
        add(campoInteres);
        
        labelDocumentos = new JLabel ("Documentos Presentados:");
        labelDocumentos.setBounds(50,170,160,30);
        add(labelDocumentos);
        
        CheckBoxIne = new JCheckBox("INE", false);
        CheckBoxIne.setBounds(40,200, 50, 30);
        add(CheckBoxIne);
        
        CheckBoxCompDom = new JCheckBox("Comprobante de Domicilio", false);
        CheckBoxCompDom.setBounds(100, 200, 200, 30);
        add(CheckBoxCompDom);
        
        labelAval = new JLabel ("Aval:");
        labelAval.setBounds(30, 240, 160, 30);
        add(labelAval);
        
        comboAval = new JComboBox<>();
        PD.MostrarAvales(comboAval);

        comboAval.setBounds(30, 270, 300, 22);
        add(comboAval);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 330, 100, 30);
        add(btnCalcular);
        btnCalcular.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                p.monto_Total(getCampoMonto(), p.monto_interes(getCampoInteres(), getCampoMonto()));
                campoTotal.setText(String.valueOf(p.getMonto_total()));
                p.Abono(p.monto_Total(getCampoMonto(), p.monto_interes(getCampoInteres(), getCampoMonto())), getCampoSemanaAPagar());
                campoAbono.setText(String.valueOf(p.getAbono_semanal()));
                p.monto_interes(getCampoInteres(), getCampoMonto());
                campomontoInteres.setText(String.valueOf(p.getMonto_interes()));
                  
                JOptionPane.showMessageDialog(null, "Listo los calculos");
            }
        });
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(250, 330, 100, 30);
        add(botonGuardar);
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(400, 330, 100, 30);
        add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuLicenciado MP = new MenuLicenciado();
               setVisible(false);
            }
        });
        
        campoEstatus = new JTextField();
        campoEstatus.setText(String.valueOf(p.getEstatus()));
        campoEstatus.setBounds(30, 350, 100, 20);
        
        
         /*ImageIcon icon = new ImageIcon("");
                       
                     int ancho = 200;
                       int alto = 300;
        Image Imagen = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        JLabel labelImagen = new JLabel();
        labelImagen.setBounds(770, 150, 300, 300);
        add(labelImagen);*/
        
        setVisible(true);
        
        
        
    }
    
    public double getCampoMonto(){
        return Double.parseDouble(campoMonto.getText());
    }
    
    public double getCampoInteres(){
        return Double.parseDouble(campoInteres.getText());
    }
    
    public int getCampoSemanaAPagar(){
        return Integer.parseInt(campoSemanaPagar.getText());
    }
    
    public int getAcreedor(){
        //return id;
        //return id = Integer.parseInt(PD.MostrarAcreedores(comboA).getClientProperty(PD.MostrarAcreedores(comboA).getSelectedItem()).toString());
        return Integer.parseInt(comboA.getSelectedItem().toString());
        //return comboA.getSelectedIndex();
    }
    
    public int getAval(){
        //return comboAval.getSelectedIndex();
        return Integer.parseInt(comboAval.getSelectedItem().toString());
    }
    
    public String getFecha(){
        fecha = form.format(fechaActual);
        return fecha;
    }
    
    public double getCampoTotal(){
        return Double.parseDouble(campoTotal.getText());
    }
    
    public double getCampoMontoInteres(){
        return Double.parseDouble(campomontoInteres.getText());
    }
    
    public double getCampoAbono(){
        return Double.parseDouble(campoAbono.getText());
    }
    
    public boolean getEstatus(){
        return false;
    }
    
    public void addAgregarPrestamo(ActionListener listender){
        botonGuardar.addActionListener(listender);
    }
    
    public static void main(String [] Mex){
        RegistroPrestamo RP = new RegistroPrestamo();
    }
}