
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Vista_Animal extends JFrame {
    Font FTitulo = new Font("Arial",Font.BOLD,24);
    Font FDatos = new Font("Arial",Font.BOLD,20);
    Font txt = new Font("Arial",Font.TYPE1_FONT,18);
    public File selectFile;
    public JDateChooser CFechaNacimiento;
    private JLabel Folio,Raza,NumeroArete,FechaNacimiento,Procedencia,Peso,color
            ,Caracter,Foto,Especie,Propietario,Sexo,Rancho,Empleado,Titulo,SubtituloAnimal,SubtituloCaracteristicas,SubtituloPropietario;
    public JTextField txtFolio, txtRaza,txtNumeroArete,txtFechaNacimiento,txtPeso
            ,txtColor,txtFoto;
    public JTextArea txtProcedencia;
    public JComboBox jcbEspecie,jcbPropietario,jcbSexo,jcbRancho,jcbEmpleado;
    private String[] ListaEspecies={"Bovino","Porcino","Ovinos","Caprinos"},ListaPropietarios={"Maria Tec","Jesus Mex","Alondra Ramos"}
            ,ListaSexo={"Hembra","Macho"},ListaRancho={"La esperanza","La niña"},ListaEmpleados={"Leticia Coh","Alejandro Damian","Guadalupe Perez"};
    private JButton btnAceptar,btnSalir,btnLimpiar;
    
    public Vista_Animal(){
        setTitle("Regitro de animales");
        setSize(900,800);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Titulo = new JLabel("Registro de animal para SDA",SwingConstants.CENTER);
        Titulo.setFont(FTitulo);
        Titulo.setBounds(275, 10, 350, 25);
        add(Titulo);
        
        SubtituloAnimal = new JLabel("Datos de identificaicion del animal");
        SubtituloAnimal.setFont(FDatos);
        SubtituloAnimal.setBounds(20, 60, 400, 20);
        add(SubtituloAnimal);
        
        Folio = new JLabel("Folio:");
        Folio.setFont(FDatos);
        Folio.setBounds(20,110,80,20);
        add(Folio);
        
        txtFolio = new JTextField();
        txtFolio.setFont(txt);
        txtFolio.setBounds(20, 140, 150, 25);
        add(txtFolio);
        
        NumeroArete = new JLabel("Numero de arete:");
        NumeroArete.setFont(FDatos);
        NumeroArete.setBounds(220, 110, 170, 20);
        add(NumeroArete);
        
        txtNumeroArete = new JTextField();
        txtNumeroArete.setFont(txt);
        txtNumeroArete.setBounds(220,140 , 200, 25);
        add(txtNumeroArete);
        
        Foto = new JLabel("Direccion de la Foto:");
        Foto.setFont(FDatos);
        Foto.setBounds(440, 110, 200, 20);
        add(Foto);
        
        txtFoto = new JTextField();
        txtFoto.setFont(txt);
        txtFoto.setBounds(440, 140, 300, 25);
        add(txtFoto);
        
        JButton Insertar = new JButton("Insertar imagen");
        Insertar.setFont(new Font("Arial",Font.BOLD,20));
        Insertar.setBounds(440, 170, 200, 25);
        Insertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser File = new JFileChooser();
                int result = File.showOpenDialog(null);
                try {
                       selectFile = File.getSelectedFile();
                       txtFoto.setText(selectFile.getCanonicalPath());
                       
                       
                       Image img = ImageIO.read(selectFile);
                       ImageIcon icon = new ImageIcon(img);
                       

                   } catch (IOException ex) {
                       Logger.getLogger(Vista_Animal.class.getName()).log(Level.SEVERE, null, ex);
                   }
            }
        
        
        });
        add(Insertar);
        
        SubtituloCaracteristicas = new JLabel("Datos de caracteristicas fisicas del animal:");
        SubtituloCaracteristicas.setFont(FDatos);
        SubtituloCaracteristicas.setBounds(20, 245, 450, 20);
        add(SubtituloCaracteristicas);
        
        Raza = new JLabel("Raza:");
        Raza.setFont(FDatos);
        Raza.setBounds(20, 295, 100, 20);
        add(Raza);
        
        txtRaza = new JTextField();
        txtRaza.setFont(txt);
        txtRaza.setBounds(20, 325, 150, 25);
        add(txtRaza);
        
        Peso = new JLabel("Peso:");
        Peso.setFont(FDatos);
        Peso.setBounds(200, 295, 75, 20);
        add(Peso);
        
        txtPeso = new JTextField();
        txtPeso.setFont(txt);
        txtPeso.setBounds(200, 325, 100, 25);
        add(txtPeso);
        
        color = new JLabel("Color:");
        color.setFont(FDatos);
        color.setBounds(330, 295, 100, 20);
        add(color);
        
        txtColor = new JTextField();
        txtColor.setFont(txt);
        txtColor.setBounds(330, 325, 100, 25);
        add(txtColor);
        
        Sexo = new JLabel("Sexo:");
        Sexo.setFont(FDatos);
        Sexo.setBounds(460, 295, 100, 25);
        add(Sexo);
        
        jcbSexo = new JComboBox<String>(ListaSexo);
        jcbSexo.setFont(txt);
        jcbSexo.setBounds(460, 325, 200, 25);
        add(jcbSexo);
        
        Especie = new JLabel("Especies:");
        Especie.setFont(FDatos);
        Especie.setBounds(20, 380, 100, 25);
        add(Especie);
        
        jcbEspecie = new JComboBox<String>(ListaEspecies);
        jcbEspecie.setFont(txt);
        jcbEspecie.setBounds(20, 410, 150, 25);
        add(jcbEspecie);
        
        FechaNacimiento = new JLabel("Fecha de Nacimiento:");
        FechaNacimiento.setFont(FDatos);
        FechaNacimiento.setBounds(200, 380, 250, 25);
        add(FechaNacimiento);
        
        CFechaNacimiento = new JDateChooser(new Date());
        CFechaNacimiento.setFont(txt);
        CFechaNacimiento.setBounds(200, 410, 250, 25);
        add(CFechaNacimiento);

        SubtituloPropietario = new JLabel("Datos del propietario del animal:");
        SubtituloPropietario.setFont(FDatos);
        SubtituloPropietario.setBounds(20, 480, 400, 20);
        add(SubtituloPropietario);
        
        Propietario = new JLabel("Propietarios:");
        Propietario.setFont(FDatos);
        Propietario.setBounds(20, 530, 150, 25);
        add(Propietario);
        
        jcbPropietario = new JComboBox<String>(ListaPropietarios);
        jcbPropietario.setFont(txt);
        jcbPropietario.setBounds(20, 560, 200, 25);
        add(jcbPropietario);
        
        Rancho = new JLabel("Rancho:");
        Rancho.setFont(FDatos);
        Rancho.setBounds(250, 530, 100, 25);
        add(Rancho);
        
        jcbRancho = new JComboBox<String>(ListaRancho);
        jcbRancho.setFont(txt);
        jcbRancho.setBounds(250, 560, 200, 25);
        add(jcbRancho);
        
        Procedencia = new JLabel("Procedencia:");
        Procedencia.setFont(FDatos);
        Procedencia.setBounds(20,610, 130, 20);
        add(Procedencia);
        
        txtProcedencia = new JTextArea();
        txtProcedencia.setFont(txt);
        Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK, 1);
        txtProcedencia.setBorder(bordeNegro);
        txtProcedencia.setBounds(20, 640,450,100);
        add(txtProcedencia);
        
        btnAceptar = new JButton("Guardar");
        btnAceptar.setFont(new Font("Arial",Font.BOLD,20));
        btnAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int PesoN = Integer.valueOf(txtPeso.getText());

                    if (txtFolio.getText().matches("SEIP-[0-9]{4}")){
                        if(txtNumeroArete.getText().matches("[0-9]{5}")){
                            if(PesoN > 0){
                                if(txtRaza.getText().matches("[A-Za-z]+")){
                                    if(txtProcedencia.getText().matches("[A-Za-z]+")){
                                        JOptionPane.showMessageDialog(null,"Datos Guardados correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                    }else{
                                        JOptionPane.showMessageDialog(null,"ERROR: LA PROCEDENCIA", "Informacion", JOptionPane.ERROR_MESSAGE);
                                    } 
                                }else{
                                    JOptionPane.showMessageDialog(null,"ERROR: LA RAZA", "Informacion", JOptionPane.ERROR_MESSAGE);
                                }                        
                            }else{
                                JOptionPane.showMessageDialog(null,"ERROR: EN EL PESO", "Informacion", JOptionPane.ERROR_MESSAGE);
                            }

                        }else {
                            JOptionPane.showMessageDialog(null,"ERROR: EN EL NUMERO DEL ARETE", "Informacion", JOptionPane.ERROR_MESSAGE);
                        }
                    
                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR: EN EL FOLIO", "Informacion", JOptionPane.ERROR_MESSAGE);
                    }

            }
        
        });
        btnAceptar.setBounds(600, 550, 150, 25);
        add(btnAceptar);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Arial",Font.BOLD,20));
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFolio.setText("");
                txtNumeroArete.setText("");
                txtFoto.setText("");
                txtRaza.setText("");
                txtPeso.setText("");
                txtColor.setText("");
                txtProcedencia.setText("");
                JOptionPane.showMessageDialog(null,"Datos limpiados", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
        btnLimpiar.setBounds(500, 500, 150, 25);
        add(btnLimpiar);
        
        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial",Font.BOLD,20));
        btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Salir de programa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            
        });
        btnSalir.setBounds(700, 500, 150, 25);
        add(btnSalir);

        
        setVisible(true);
    }
    
    public static void main (String [] Mex){
        Vista_Animal VA = new Vista_Animal();
    }
    
}