package finanmex.Licenciado.view;

import java.awt.Font;
import java.io.File;
import java.util.Date;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

public class AltasAval extends JFrame {
    SimpleDateFormat form =  new SimpleDateFormat("YYYY-MM-dd"); 
    public File selectFile;
    public Date fechaSelecionan;
    public String fecha;
    public JDateChooser dateChooser;
    public JLabel labelTitulo,labelNombre,labelApellido,labelParentesco,labelTelefono,labelDireccion,labelDocP,labelImagen, labelfecha,labelInfo,labelSubTitulo;
    public JTextField campoNombre,campoApellido,campoParentesco,campoTelefono,campoDireccion,txtRutaImagen;
    private JButton botonGuardar,botonCancelar,btnImagen;

    public AltasAval() {
        setTitle("Altas aval");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        labelSubTitulo = new JLabel("FINANMEX", SwingConstants.CENTER);
        labelSubTitulo.setFont(new Font("Arial", Font.BOLD, 18)); // Aumentar el tamaño de la letra
        labelSubTitulo.setBounds(450, 10, 150, 30);
        add(labelSubTitulo);

        labelTitulo = new JLabel("Registrar Avales", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        labelTitulo.setBounds(375, 40, 300, 30);
        add(labelTitulo);
       
        labelNombre = new JLabel("Nombres*:");
        labelNombre.setBounds(30, 80, 160, 30);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelNombre);
        
        campoNombre = new JTextField();
        campoNombre.setBounds(30, 110, 300, 30);
        add(campoNombre);
        
        labelApellido = new JLabel("Apellidos:");
        labelApellido.setBounds(360, 80, 160, 30);
        labelApellido.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelApellido);
        
        campoApellido = new JTextField();
        campoApellido.setBounds(360, 110, 300, 30);
        add(campoApellido);
        
        labelDireccion = new JLabel("Direcion:");
        labelDireccion.setBounds(30, 160, 160, 30);
        labelDireccion.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelDireccion);
        
        campoDireccion = new JTextField();
        campoDireccion.setBounds(30, 190, 300, 30);
        add(campoDireccion);
        
        labelTelefono = new JLabel("Telefono:");
        labelTelefono.setBounds(360, 160, 160, 30);
        labelTelefono.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelTelefono);
        
        campoTelefono = new JTextField();
        campoTelefono.setBounds(360, 190, 160, 30);
        add(campoTelefono);
        
        labelParentesco = new JLabel("Parentesco:");
        labelParentesco.setBounds(30, 240, 160, 30);
        labelParentesco.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelParentesco);

        campoParentesco = new JTextField();
        campoParentesco.setBounds(30, 270, 300, 30);
        add(campoParentesco);
        
        labelfecha = new JLabel("Fecha de nacimiento: ");
        labelfecha.setBounds(360, 240, 155, 30);
        labelfecha.setFont(new Font("Arial", Font.BOLD, 15));
        add(labelfecha);
        
        dateChooser = new JDateChooser(new Date());
        dateChooser.setBounds(360, 270, 250, 30);
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 15));
        
        add(dateChooser);
        fechaSelecionan = dateChooser.getDate();
        fecha = form.format(fechaSelecionan);

        
        
        btnImagen = new JButton("Insetar foto");
        btnImagen.setBounds(780, 50, 180, 40);
        btnImagen.setFont(new Font("Arial", Font.BOLD, 20));
        btnImagen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               JFileChooser File = new JFileChooser();
                int result = File.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION){
                   try {
                       selectFile = File.getSelectedFile();
                       txtRutaImagen.setText(selectFile.getCanonicalPath());
                       
                       
                       Image img = ImageIO.read(selectFile);
                       ImageIcon icon = new ImageIcon(img);
                       
                       int ancho = 200;
                       int alto = 300;
                       
                       Image ImagenEscalada = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                       labelImagen.setIcon(new ImageIcon(ImagenEscalada));
                   } catch (IOException ex) {
                       Logger.getLogger(AltasAcreedor.class.getName()).log(Level.SEVERE, null, ex);
                   }
                    
                        
                        
                        
                    
                }
            }
        
        });
        add(btnImagen);
        
        txtRutaImagen = new JTextField();
        txtRutaImagen.setBounds(780, 100, 180, 40);
        add(txtRutaImagen);
        
        
        labelImagen = new JLabel();
        labelImagen.setBounds(770, 150, 300, 300);
        add(labelImagen);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(125, 380, 120, 40);
        botonGuardar.setFont(new Font("Arial", Font.BOLD, 20));
        add(botonGuardar);
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(350, 380, 120, 40);
        botonCancelar.setFont(new Font("Arial", Font.BOLD, 20));
        add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuLicenciado MP = new MenuLicenciado();
               setVisible(false);
            }
        });
        add(botonCancelar);

        labelInfo = new JLabel("* Campos obligatorios");
        labelInfo.setBounds(30, 320, 150, 30);
        add(labelInfo);
        
        setVisible(true);
    }
    
    public String getCampoNombre(){
        return campoNombre.getText();
    }
    
    public String getCampoApellido(){
        return campoApellido.getText();
    }
    
    public String getCampoDireccion(){
        return campoDireccion.getText();
    }
    
    public String getCampoTelefono(){
        return campoTelefono.getText();
    }
    
    public String getCampoFecha(){
        return fecha;
    }
    
    public String getCampoImagen(){
        return txtRutaImagen.getText();
    }
    
    public String getCampoParentesco(){
        return campoParentesco.getText();
    }
    
    public void addAgregarAval(ActionListener listener){
        botonGuardar.addActionListener(listener);
    }
    
    public static void main(String [] MEX){
        AltasAval AA = new AltasAval();
    }
}