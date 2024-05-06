public class Meteorologico extends Satelite{

    protected InfoMeteorologica[] infoMeteorologicas;
    protected int contadorInfo;

    public Meteorologico(String tipo, String ubicacionOrbita, String trayectoria, String tipoDatos, int expectativaVida) {
        super(tipo, ubicacionOrbita, trayectoria, tipoDatos, expectativaVida);
        this.infoMeteorologicas = new InfoMeteorologica[3];
        this.contadorInfo = 0;
    }

    public void agregarInfo(InfoMeteorologica infoMeteorologica) {
        if (this.contadorInfo < this.infoMeteorologicas.length) {
            this.infoMeteorologicas[this.contadorInfo] = infoMeteorologica;
            this.contadorInfo ++;
            transmitirDatos();
        }
        System.out.println("La capacidad de información del satélite está al límite");
    }
    public void predecirClima(){
        float promedioTemperatura, promedioHumedad, promedioPrecipitacion;
        String prediccion;
        promedioTemperatura = 0;
        promedioHumedad = 0;
        promedioPrecipitacion = 0;
        if (this.contadorInfo == this.infoMeteorologicas.length - 1) {
            for (int i = 0; i < this.infoMeteorologicas.length; i++) {
                promedioTemperatura += this.infoMeteorologicas[i].temperatura;
                promedioHumedad += this.infoMeteorologicas[i].humedad;
                promedioPrecipitacion += this.infoMeteorologicas[i].precipitacion;
            }
            promedioTemperatura /= infoMeteorologicas.length;
            promedioHumedad /= infoMeteorologicas.length;
            promedioPrecipitacion /= infoMeteorologicas.length;

            prediccion = "Según el promedio de datos históricos del satélite meteorológico, " +
                         "es posible predecir los siguientes datos para el día de hoy:" +
                         "Temperatura: " + Math.round(promedioTemperatura) + "°" +
                         "Humedad: " + Math.round(promedioHumedad) + "%" +
                         "Precipitación: " + Math.round(promedioPrecipitacion)+ "%";
            System.out.println(prediccion);
        }
    }
}
