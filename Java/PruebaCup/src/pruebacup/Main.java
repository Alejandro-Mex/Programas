package pruebacup;
import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;

public class Main {
    public static void main(String[] args) {
        try {
            // Abrir el archivo de entrada (cada estudiante define el suyo, ej. programa.txt)
            FileReader fr = new FileReader("C:/Users/Alejandro/Documents/Programas/Java/PruebaCup/src/pruebacup/Prueba.txt");
            // Crear el analizador léxico (nombre depende de su .flex)
            Lexer lexer = new Lexer(fr);
            // Mientras no se alcance el final del archivo
            parser s = new parser(lexer);

            System.out.println("Iniciando análisis sintáctico...");
            Symbol resultado = s.parse();
            if (resultado != null) {
                System.out.println("\n--- Análisis Completado ---");
                // Si la gramática de CUP tiene acciones, 'resultado' podría contener el AST o un valor.
                // System.out.println("Resultado: " + resultado.value); 
                System.out.println("El código fuente es sintácticamente correcto.");
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }
}