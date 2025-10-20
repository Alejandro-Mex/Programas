package pruebacup;
import java_cup.runtime.Symbol;
%%

// Opciones y declaraciones
%class Lexer
%type java_cup.runtime.Symbol
%cup // Habilita la compatibilidad con CUP
%full
%line
%column
%char
ENTERO		=	[0-9]
PALABRA		=	[a-zA-Z_]
DECIMAL		=	{ENTERO}+ "." {ENTERO}+
VARIABLE	=	{PALABRA}({PALABRA}|{ENTERO})*
NUMERO		=	{ENTERO}+|{DECIMAL}

%{

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%%

// --------------------------- Reglas Léxicas ---------------------------

// Palabras reservadas (devuelven un Symbol con el tipo del token)
"INICIOCODIGO"      { return symbol(sym.INICIOCODIGO); }
"FINCODIGO"	    { return symbol(sym.FINCODIGO); }
"MAYORQUE"	    { return symbol(sym.MAYORQUE); }
"MENORQUE"	    { return symbol(sym.MENORQUE); }
"MIENTRAS"	    { return symbol(sym.MIENTRAS); }
"CUANDO"	    { return symbol(sym.CUANDO); }
"IMPRIMIR"	    { return symbol(sym.IMPRIMIR); }
"GUARDAR"	    { return symbol(sym.GUARDAR); }
"VAR"		    { return symbol(sym.VAR); }
"UNIR"		    { return symbol(sym.UNIR); }

// Tipos de datos
"ENTEROS"	    { return symbol(sym.TIPO_ENTERO); }
"DECIMALES"	    { return symbol(sym.TIPO_DECIMAL); }
"PALABRAS"	    { return symbol(sym.TIPO_PALABRA); }

// Operadores aritmeticos
"+"			    { return symbol(sym.MAS); }
"-"			    { return symbol(sym.MENOS); }
"*"			    { return symbol(sym.POR); }
"/"			    { return symbol(sym.DIVIDIDO); }
"="			    { return symbol(sym.IGUAL); }

// Asignacion
":"			    { return symbol(sym.ASIGNACION); }

// Operador de escritura
"["			    { return symbol(sym.CORCHETE_AP); }
"]"			    { return symbol(sym.CORCHETE_CI); }

// Seccionador de codigo
"("			    { return symbol(sym.PARENTESIS_AP); }
")"			    { return symbol(sym.PARENTESIS_CI); }

"\\"			{ return symbol(sym.FINALIZADOR_LINEA); }


// VARIABLE (devuelve un Symbol con el lexema como valor)
{VARIABLE}	    { return symbol(sym.VARIABLE, yytext()); }


// Números (devuelve un Symbol con el lexema como valor)
{NUMERO}	    { return symbol(sym.NUMERO, yytext()); }


// Ignorar espacios y saltos
[\n\r\t ]+	    { /* IGNORAR */ }

// Caracteres desconocidos
.		{ return symbol(sym.ERROR, yytext());}