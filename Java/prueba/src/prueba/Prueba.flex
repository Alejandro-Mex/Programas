package prueba;
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

%{

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%%
"INICIOCODIGO"      { return symbol(sym.INICIOCODIGO); }
"FINCODIGO"	    { return symbol(sym.FINCODIGO); }



[\n\r\t ]+	    { /* IGNORAR */ }

// Caracteres desconocidos
.		{ return symbol(sym.ERROR, yytext());}