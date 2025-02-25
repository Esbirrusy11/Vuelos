import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean menu=true;
        Vuelos vuela=new Vuelos();
        ImprimirMenu();
        do {

            Scanner sc=new Scanner(System.in);

            try {
                int i= sc.nextInt();
                vuela.gestionVuelos();
                switch (i){
                    case 0:
                        System.out.println("Chao");
                        menu=false;
                        break;
                    case 1:
                       vuela.printVuelos();
                        break;
                    case 2:

                        if (vuela.vuelos.isEmpty()){
                            System.out.println("No hay vuelos registrados");
                        }else {
                            System.out.println("¿Cuál es el número del vuelo que quieres buscar?");
                            String respu= sc.next();
                            if (vuela.vuelos.contains(vuela.buscarVuelos(respu))) {
                                System.out.println(vuela.buscarVuelos(respu));
                                System.out.println();
                            }else {
                                System.out.println("El vuelo no existe en la lista");
                                break;

                            }
                        }
                        break;
                    case 3:
                        System.out.println("Clave:");
                        String clave= sc.next();
                        vuela.BuscarVuelosClave(clave);
                        break;
                    case 4:
                        vuela.nuevoVuelo();
                        break;
                    case 5:
                        if (vuela.vuelos.isEmpty()){
                            System.out.println("No hay vuelos registrados");
                        }else {
                            System.out.println("¿Cuál es el número del vuelo que quieres eliminar?");
                            String numero= sc.next();
                            if (vuela.vuelos.contains(vuela.buscarVuelos(numero))) {
                                vuela.vuelos.remove(vuela.buscarVuelos(numero));
                                System.out.println("El vuelo "+numero+" fue borrado correctamente");
                                System.out.println();
                            }else {
                                System.out.println("El Número no pertenece a ningún vuelo");
                                System.out.println();
                            }
                        }
                        break;

                    default:
                        System.out.println("Elige una opción válida");
                        ImprimirMenu();
                        System.out.println();


                }
            }catch (InputMismatchException e){
                System.out.println("Error elige una opción válida");
                ImprimirMenu();
                System.out.println();
                sc.nextLine();
            }
        }while (menu);
        System.out.println(" ");
    }
    public static void ImprimirMenu(){
        System.out.println("1 - Imprimir todos los vuelos");
        System.out.println("2 - Buscar un número de vuelo");
        System.out.println("3 - Buscar un vuelo por clave");
        System.out.println("4 - Añadir un nuevo  vuelo");
        System.out.println("5 - Borrar vuelo por número");
        System.out.println("0 - SALIR");
    }
    }

