public class ValidarId {
    public static void main(String[] args) {
        String ID = "ID0";
        if(ID.matches("ID\\d{3}")){
            System.out.println("ID Correcto");
        }else{
            System.out.println("ID incorrecto");
        }

        String IDProducto = "P1";
        if(IDProducto.matches("P[0-9]{3}")){
            System.out.println("IDProducto Correcto");
        } else {
            System.out.println("IDProducto incorrecto");
        }
    }
}
