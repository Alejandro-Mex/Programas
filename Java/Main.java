package ejerciciojflex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author Alejandro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
           String archivo = "C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\ejerciciojflex\\src\\ejerciciojflex\\entrada.txt";
           
           Reader reader = new BufferedReader (new FileReader(archivo));
           Lexer lexer = new Lexer (reader);
           String resultado="";
           
           while (true){
               Token token = lexer.yylex();
               if(token == null){
                   resultado=resultado+"EOF";
                   System.out.println(resultado);
                   return;
               }
               switch(token){
                   case ERROR:
                       resultado=resultado + "Error, simbolo no reconocido \n";
                       break;
                   case ID: case INT:
                       resultado= resultado+"Token: " + token + " " + lexer.lexeme + "\n";
                       break;
                   default:
                       resultado = resultado + "Token: " + token + "\n";
               }
           }
       }catch (Exception e){
           System.out.println(e.toString());
       }
    }
    
}
