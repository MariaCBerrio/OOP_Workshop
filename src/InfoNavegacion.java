public class InfoNavegacion {
    protected double latitud, longitud, altitud;
    protected String nombreUbicacion;

    public InfoNavegacion(String nombreUbicacion, double latitud, double longitud, double altitud ) {
        this.nombreUbicacion = nombreUbicacion;
        this.altitud = altitud;
        this.longitud = longitud;
        this.latitud = latitud;
    }
}
