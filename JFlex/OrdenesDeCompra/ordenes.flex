%%

%class ValidacionOrdenes
%unicode
%public
%standalone
%line
%column

ID			=	"ID"[0-9]{3}
NOID                    =       "ID"[0-9]*
PALABRASCLAVES		=	"ORDER"|"DATE"|"PRODUCT"|"QTY"|"PRICE"
CIERRE			=	"ENDORDER"
FECHA			=	[0-9]{4}"-"[0-9]{2}"-"[0-9]{2}
NOFECHA                 =       [0-9]*"-"[0-9]*"-"[0-9]*
DECIMAL			=	[0-9]+ "." [0-9]+
NODECIMAL		=	"-"[0-9]+ "." [0-9]+
ENTERO			=	[0-9]+
NOENTERO		=	"-"[0-9]+
IDPRODUCTO		=	"P"[0-9]{3}
NOIDPRODUCTO		=	"P"[0-9]*

%%

{FECHA}			{ String fecha = yytext(); int Año = Integer.parseInt(fecha.substring(0, 4));int Mes = Integer.parseInt(fecha.substring(5, 7));int Dia = Integer.parseInt(fecha.substring(8, 10));if (Año == 2025 | Año == 2026){
        if (Mes >= 1 && Mes <= 12) {if (Dia >= 1 && Dia <= 31){System.out.println("FECHA(" + yytext() + ")"); }else{System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " DIA("+  Dia +")");}}else{System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " MES("+  Mes +")");
        }}else{System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " AÑO(" + Año + ")");}}
{NOFECHA}               {System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " FECHA("+  yytext() +")");}

{ID}			{ System.out.println("IDENTIFICADOR("+  yytext() +")"); }
{NOID}                  {System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " IDENTIFICADOR("+  yytext() +")");}

{PALABRASCLAVES}	{ System.out.println("PALABRAS_CLAVES(" + yytext() + ")"); }
{CIERRE}		{ System.out.println("CIERRE(" + yytext() + ")"); }

{IDPRODUCTO}		{System.out.println("IDPRODUCTO("+  yytext() +")");}
{NOIDPRODUCTO}          {System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " IDPRODUCTO("+  yytext() +")");}

//Tipos de datos
{ENTERO}		{ System.out.println("ENTERO("+  yytext() +")"); }
{NOENTERO}              {System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " ENTERO("+  yytext() +")");}

{DECIMAL}		{ System.out.println("DECIMAL("+  yytext() +")"); }
{NODECIMAL}             {System.out.println("ERROR EN LA LINEA: " + (yyline + 1) + " DECIMAL("+  yytext() +")");}

//Ignorar espacios y saltos
[ \n\t]+	{ /* IGNORAR */ }

//Caracteres desconocidos
.		{ System.out.println("TOKENS DESCONOCIDO(" + yytext() + ")"); }