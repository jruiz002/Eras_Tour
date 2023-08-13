public class Localidad {
    /**
     * Atributos de la clase Localidad
     */
    private String tipoLocalidad;
    private double precio;
    private int boletosDisponibles;
    private int boletosVendidos;
   
    /**
     * 
     * @param tipoLocalidad
     * @param precio
     * @param boletosDisponibles
     * @param boletosVendidos
     */
    public Localidad(String tipoLocalidad, double precio, int boletosDisponibles, int boletosVendidos) {
        this.tipoLocalidad = tipoLocalidad;
        this.precio = precio;
        this.boletosDisponibles = boletosDisponibles;
        this.boletosVendidos = boletosVendidos;
    }

    // Getter y setters de los atributos.
    /**
     * 
     * @return el tipo de localidad
     */
    public String getTipoLocalidad() {
        return this.tipoLocalidad;
    }

    /**
     * 
     * @param tipoLocalidad recibe el tipo de localidad
     */
    public void setTipoLocalidad(String tipoLocalidad) {
        this.tipoLocalidad = tipoLocalidad;
    }

    /**
     * 
     * @return el precio de la localidad
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * 
     * @param precio recibe el precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * 
     * @return boletos disponibles de la localidad
     */
    public int getBoletosDisponibles() {
        return this.boletosDisponibles;
    }

    /**
     * 
     * @param boletosDisponibles recibe los boletos disponibles
     */
    public void setBoletosDisponibles(int boletosDisponibles) {
        this.boletosDisponibles = boletosDisponibles;
    }

    /**
     * 
     * @return boletos vendidos
     */
    public int getBoletosVendidos() {
        return this.boletosVendidos;
    }

    /**
     * 
     * @param boletosVendidos recibe los boletos vendidos
     */
    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }

    /**
     * Muestra la información de un objeto de la clase localidad
     */
    @Override
    public String toString() {
        return "{" +
            " tipoLocalidad='" + getTipoLocalidad() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", boletosDisponibles='" + getBoletosDisponibles() + "'" +
            ", boletosVendidos='" + getBoletosVendidos() + "'" +
            "}";
    }

   
}
