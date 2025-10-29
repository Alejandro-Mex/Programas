%% 
%class SmartHomeLexer // Nombre de la clase que se generará 
%unicode // Soporte para caracteres Unicode 
%public // Clase accesible desde otros archivos Java 
%standalone // Permite ejecución independiente
%line // Guarda el número de línea 
%column // Guarda el número de columna 
// Definición de patrones básicos 
LETRA = [a-zA-Z_] // Cualquier letra o guion bajo 
DIGITO = [0-9] // Cualquier número del 0 al 9 
ID = {LETRA}({LETRA}|{DIGITO})* // Identificador (letras y números) 
NUMERO = {DIGITO}+("."{DIGITO}+)? 
ESPACIO = [ \t\r\n]+ // Espacios, tabulaciones y saltos de línea 
// Inicio de las reglas del analizador 
%% 
"DEVICE" { System.out.println("PALABRA_CLAVE(DEVICE)"); } 
"ACTION" { System.out.println("PALABRA_CLAVE(ACTION)"); } 
"ON" { System.out.println("VALOR(ON)"); } 
"OFF" { System.out.println("VALOR(OFF)"); } 
"IF" { System.out.println("PALABRA_CLAVE(IF)"); } 
"THEN" { System.out.println("PALABRA_CLAVE(THEN)"); } 
"ALARM" { System.out.println("PALABRA_CLAVE(ALARM)"); } 
"==" { System.out.println("COMPARADOR(==)"); } 
";" { System.out.println("PUNTOYCOMA"); } 

{ID} { System.out.println("IDENTIFICADOR(" + yytext() + ")"); } 
{NUMERO} { System.out.println("NUMERO(" + yytext() + ")"); } 
{ESPACIO} { /* Ignorar espacios y saltos */ } 
. { System.out.println("DESCONOCIDO(" + yytext() + ")"); }