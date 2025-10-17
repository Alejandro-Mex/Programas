class ValidarNumeros{
    public static void main(String [] Mex){
        int enteros = Integer.parseInt("10");

        if(enteros >= 1){
            System.out.println("Nuemro entero");
        } else {
            System.out.println("Error en el numero");
        }

        double decimal = Double.parseDouble("1.2");
        if (decimal >= 1){
            System.out.println("Decimal correcto");
        } else {
            System.out.println("Decimal incorrecto");
        }
    }
}