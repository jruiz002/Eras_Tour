/**
 * - Clase que posee el método main, lo cual permite ser el archivo de arranque del programa.
 * - Sistema que permite realizar la compra de boletos para el concierto de Taylor Swift, por medio de validaciones
 *   que evaluan si una persona tiene la capacidad de comprar boletos, asimismo también se toma en cuenta si existen boletos 
 *   disponibles en las localidad establecidas, a continuación se describe cada localidad.
 *      a. Localidad 1 - La más alejada del escenario pero la más barata con un precio de $100.
        b. Localidad 5 - En medio y con una mejor vista al escenario pero con un precio de $500.
        c. Localidad 10 - Hasta adelante, la mejor vista del concierto pero la más cara con un precio de $1000.
   - Además el usuario también puede visualizar cuantos boletos disponibles y vendidos hay en cada localidad, según las operaciones que se han realizado.
   - Es importante mencionar que si el usuario no cumple con alguno de los requisitos su solicitud de compra será rechazada.
 * @author Jose Gerardo Ruiz García
 * @version 0.1, 11/08/2023
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Instancias
        Comprador comprador = new Comprador();
        Verificador verificador = new Verificador();

        //Variables de clase
        Scanner sc = new Scanner(System.in);
        
        boolean continueProgram = true;
        int option = 0;

        // segmento de código que permite controlar el flujo de las operaciones.
        while(continueProgram){
            menu();
            option = sc.nextInt();
            if (option == 1){ // Nuevo comprador:
                solicitudDatos(comprador);

            }else if (option == 2){ // Nueva solicitud de boletos
                if (verificador.verifyTicket()){
                    solicitudDatos(comprador);
                    if (verificador.newTicketRequest(comprador)){
                        System.out.println("Compra exitosa");
                    } else{
                        System.out.println("No se cumplen con todos los requisitos para poder comprar los boletos.");
                    }
                }else{
                    System.out.println("- Lo sentimos, tu ticket no es apto para poder comprar boletos.");
                    System.out.println();
                }
                
            }else if (option == 3){ // Consultar disponibilidad tota
                verificador.checkTotalAvailability();

            }else if (option == 4){ // Consultar disponibilidad individua
                verificador.consultIndividualAvailability();

            }else if (option == 5){ // Reporte de caja
                verificador.cashReport();
            }else if (option == 6){ // Salir
                System.out.println("Gracias por usar el programa.");
                continueProgram = false;
            }else{ // Ingrese una opción válida
                System.out.println("Ingrese una opción válida.");
            }
        }

    }

    /**
     * 
     * @param comprador recibe una instancia de comprador para setear los valores recibidos
     */
    public static void solicitudDatos(Comprador comprador){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre por favor: ");
        String nombre = sc1.nextLine();
        comprador.setNombre(nombre);
        System.out.println();

        System.out.println("Ingrese su email por favor: ");
        String email = sc1.nextLine();
        comprador.setEmail(email);
        System.out.println();
        
        System.out.println("Ingrese la cantidad de boletos que desea: ");
        int boletos = sc.nextInt();
        comprador.setCantidadBoletos(boletos);
        System.out.println();
        
        System.out.println("Ingrese su presupuesto: ");
        double presupuesto = sc.nextDouble();
        comprador.setPresupuesto(presupuesto);
        System.out.println();

        System.out.println(comprador.toString()); 

        System.out.println();
    }

    public static void menu(){
        System.out.println();
        System.out.println("---------BIENVENIDO---------");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Ingrese la opción que desea: ");
    }
}