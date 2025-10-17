package finanmex.Licenciado.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuRegistros extends JFrame{
    public JLabel titulo;
    public JButton btnPrestamo, btnDevolucion, btnRenovacion,btnSalir;
    
    public MenuRegistros(){
        setTitle("Menu de registros");
        setLayout(new BorderLayout());
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        titulo = new JLabel("Selecciona el registro");
        titulo.setFont(new Font("Arial", Font.BOLD,20) );
        add(titulo, BorderLayout.NORTH);
        
        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.setVisible(true);
        
        JPanel fechaPanel = new JPanel();
        fechaPanel.setVisible(true);
        fechaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        fechaPanel.add(new JLabel("Fecha de inicio de los registros: "));

       JComboBox<Integer> comboDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            comboDia.addItem(i);
        }
        
        fechaPanel.add(comboDia);
        
        JComboBox<String> comboMes = new JComboBox<>(new String[]{
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        comboMes.setBounds(120, 280, 100, 22);
        fechaPanel.add(comboMes);
        
        JComboBox<Integer> comboAnio = new JComboBox<>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = year - 10; i <= year; i++) {
            comboAnio.addItem(i);
        }
        comboAnio.setBounds(230, 280, 80, 22);
        fechaPanel.add(comboAnio);
        panel.add(fechaPanel);
        //---------------------------------------------------------------
        add(panel,BorderLayout.CENTER);
        
        JPanel Botones = new JPanel(new GridLayout(2,3));
        btnPrestamo = new JButton("Registros de prestamos");
        Botones.add(btnPrestamo);
        btnDevolucion = new JButton("Registros de devoluciones");
        Botones.add(btnDevolucion);
        btnRenovacion = new JButton("Registro de renovaciones");
        Botones.add(btnRenovacion);
        JLabel esp = new JLabel(" ");
        Botones.add(esp);
        btnSalir = new JButton("Salir");
        Botones.add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuLicenciado MP = new MenuLicenciado();
               setVisible(false);
            }
        });
        JLabel esp2 = new JLabel(" ");
        Botones.add(esp2);
        Botones.setVisible(true);
        add(Botones, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    
}
