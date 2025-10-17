%%

%class ValidacionUsuarios
%unicode
%public
%standalone
%line
%column

EDAD		=	[0-9]+
ID		=	ID[0-9]{3}
NOMBRE		=	[A-Z][a-z]+" "[A-Z][a-z]+
CORREO		=	[a-zA-Z_]+[0-9]*"@"(gmail|yahoo|outlook)".com"
PALABRA		=	[a-zA-Z_]+ 


%%

{ID}	 	{System.out.println("Id validado(" + yytext() + ")");}
{NOMBRE}	{System.out.println("Nombre validado(" + yytext() + ")");}
{EDAD}		{int Edad = Integer.parseInt(yytext()); if(Edad <= 120 && Edad >= 18) {System.out.println("Edad Validado(" + yytext() + ")");}else{System.out.println("Edad no Valida(" + yytext() + ")");}}
{CORREO}	{System.out.println("Correo validado(" + yytext() + ")");}


//Ignorar espacios y saltos
[\n\r\t ]+	{ /* IGNORAR */ }

//VARIABLE
{PALABRA}	{ System.out.println("Palabra no valida(" + yytext() + ")"); }

//Caracteres desconocidos
.		{ System.out.println("DESCONOCIDO(" + yytext() + ")"); }