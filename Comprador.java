/**
 * Clase que describe el comportamiento y caracteristica de un comprador en la aplicacion.
 */
public class Comprador {
    /**
     * Atributos de la clase comprador
     */
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;


    public Comprador() {
    }

    /**
     * 
     * @param nombre
     * @param email
     * @param cantidadBoletos
     * @param presupuesto
     */
    public Comprador(String nombre, String email, int cantidadBoletos, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    // Getters y setters de los atributos.

    /**
     * 
     * @return nombre del comprador
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre recibe el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return correo del comprador
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 
     * @param email recibe el correo del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return cantidad de boletos
     */
    public int getCantidadBoletos() {
        return this.cantidadBoletos;
    }

    /**
     * 
     * @param cantidadBoletos recibe la cantidad de boletos
     */
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    /**
     * 
     * @return presupuesto del comprador
     */
    public double getPresupuesto() {
        return this.presupuesto;
    }

    /**
     * 
     * @param presupuesto recibe el presupuesto del comprador
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**Metodo que muestra la informacion de un objeto de tipo comprador */
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", email='" + getEmail() + "'" +
            ", cantidadBoletos='" + getCantidadBoletos() + "'" +
            ", presupuesto='" + getPresupuesto() + "'" +
            "}";
    }
}