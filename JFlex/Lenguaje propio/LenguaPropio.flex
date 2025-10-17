%%

%class LENMEX
%unicode
%public
%standalone
%line
%column

ENTERO		=	[0-9]
PALABRA		=	[a-zA-Z_]
DECIMAL		=	[0-9]+ "." [0-9]+
VARIABLE	=	{PALABRA}({PALABRA}|{ENTERO})*
NUMERO		=	{ENTERO}+|{DECIMAL}

%%

// Palabras reservadas
"INICIOCODIGO"		{ System.out.println("PALABRA_RESERVADA(INCIOCODIGO)"); }
"FINCODIGO"		{ System.out.println("PALABRA_RESERVADA(FINCODIGO)"); }
"MAYORQUE"		{ System.out.println("PALABRA_RESERVADA(MAYORQUE)"); }
"MENORQUE"		{ System.out.println("PALABRA_RESERVADA(MENORQUE)"); }
"MIENTRAS"		{ System.out.println("PALABRA_RESERVADA(MIENTRAS)"); }
"CUANDO"		{ System.out.println("PALABRA_RESERVADA(CUANDO)"); }
"IMPRIMIR"		{ System.out.println("PALABRA_RESERVADA(IMPRIMIR)"); }
"GUARDAR"		{ System.out.println("PALABRA_RESERVADA(GUARDAR)"); }
"VAR"			{ System.out.println("PALABRA_RESERVADA(VAR)"); }
"UNIR"			{ System.out.println("PALABRA_RESERVADA(UNIR)"); }

//Tipos de datos
"ENTEROS"		{ System.out.println("TIPO_DATO(ENTERO)"); }
"DECIMALES"		{ System.out.println("TIPO_DATO(DECIMAL)"); }
"PALABRAS"		{ System.out.println("TIPO_DATO(PALABRA)"); }

//Operadores aritmeticos
"+"			{ System.out.println("OPERADOR_ARITMETICO(+)"); }
"-"			{ System.out.println("OPERADOR_ARITMETICO(-)"); }
"*"			{ System.out.println("OPERADOR_ARITMETICO(*)"); }
"/"			{ System.out.println("OPERADOR_ARITMETICO(/)"); }

//Asignacion
":"			{ System.out.println("OPERADOR_ASIGNACION(:)"); }

//Operador de escritura
"["			{ System.out.println("OPERADOR_ESCRITURA([)"); }
"]"			{ System.out.println("OPERADOR_ARITMETICO(])"); }

//Seccionador de codigo
"("			{ System.out.println("SECCIONADOR_CODIGO(()"); }
")"			{ System.out.println("SECCIONADOR_CODIGO())"); }

"\\"			{ System.out.println("FINALIZADOR_LINEA(\\)"); }

//VARIABLE
{VARIABLE}		{ System.out.println("VARIABLE(" + yytext() + ")"); }


//Números
{NUMERO}	{ System.out.println("NUMERO (" + yytext() + ")"); }


//Ignorar espacios y saltos
[\n\r\t ]+	{ /* IGNORAR */ }

//Caracteres desconocidos
.		{ System.out.println("DESCONOCIDO(" + yytext() + ")"); }
