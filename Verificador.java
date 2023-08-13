/**
 * Clase que es la encargada de llevar el control de toda la gestion para la solicitud de los boletos,
 * además también muestra y realiza los cálculos para las localidades correspondientes.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Verificador {
    //Instancias de clase donde se crean las localidades.
    private Localidad localidad_1 = new Localidad("Localidad 1", 100, 20, 0);
    private Localidad localidad_5 = new Localidad("Localidad 5", 500, 20, 0);
    private Localidad localidad_10 = new Localidad("Localidad 10", 1000, 20, 0);
    private Localidad localidadAsignada;

    /**
     * 
     * @return Numero aleatorio entre y 15000.
     */
    public int generatorNumbers(){
        Random random = new Random();
        return random.nextInt(15000-1+1)+1;
    }

    // Método que valida si el ticket generado es válido.
    /**
     * 
     * @return {@code true} Si el número se encuentra en el rango establecido, {@code false} Si el número no se encuentra en el rango establecido.
     */
    public boolean verifyTicket(){
        boolean flag = false;
        //Variables que almacenan los numeros generatos aleatoriamente.
        int numberTicket = generatorNumbers();
        int number_a = generatorNumbers();//5
        int number_b = generatorNumbers();//500

        if (number_a > number_b){
            if (numberTicket <= number_a && numberTicket >= number_b) flag = true;
    
        } else if (number_b > number_a){
            if (numberTicket <= number_b && numberTicket >= number_a) flag = true;
        }
        return flag;
    }

    // Método que valida si hay espacios disponibles.
    /**
     * 
     * @param localidadName recibe el nombre de la localidad para verificar si esta disponible
     * @return {@code true} Si la localidad tiene boletos dispobibles, {@code false} Si la localidad no tiene boletos dispobibles.
     */
    public boolean verifyDisponibiltySeat(String localidadName){
        boolean flag = false;
        // Se crea una lista con las localidades del programa
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(localidad_1);
        localidades.add(localidad_5);
        localidades.add(localidad_10);
        // Se recorre la lista para obtener la localidad elegida.
        Localidad localidadEncontrada = null;
        for (Localidad localidad : localidades) {
            if (localidad.getTipoLocalidad().equals(localidadName)) {
                localidadEncontrada = localidad;
                localidadAsignada = localidad;
                break;
            }
        }
        //Si hay boletos dispobible, se cambia el valor de la bandera.
        if (localidadEncontrada.getBoletosDisponibles() > 0) flag = true;
        return flag;
    }

    // Método que valida si la persona puede comprar los boletos que se le asignaron
    /**
     * 
     * @param boletos_Comprar número de boletos a comprar por el usuario
     * @param comprador sirve para obtener el presupuesto del comprador.
     * @return {@code true} Si el presupuesto si es sufiente para comprar los boletos, {@code false} Si el presupuesto no es sufiente para comprar los boletos
     */
    public boolean verifyPrice(int boletos_Comprar, Comprador comprador){
        boolean flag = false;
        double total_pagar = boletos_Comprar * localidadAsignada.getPrecio();
        if (total_pagar <= comprador.getPresupuesto()) flag = true;
        return flag;
    }

    /**
     * 
     * @param comprador sirve para obtener la cantidad de boletos que quiere el usuario y realizar las validaciones.
     * @return {@code true} Si el comprador cumple con todas las validaciones para comprar boletos, {@code false} Si el comprador no cumple con todas las validaciones para comprar boletos
     */
    public boolean newTicketRequest(Comprador comprador){
        Random random = new Random();
        int id_localidad = random.nextInt(3-1+1)+1;
        boolean flag = false;

        String seatlocality = "";
        // Se aligé una localidad aleatoriamente
        if(id_localidad == 1){
            seatlocality = "Localidad 1";
        } else if (id_localidad == 2){
            seatlocality = "Localidad 5";
        } else if (id_localidad == 3){
            seatlocality = "Localidad 10";
        }

        if (verifyDisponibiltySeat(seatlocality)){ // Si hay boletos disponibles
            int boletos_Comprar = 0;
            // Se asigna la cantidad a comprar de boletos
            if (comprador.getCantidadBoletos() > localidadAsignada.getBoletosDisponibles()){
                boletos_Comprar = localidadAsignada.getBoletosDisponibles();
            } else{
                boletos_Comprar = comprador.getCantidadBoletos();
            }
            if (verifyPrice(boletos_Comprar, comprador)){
                // Se crea una lista con las localidades del programa
                List<Localidad> localidades = new ArrayList<>();
                localidades.add(localidad_1);
                localidades.add(localidad_5);
                localidades.add(localidad_10);
                for (Localidad localidad : localidades){
                    if (localidad.getTipoLocalidad().equals(seatlocality)) {
                        // Se setea los boletos dispobibles en ese momento
                        int boletosDisp = localidad.getBoletosDisponibles() - boletos_Comprar;
                        localidad.setBoletosDisponibles(boletosDisp);
                        // Se setea lo boletos vendidos hasta ese momento
                        int boletosVendidos = localidad.getBoletosVendidos() + boletos_Comprar;
                        localidad.setBoletosVendidos(boletosVendidos);
                        flag = true;
                        break;
                    }
                }
            }else{
                System.out.println("Lo sentimos, tu presupuesto no es el sufiente.");
            }
        }else{
            System.out.println("Lo sentimos, ya no hay boletos disponible. Trata mas tarde!");
            System.out.println();
        }

        System.out.println("-------------------Tipo de localidad de los boletos-------------------");
        System.out.println("-" + localidadAsignada.getTipoLocalidad());
        return flag;
    }

    /**
     * Método que muestra cuántos boletos se han vendido en cada localidad y cuantos boletos hay disponibles para las 3 localidades
     */
    public void checkTotalAvailability(){
        System.out.println("Tipo: " + localidad_1.getTipoLocalidad() + "; Boletos Disponibles: " + localidad_1.getBoletosDisponibles() + "; Boletos vendidos: " + localidad_1.getBoletosVendidos());
        System.out.println("Tipo: " + localidad_5.getTipoLocalidad() + "; Boletos Disponibles: " + localidad_5.getBoletosDisponibles() + "; Boletos vendidos: " + localidad_5.getBoletosVendidos());
        System.out.println("Tipo: " + localidad_10.getTipoLocalidad() + "; Boletos Disponibles: " + localidad_10.getBoletosDisponibles() + "; Boletos vendidos: " + localidad_10.getBoletosVendidos());
    }

    /**
     * Método que donde se le pide al usuario que defina una localidad y se muestran solo los boletos disponibles para la localidad seleccionada.
     */
    public void consultIndividualAvailability(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la opción de localidad que desea saber sus boletos disponibles: ");
        System.out.println("1. Localidad 1");
        System.out.println("2. Localidad 5");
        System.out.println("3. Localidad 10");
        int opcion = scanner.nextInt();

        if (opcion == 1){
            System.out.println("Tipo: " + localidad_1.getTipoLocalidad() + "; Boletos Disponibles: " + localidad_1.getBoletosDisponibles());
        } else if (opcion == 2){
            System.out.println("Tipo: " + localidad_5.getTipoLocalidad() + "; Boletos Disponibles: " + localidad_5.getBoletosDisponibles());
        } else if (opcion == 3){
            System.out.println("Tipo: " + localidad_10.getTipoLocalidad() + "; Boletos Disponibles: " + localidad_10.getBoletosDisponibles());
        } else{
            System.out.println("Seleccione una opción válida.");
        }
    }

    /**
     * Método que muestra cuánto se ha generado de dinero dados los boletos vendidos en las 3 localidades
     */
    public void cashReport(){
        double totalGeneral = (localidad_1.getBoletosVendidos()*localidad_1.getPrecio()) + (localidad_5.getBoletosVendidos()*localidad_5.getPrecio()) + (localidad_10.getBoletosVendidos()*localidad_10.getPrecio());
        System.out.println("Tipo: " + localidad_1.getTipoLocalidad() + "; Total: " + (localidad_1.getBoletosVendidos()*localidad_1.getPrecio()));
        System.out.println("Tipo: " + localidad_5.getTipoLocalidad() + "; Total: " + (localidad_5.getBoletosVendidos()*localidad_5.getPrecio()));
        System.out.println("Tipo: " + localidad_10.getTipoLocalidad() + "; Total: " + (localidad_10.getBoletosVendidos()*localidad_10.getPrecio()));
        System.out.println("Total General: ");
        System.out.println(totalGeneral);
    }

}
