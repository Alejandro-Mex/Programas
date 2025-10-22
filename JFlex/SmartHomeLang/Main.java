import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("prueba.txt");
            SmartHomeLang lexer = new SmartHomeLang(fr);
            while (!lexer.yyatEOF()) {
                lexer.yylex();
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }
}