public abstract class Satelite implements Datos{

//    Atributos
    protected String tipo, ubicacionOrbita, trayectoria, cantidadDatos, tipoDatos, infMeteorologica;

//    Constructor
    public Satelite(String tipo, String ubicacionOrbita, String trayectoria, String cantidadDatos, String tipoDatos, String infMeteorologica) {
        this.tipo = tipo;
        this.ubicacionOrbita = ubicacionOrbita;
        this.trayectoria = trayectoria;
        this.cantidadDatos = cantidadDatos;
        this.tipoDatos = tipoDatos;
        this.infMeteorologica = infMeteorologica;
    }

//    Métodos
    @Override
    public void recogerDatos() {

    }

    @Override
    public void transmitirDatos() {

    }

    @Override
    public void generarInforme() {

    }

    public void vidaUtil(String tipo, String ubicacionOrbita){
    }


}
