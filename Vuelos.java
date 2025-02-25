import java.util.ArrayList;
import java.util.Scanner;

public class Vuelos {
    String numero;
    String origen;
    String destino;
    String dia;
    String clase;

    ArrayList<Vuelos> vuelos=new ArrayList<>();

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getDia() {
        return dia;
    }

    public String getClase() {
        return clase;
    }

    public Vuelos(String numero, String origen, String destino, String dia, String clase) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.clase = clase;
    }

    public Vuelos() {
    }

    @Override
    public String toString() {
        return "Vuelos-> " +
                "Numero='" + numero + '\'' +
                ",0rigen='" + origen + '\'' +
                ", Destino='" + destino + '\'' +
                ", Dia='" + dia + '\'' +
                ", Clase='" + clase + '\'' ;
    }

    public void gestionVuelos(){
        if (vuelos.isEmpty()){
            vuelos.add(new Vuelos("2023-01","Valencia","Menorca","15-08","Turista"));
            vuelos.add(new Vuelos("2023-02","Valencia","Tenerife","20-08","Turista"));
            vuelos.add(new Vuelos("2023-03","París","Valencia","15-08","Primera"));
            vuelos.add(new Vuelos("2023-04","Atenas","Valencia","20-08","Primera"));
        }
    }

    public void nuevoVuelo(){
        Scanner sc = new Scanner(System.in);
        gestionVuelos();

        String numero = validarnumero();
        System.out.println("¿Cuál es el origen del vuelo?");
        String origen = sc.nextLine();
        System.out.println("¿Cuál es el destino del vuelo?");
        String destino = sc.nextLine();
        String dia = validDia();
        System.out.println("¿Qué clase es el vuelo?");
        String clase = sc.nextLine();

        vuelos.add(new Vuelos(numero, origen, destino, dia, clase));
        System.out.println("El vuelo fue añadido con éxito");
    }

        public static String validarnumero() {
            Scanner scanner = new Scanner(System.in);
            String num;

            do {
                System.out.print("Introduce una fecha en formato YYYY-MM: ");
                num = scanner.nextLine();
            } while (!validarFormatoFecha(num));

            System.out.println("Fecha válida.");
            return num;
        }


        public static boolean validarFormatoFecha(String num) {

            if (num.length() != 7) {
                return false;
            }

            if (num.charAt(4) != '-') {
                return false;
            }


            int mes = Integer.parseInt(num.substring(5, 7));


            if (mes < 1 || mes > 12) {
                return false;
            }

            return true;
        }

    public static String validDia() {
        Scanner scanner = new Scanner(System.in);
        String dia;

        do {
            System.out.print("Introduce un día en formato DD-MM: ");
            dia = scanner.nextLine();
        } while (!validarDia(dia));
        System.out.println("Fecha válida.");
        
        return dia;
    }

    public static boolean validarDia(String dia) {

        if (dia.length() != 5 || dia.charAt(2) != '-') {
            return false;
        }

        try {

            int dias = Integer.parseInt(dia.substring(0, 2));
            int mes = Integer.parseInt(dia.substring(3, 5));

            if (mes < 1 || mes > 12) {
                return false;
            }

            if (dias < 1 || dias > 31) {
                return false;
            }

            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void printVuelos(){
        int cont =1;
        gestionVuelos();
        System.out.println("Lista de Vuelos :");
        if (vuelos.isEmpty()){
            System.out.println("No hay armas registradas");
        }
        for (Vuelos vol:vuelos){
            System.out.println(cont+". "+vol);
            cont++;
        }
    }
    public Vuelos buscarVuelos(String numero){
        for (Vuelos conta:vuelos){
            if (conta.getNumero().equalsIgnoreCase(numero)){
                return conta;
            }
        }
        return null;
    }


    public void BuscarVuelosClave(String clave){
        Scanner sc=new Scanner(System.in);
        if (clave.equalsIgnoreCase("Numero")){
            System.out.println("Valor: ");
            String valor= sc.next();
            if (vuelos.contains(buscarVuelos(valor))) {
                System.out.println(buscarVuelos(valor));
                System.out.println();
            }else {
                System.out.println("El vuelo no existe en la lista");
            }
        }else if (clave.equalsIgnoreCase("Origen")){
            System.out.println("Valor: ");
            String valor= sc.next();
            boolean correcto = false;
            for (Vuelos conta:vuelos){
                if (conta.getOrigen().equalsIgnoreCase(valor)){
                    System.out.println(conta);
                    correcto=true;
                }
            }
            if (!correcto){
                System.out.println("El origen ingresado no está en la lista");
            }
        }else if (clave.equalsIgnoreCase("Destino")){
            System.out.println("Valor: ");
            String valor= sc.next();
            boolean correcto = false;
            for (Vuelos conta:vuelos){
                if (conta.getDestino().equalsIgnoreCase(valor)){
                    System.out.println(conta);
                    correcto=true;
                }
            }
            if (!correcto){
                System.out.println("El destino ingresado no está en la lista de vuelos");
            }
        }else if (clave.equalsIgnoreCase("Dia")) {
            System.out.println("Valor: ");
            String valor = sc.next();
            boolean correcto = false;
            for (Vuelos conta : vuelos) {
                if (conta.getDia().equalsIgnoreCase(valor)) {
                    System.out.println(conta);
                    correcto = true;
                }
            }
            if (!correcto) {
                System.out.println("El dia ingresado no está en la lista de vuelos");
            }
        }else if (clave.equalsIgnoreCase("Clase")){
            System.out.println("Valor: ");
            String valor= sc.next();
            boolean correcto = false;
            for (Vuelos conta:vuelos){
                if (conta.getClase().equalsIgnoreCase(valor)){
                    System.out.println(conta);
                    correcto=true;
                }
            }
            if (!correcto){
                System.out.println("La clase ingresada no está en la lista de vuelos");
            }
        }else {
            System.out.println("La clave no existe");
        }
    }
}
