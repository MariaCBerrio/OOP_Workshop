public class InfoMeteorologica {

    protected float coordenadas, temperatura, humedad, precipitacion;
    protected String nubosidad;

    public InfoMeteorologica(float coordenadas, float temperatura, float humedad, float precipitacion, String nubosidad) {
        this.coordenadas = coordenadas;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.precipitacion = precipitacion;
        this.nubosidad = nubosidad;
    }

    public float getCoordenadas() {
        return coordenadas;
    }
    public float getTemperatura() {
        return temperatura;
    }
    public float getHumedad() {
        return humedad;
    }
    public float getPrecipitacion() {
        return precipitacion;
    }
    public String getNubosidad() {
        return nubosidad;
    }
}
