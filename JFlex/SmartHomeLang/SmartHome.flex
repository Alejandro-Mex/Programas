%%
%class SmartHomeLang
%public
%unicode
%standalone
%line
%column

PALABRAS_CLAVES         =           "DISPOSITIVO"|"ACCION"|"COLOCAREN"|"FIN"|"TIEMPO"
IDENTIFICADOR           =           [A-Za-z_]+[0-9]*
ACCIONES                =           "ENCENDER"|"APAGAR"|"ABRIR"|"CERRAR"
NIVEL                   =           [1-5]{1}
NONIVEL                 =           [0]|[6-9]+

%%
";"                     {System.out.println("FINALIZADOR_ORDEN(;)");}
{PALABRAS_CLAVES}       {System.out.println("PALABRAS_CLAVES(" + yytext() + ")");}
{ACCIONES}              {System.out.println("ACCION(" + yytext() + ")");}
{IDENTIFICADOR}         {System.out.println("IDENTIFICADOR(" + yytext() + ")");}
{NIVEL}                 {System.out.println("NIVEL(" + yytext() + ")");}
{NONIVEL}               {System.out.println("ERROR: NIVEL(" + yytext() + "), FUERA DE RANGO , REVISA LA LINEA(" + (yyline + 1)+ ")");}

[ \n\t]+	{ /* IGNORAR */ }

.		{ System.out.println("ERROR: TOKEN DESCONOCIDO(" + yytext() + "), REVISA LA LINEA(" + (yyline + 1)+ ")"); }