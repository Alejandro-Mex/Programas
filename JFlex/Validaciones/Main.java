import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            // Abrir el archivo de entrada (cada estudiante define el suyo, ej. programa.txt)
            FileReader fr = new FileReader("PruebaCorrecta.txt");
            // Crear el analizador léxico (nombre depende de su .flex)
            ValidacionUsuarios lexer = new ValidacionUsuarios(fr);
            // Mientras no se alcance el final del archivo
            while (!lexer.yyatEOF()) {
                lexer.yylex(); // ejecuta la acción definida en el .flex
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }
}
