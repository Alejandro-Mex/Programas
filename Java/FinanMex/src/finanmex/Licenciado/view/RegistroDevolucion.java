package finanmex.Licenciado.view;


import finanmex.Licenciado.model.DevolucionDAO;
import finanmex.Licenciado.model.devolucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class RegistroDevolucion extends JFrame {
    SimpleDateFormat form = new SimpleDateFormat("YYY-MM-dd");
    Date fechaActual = new Date();
    String fecha;
    devolucion d = new devolucion();
    DevolucionDAO DD = new DevolucionDAO();
    private JLabel labelAcreedor,labelMonto,labelMora,labelSemana,labelSaldoRes,labelSemanaRes, labelPrestamos;
    private JTextField campoAcreedor,campoMonto,campoMora,campoSemana,campoSaldoRes,campoSemanaRes;
    private JButton botonPagar,botonCancelar,botonEnviar;
    private JComboBox comboPrestamo, comboAcreedor;

    public RegistroDevolucion() {
        setTitle("Registro de Pago");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        labelAcreedor = new JLabel("Acreedor:");
        labelAcreedor.setBounds(30, 20, 200, 22);
        add(labelAcreedor);
        
        comboAcreedor = new JComboBox();
        DD.MostrarAcreedor(comboAcreedor);
        comboAcreedor.setBounds(30, 50, 200, 22);
        add(comboAcreedor);
        
        labelMonto = new JLabel("Monto Abonar:");
        labelMonto.setBounds(30, 70, 160, 22);
        add(labelMonto);
        
        campoMonto = new JTextField();
        campoMonto.setBounds(30, 100, 100, 22);
        add(campoMonto);
        
        labelMora = new JLabel("Mora:");
        labelMora.setBounds(140, 70, 160, 22);
        add(labelMora);
        
        campoMora = new JTextField();
        campoMora.setBounds(140, 100, 100, 22);
        add(campoMora);
        
        labelSemanaRes = new JLabel("Semana Restante:");
        labelSemanaRes.setBounds(270, 20, 160, 22);
        add(labelSemanaRes);
        
        campoSemanaRes = new JTextField();
        campoSemanaRes.setBounds(270, 50, 160, 22);
        add(campoSemanaRes);
        
        labelSaldoRes = new JLabel("Saldo Restante:");
        labelSaldoRes.setBounds(270, 70, 160, 22);
        add(labelSaldoRes);
        
        campoSaldoRes = new JTextField();
        campoSaldoRes.setBounds(270, 100, 160, 22);
        add(campoSaldoRes);
        
        labelSemana = new JLabel("Semana Pagada");
        labelSemana.setBounds(30, 120, 100, 22);
        add(labelSemana);
        
        campoSemana = new JTextField();
        campoSemana.setBounds(30, 150, 100, 22);
        add(campoSemana);
        
        
        
        botonPagar = new JButton("Pagar");
        botonPagar.setBounds(30, 400, 120, 30);
        add(botonPagar);
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(200, 400, 120, 30);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuLicenciado MP = new MenuLicenciado();
               setVisible(false);
            }
        });
        add(botonCancelar);
        
      

        setVisible(true);
        
    }
    
    public double getCampoAbono(){
        return Double.parseDouble(campoMonto.getText());
    }
    
    public double getCampoMora(){
        return Double.parseDouble(campoMora.getText());
    }
    
    
    public double getCampoSaldoRes(){
        return Double.parseDouble(campoSaldoRes.getText());
    }
    
    public int getCampoSemana(){
        return Integer.parseInt(campoSemana.getText());
    }
    
    public String getCampoFecha(){
        fecha = form.format(fechaActual);
        return fecha;
    }
    
    public int getCampoSemanaRes(){
        return Integer.parseInt(campoSemanaRes.getText());
    }
    
    
    public int getIdAcreedor(){
        return Integer.parseInt(comboAcreedor.getSelectedItem().toString());
    }
    
    public void addAgregarDevolucion(ActionListener listender){
        botonPagar.addActionListener(listender);
    }
    
    public static void main(String [] Mex){
        RegistroDevolucion RD = new RegistroDevolucion();
    }
        
        
        
}