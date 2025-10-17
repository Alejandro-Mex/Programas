package ejerciciojflex;
import static ejerciciojflex.Token.*;
%%
%class Lexer
%type Token
L = [a-zA-Z_]
D = [0-9]
WHITE = [ \t\r\n]
%{
    public String lexeme;
%}
%%
(WHITE) {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return ASSIGN;}
"==" {return EQUALS;}
"+" {return PLUS;}
"*" {return TIMES;}
"-" {return MINUS;}
"/" {return DIV;}
{L} ({L}|{D})* {lexeme=yytext(); return ID;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return INT;}
. {return ERROR;}
