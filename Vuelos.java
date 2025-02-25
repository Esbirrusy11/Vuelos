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
        Scanner sc =new Scanner(System.in);
        boolean boo=true;
        gestionVuelos();

        while (boo){
            System.out.println("¿Cuál es el número del vuelo?");
            String numero=sc.nextLine();
            for (int i = 0; i < numero.length(); i++) {
                if (!Character.isDigit(numero.charAt(i))) {
                    System.out.println("Error el número del vuelo no puede contener letras");
                    System.out.println("¿Cuál es el número del vuelo?");
                    numero=sc.nextLine();
                }if (Character.isDigit(numero.charAt(i))){
                    System.out.println("Vuelo correcto");
                    boo=false;
                    break;
                }
            }
        }

        System.out.println("¿Cuál es el origen del vuelo?");
        String origen=sc.nextLine();
        System.out.println("¿Cuál es el destino del vuelo?");
        String destino=sc.nextLine();
        System.out.println("¿Que día sale el vuelo?");
        String dia=sc.nextLine();
        System.out.println("¿Que clase es el vuelo?");
        String clase=sc.nextLine();
        vuelos.add(new Vuelos(numero,origen,destino,dia,clase));
        System.out.println("El vuelo fue añadido con éxito");
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
           for (Vuelos conta:vuelos){
               if (conta.getOrigen().equalsIgnoreCase(valor)){
                   System.out.println(conta);
               }
           }
       }else if (clave.equalsIgnoreCase("Destino")){
           System.out.println("Valor: ");
           String valor= sc.next();
           for (Vuelos conta:vuelos){
               if (conta.getDestino().equalsIgnoreCase(valor)){
                   System.out.println(conta);
               }
           }
       }else if (clave.equalsIgnoreCase("Dia")){
           System.out.println("Valor: ");
           String valor= sc.next();
           for (Vuelos conta:vuelos){
               if (conta.getDia().equalsIgnoreCase(valor)){
                   System.out.println(conta);
               }
           }
       }else if (clave.equalsIgnoreCase("Clase")){
           System.out.println("Valor: ");
           String valor= sc.next();
           for (Vuelos conta:vuelos){
               if (conta.getClase().equalsIgnoreCase(valor)){
                   System.out.println(conta);
               }
           }
       }else {
           System.out.println("La clave no existe");
       }
    }
}
