class ValidarFecha{
    public static void main(String[] args) {
        String fecha = yytext(); // Ejemplo de fecha a validar
        int Año = Integer.parseInt(fecha.substring(0, 4));
        int Mes = Integer.parseInt(fecha.substring(5, 7));
        int Dia = Integer.parseInt(fecha.substring(8, 10));
        if (Año == 2025 | Año == 2026){
            if (Mes >= 1 && Mes <= 12) {
                if (Dia >= 1 && Dia <= 31){
                    System.out.println("FECHA()");
                }else{
                    System.out.println("ERROR: EN EL DIA (" + Dia + ")");
                }
            }else{
                System.out.println("ERROR: EN EL MES (" + Mes + ")");
            }
        }else{
            System.out.println("ERROR: EN EL AÑO (" + Año + ")");
        }
        
    }
}

/* 
        if (fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("La fecha es válida.");
        } else {
            System.out.println("La fecha no es válida.");
        }
        

        if (Año >= 1900 && Año <= 2100) {
            System.out.println("Año Validado(" + Año + ")");
            if (Mes >= 1 && Mes <= 12) {
                System.out.println("Mes Validado(" + Mes + ")");
                if (Dia >= 1 && Dia <= 31) { // Validación básica del día
                    System.out.println("Día Validado(" + Dia + ")");
                } else {
                    System.out.println("Día no válido");
                    if (Mes == 2 && Dia > 29) {
                        System.out.println("Febrero no puede tener más de 29 días");
                    } else if ((Mes == 4 || Mes == 6 || Mes == 9 || Mes == 11) && Dia > 30) {
                        System.out.println("Este mes no puede tener más de 30 días");
                    }
                }
            } else {
                System.out.println("Mes no válido");
            }
        } else {
            System.out.println("Año no válido");
        }
*/