package finanmex.Licenciado.view;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Alejandro
 */
public class ModificarCoordinadora extends JFrame {
     private ConsultaAcreedores CA;
    SimpleDateFormat form =  new SimpleDateFormat("YYYY-MM-dd"); 
    public File selectFile;
    public Date fechaSelecionan,forma;
    public String fecha;
    public JDateChooser dateChooser;
    public JLabel labelTitulo, labelSubTitulo, labelNombre, labelApellido, 
    labelDirecion, labelTelefono, labelCorreo, labelfecha, labelImagen,labelImagen1;
    public JTextField campoNombre, campoApellido, campoDireccion, campoTelefono, campoCorreo, txtRutaImagen,txtId;
    public JButton botonCancelar, botonGuardar, btnImagen,btnListo;
    
    public ModificarCoordinadora(String ids,String nombre, String apellido, String direccion, String Telefono,String nacimiento,String ruta) {
        setTitle("Modificar coordinador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        txtId = new JTextField(ids);
        //txtId.setFont(new Font(" ",Font.BOLD,20));
        txtId.setBounds(30, 50, 200, 30);
        txtId.setEnabled(false);
        
        JLabel id = new JLabel("Identificador: " + ids);
        id.setFont(new Font(" ",Font.BOLD,20));
        id.setBounds(50, 30, 200, 30);
        add(id);

        labelTitulo = new JLabel("Modificar", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24)); // Aumentar el tamaño de la letra
        labelTitulo.setBounds(450, 10, 150, 30);
        add(labelTitulo);
        
        labelSubTitulo = new JLabel("FINANMEX", SwingConstants.CENTER);
        labelSubTitulo.setFont(new Font("Arial", Font.BOLD, 18)); // Aumentar el tamaño de la letra
        labelSubTitulo.setBounds(450, 50, 150, 30);
        add(labelSubTitulo);
        
        labelNombre = new JLabel("Nombre*:");
        labelNombre.setBounds(30, 80, 160, 30);
        labelNombre.setBounds(30, 80, 160, 30);
        add(labelNombre);
        
        campoNombre = new JTextField();
        campoNombre.setText(nombre);
        campoNombre.setBounds(30, 110, 300, 30);
        add(campoNombre);
        
        labelApellido = new JLabel("Apellidos:");
        labelApellido.setFont(new Font("Arial", Font.BOLD, 15));
        labelApellido.setBounds(360, 80, 160, 30);
        add(labelApellido);
        
        campoApellido = new JTextField();
        campoApellido.setText(apellido);
        campoApellido.setBounds(360, 110, 300, 30);
        add(campoApellido);
        
        labelDirecion = new JLabel("Direcion:");
        labelDirecion.setFont(new Font("Arial", Font.BOLD, 15));
        labelDirecion.setBounds(30, 160, 160, 30);
        add(labelDirecion);
        
        campoDireccion = new JTextField();
        campoDireccion.setText(direccion);
        campoDireccion.setBounds(30, 190, 300, 30);
        add(campoDireccion);
        
        labelTelefono = new JLabel("Telefono:");
        labelTelefono.setFont(new Font("Arial", Font.BOLD, 15));
        labelTelefono.setBounds(360, 160, 160, 30);
        add(labelTelefono);
        
        campoTelefono = new JTextField();
        campoTelefono.setText(Telefono);
        campoTelefono.setBounds(360, 190, 160, 30);
        add(campoTelefono);
        
        labelfecha = new JLabel("Fecha de nacimiento: ");
        labelfecha.setFont(new Font("Arial", Font.BOLD, 15));
        labelfecha.setBounds(30, 240, 160, 30);
        add(labelfecha);

        dateChooser = new JDateChooser(new Date());
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 15));
        dateChooser.setBounds(30, 270, 250, 25);
        System.out.println(nacimiento);
        add(dateChooser);

        try {
            forma = new SimpleDateFormat("yyyy-MM-dd").parse(nacimiento);
            dateChooser.setDate(forma);
        } catch (ParseException ex) {
            Logger.getLogger(ModificarAcreedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechaSelecionan = dateChooser.getDate();
        System.out.println(forma);
        fecha = form.format(fechaSelecionan);
        
        
        botonGuardar = new JButton("Modificar");
        botonGuardar.setFont(new Font("Arial", Font.BOLD, 20));
        botonGuardar.setBounds(250, 400, 130, 40);
        add(botonGuardar);
        
        btnListo = new JButton("Listo");
        btnListo.setFont(new Font("Arial", Font.BOLD, 20));
        btnListo.setBounds(590, 400, 130, 40);
        btnListo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaCoordinadora CC = new ConsultaCoordinadora();
                setVisible(false);
            }
            
        });
        add(btnListo);
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setFont(new Font("Arial", Font.BOLD, 20));
        botonCancelar.setBounds(420, 400, 130, 40);
        add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaAcreedores CA = new ConsultaAcreedores();
                setVisible(false);
            }
        });
        
        btnImagen = new JButton("Insetar foto");
        btnImagen.setFont(new Font("Arial", Font.BOLD, 20));
        btnImagen.setBounds(780, 50, 180, 40);
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
        
        ImageIcon icon = new ImageIcon(ruta);
                       
                     int ancho = 200;
                       int alto = 300;
        Image Imagen = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        txtRutaImagen = new JTextField();
        txtRutaImagen.setText(ruta);
        
         System.out.println(icon);
        txtRutaImagen.setBounds(780, 100, 180, 40);
        add(txtRutaImagen);
        
        
        labelImagen = new JLabel();
        labelImagen1 = new JLabel();
        labelImagen1.setIcon(new ImageIcon(Imagen));
        labelImagen.setBounds(770, 150, 300, 300);
        labelImagen1.setBounds(770, 150, 300, 300);
        add(labelImagen);
        add(labelImagen1);
        
        JLabel labelInfo = new JLabel("* Campos obligatorios");
        labelInfo.setBounds(30, 320, 150, 30);
        add(labelInfo);
        
        setVisible(true);
        
        
    }
    
    public int getID(){
        return Integer.parseInt(txtId.getText());
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
    
    /*public static void main(String [] Mex){
        ModificarAcreedor MA = new ModificarAcreedor(2);
    }
    */
    
    public void addActualizarCoordinadora(ActionListener listender){
        botonGuardar.addActionListener(listender);
        //ConsultaAcreedores CA = new ConsultaAcreedores();
        //setVisible(false);
    }
    
    public static void main(String [] Mex){
        ModificarCoordinadora MA = new ModificarCoordinadora("1","","","","","2004-04-09","");
    }
}
