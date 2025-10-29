import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 
// Clase principal que contiene toda la interfaz 
public class MainGUI extends JFrame { 
    //  Componentes principales 
    private JTextArea inputArea, outputArea; 
    private JButton analyzeButton, clearButton;
    public MainGUI() { 
        setTitle("SmartHomeLang - Analizador Léxico"); 
        setSize(700, 500); setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLayout(new BorderLayout(10, 10)); 
        // Título de la ventana 
        JLabel title = new JLabel("Analizador Léxico - SmartHomeLang", SwingConstants.CENTER); 
        title.setFont(new Font("Segoe UI", Font.BOLD, 18)); 
        add(title, BorderLayout.NORTH); 
        // 🔹 Área de texto donde se escribirá el código y donde se verá la salida 
        inputArea = new JTextArea(); 
        outputArea = new JTextArea(); 
        outputArea.setEditable(false); // Solo lectura
        // División de la pantalla: izquierda = código, derecha = resultado 
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(inputArea), new JScrollPane(outputArea)); 
        splitPane.setDividerLocation(320); 
        add(splitPane, BorderLayout.CENTER); 
        // Botones inferiores
        JPanel buttonPanel = new JPanel();
        analyzeButton = new JButton("Analizar"); 
        clearButton = new JButton("Limpiar"); 
        buttonPanel.add(analyzeButton); 
        buttonPanel.add(clearButton); 
        add(buttonPanel, BorderLayout.SOUTH); 
        //Eventos de los botones 
        analyzeButton.addActionListener(e -> analyzeText()); 
        clearButton.addActionListener(e -> { 
            inputArea.setText(""); 
            outputArea.setText(""); 
        }); 
    } 
    // Método que realiza el análisis cuando se presiona el botón “Analizar” 
    private void analyzeText() { 
        try { 
            String inputText = inputArea.getText().trim(); 
            if (inputText.isEmpty()) { 
                JOptionPane.showMessageDialog(this, "Por favor, escribe código para analizar."); 
                return; 
            }
            // 🔹 Crear archivo temporal con el contenido del área de texto 
            
            File tempFile = new File("input.txt"); 
            try (PrintWriter pw = new PrintWriter(tempFile)) {
                pw.print(inputText); 
            }
            // 🔹 Ejecutar el analizador léxico 
            Reader reader = new BufferedReader(new FileReader(tempFile)); 
            SmartHomeLexer lexer = new SmartHomeLexer(reader); 
            // 🔹 Leer los tokens generados 
            while (!lexer.yyatEOF()) {
                lexer.yylex(); // Analiza línea por línea 
            } 
            outputArea.setText("Análisis completado.\nRevisa la consola para ver los tokens."); 
        } catch (Exception ex) { 
            outputArea.setText("Error durante el análisis: " + ex.getMessage()); 

        } 
    } 
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true)); 
    } 
}