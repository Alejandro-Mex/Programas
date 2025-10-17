
package finanmex.Licenciado.view;
import finanmex.Licenciado.model.RenovacionDAO;
import finanmex.Licenciado.model.renovacion;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistroRenovacion extends JFrame{
    SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-dd");
    Date fechaActual = new Date();
    String fecha;
    int id;
    renovacion R = new renovacion();
    RenovacionDAO RD = new RenovacionDAO();
    private JLabel labelTitulo, labelSubTitulo,labelNombre,labelSaldo_restante,labelMonto,labelInteres,labelDocumentos,labelSemanas,labelStatus;
    private JButton botonGuardar, botonCancelar;
    private JComboBox comboAcreedor;
    private JCheckBox CheckBoxIne, CheckBoxComprobante;
    private JTextField campoSemanas,campoStatus,campoSaldo_restante,campoMonto,campoInteres;
    
    public RegistroRenovacion(){
        setTitle("Registro de Renovaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        
        labelTitulo = new JLabel("Renovacion", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24)); // Aumentar el tamaño de la letra
        labelTitulo.setBounds(100, 10, 250, 30);
        add(labelTitulo);
        
        labelSubTitulo = new JLabel("FINANMEX", SwingConstants.CENTER);
        labelSubTitulo.setFont(new Font("Arial", Font.BOLD, 18)); // Aumentar el tamaño de la letra
        labelSubTitulo.setBounds(100, 50, 250, 30);
        add(labelSubTitulo);
        
        labelNombre = new JLabel("ID Acreedor: ");
        labelNombre.setBounds(40, 80, 220, 30);
        add(labelNombre);
        
        JPanel fechaPanel = new JPanel();
        fechaPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        fechaPanel.add(new JLabel("Nombre completo del acreedor: "));
        
        comboAcreedor = new JComboBox();
        RD.MostrarACreedor(comboAcreedor);
        comboAcreedor.setBounds(40, 120, 220, 22);
        add(comboAcreedor);
        
        labelStatus = new JLabel("Status: ");
        labelStatus.setBounds(40, 165, 160, 30);
        add(labelStatus);
        
        campoStatus = new JTextField();
        campoStatus.setBounds(40, 190, 150, 22);
        add(campoStatus);
        
        labelSaldo_restante = new JLabel("Saldo restante: ");
        labelSaldo_restante.setBounds(220, 165, 160, 30);
        add(labelSaldo_restante);
        
        campoSaldo_restante = new JTextField();
        
        campoSaldo_restante.setBounds(220, 190, 170, 22);
        add(campoSaldo_restante);
        
        labelMonto = new JLabel(" Monto solicitado: ");
        labelMonto.setBounds(40, 220, 200, 30);
        add(labelMonto);
        
        campoMonto = new JTextField();
        campoMonto.setBounds(40, 250, 150, 22);
        add(campoMonto);
        
        labelInteres = new JLabel("Semanas a pagar: ");
        labelInteres.setBounds(220, 220, 200, 30);
        add(labelInteres);
        
        campoInteres = new JTextField();
        campoInteres.setBounds(220, 250, 170, 22);
        add(campoInteres);
        
        labelDocumentos = new JLabel("Documentos presentados: ");
        labelDocumentos.setBounds(40, 290, 200, 22);
        add(labelDocumentos);
        
        CheckBoxIne = new JCheckBox("INE", false);
        CheckBoxIne.setBounds(40, 320,70,30);
        add(CheckBoxIne);
        
        CheckBoxComprobante = new JCheckBox("Comprobante de domicilio", false);
        CheckBoxComprobante.setBounds(150, 320, 250, 30);
        add(CheckBoxComprobante);

        botonGuardar = new JButton("Registro Renovacion");
        botonGuardar.setBounds(40, 420, 120, 30);
        add(botonGuardar);
        
        botonCancelar = new JButton(" Cancelar ");
        botonCancelar.setBounds(200, 420, 120, 30);
        add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuLicenciado MP = new MenuLicenciado();
               setVisible(false);
            }
        });
        
        setVisible(true);
    }
    
    public int getAcreedor(){
        return Integer.parseInt(comboAcreedor.getSelectedItem().toString());
    }
    
    public boolean getEstatus(){
        return Boolean.parseBoolean(campoStatus.getText());
    }
    
    public double getSaldoRestante(){
        return Double.parseDouble(campoSaldo_restante.getText());
    }
    
    public double getMontoSolicitado(){
        return Double.parseDouble(campoMonto.getText());
    }
    
    public int getSemanasApagar(){
        return Integer.parseInt(campoInteres.getText());
    }
    
    public String getFecha(){
        fecha = form.format(fechaActual);
        return fecha;
    }
    
    public void addAgregarRenovacion(ActionListener listender){
        botonGuardar.addActionListener(listender);
    }
    
      public static void main(String [] M){
        RegistroRenovacion RD = new RegistroRenovacion();
    }
}
