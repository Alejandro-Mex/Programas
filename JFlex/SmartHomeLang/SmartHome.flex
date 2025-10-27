%%
%class SmartHomeLang
%public
%unicode
%standalone
%line
%column

PALABRAS_CLAVES         =           "DISPOSITIVO"|"ACCION"|"COLOCAREN"|"FIN"|"TIEMPO"|"ACTIVAR"|"GRADOS"|"INTENCIDAD"|"INICIO"|"VOLUMEN"
IDENTIFICADOR           =           [A-Za-z_]+[0-9]*
ACCIONES                =           "ENCENDER"|"APAGAR"|"ABRIR"|"CERRAR"|"GIRAR"
NUMERO                 =            [0-9]+

%%
";"                     {System.out.println("FINALIZADOR_ORDEN(;)");}
{PALABRAS_CLAVES}       {System.out.println("PALABRAS_CLAVES(" + yytext() + ")");}
{ACCIONES}              {System.out.println("ACCION(" + yytext() + ")");}
{IDENTIFICADOR}         {System.out.println("IDENTIFICADOR(" + yytext() + ")");}
{NUMERO}                {System.out.println("NUMERO(" + yytext() + ")");}


[ \n\t]+	{ /* IGNORAR */ }

.		{ System.out.println("ERROR: TOKEN DESCONOCIDO(" + yytext() + "), REVISA LA LINEA(" + (yyline + 1)+ ")"); }