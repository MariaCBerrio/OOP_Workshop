import java.util.Scanner;

public class Comunicacion extends Satelite{

    //--------------ATRIBUTOS--------------//
    protected InfoComunicacion[] infoComunicacion;
    protected int contadorComunicacion;


    //--------------CONSTRUCTOR--------------//
    public Comunicacion(String tipo, String ubicacionOrbita, String trayectoria, String tipoDatos, int expectativaVida) {
        super(tipo, ubicacionOrbita, trayectoria, tipoDatos, expectativaVida);
        this.contadorComunicacion = 0;
        this.infoComunicacion = new InfoComunicacion[3];
    }

    //--------------MÉTODOS--------------//
    public void agregarInfo(InfoComunicacion infoComunicacion) {
        if (this.contadorComunicacion < this.infoComunicacion.length) {
            this.infoComunicacion[this.contadorComunicacion] = infoComunicacion;
            this.contadorComunicacion ++;
            transmitirDatos();
        }
        System.out.println("La capacidad de información del satélite está al límite");
    }

    public void comunicacionesEspaciales(){
        int radiacionEspacial = 0;
        int anchoDeBanda = 0;
        String prediccion;
        Scanner scanner = new Scanner(System.in);

        if (this.contadorComunicacion == this.infoComunicacion.length){
            for (int i = 0; i < this.infoComunicacion.length; i++) {
                radiacionEspacial += this.infoComunicacion[i].radEspacial;
                anchoDeBanda += this.infoComunicacion[i].anchoBanda;
            }

            radiacionEspacial/=infoComunicacion.length;
            anchoDeBanda/= infoComunicacion.length;

            System.out.println("Ingrese el valor de la radiación actual: ");
            int radActual = scanner.nextInt();

            String categoria = "";
            if (radActual >= 1 && radActual <= 2) {
                categoria = "BAJA";
            } else if (radActual >= 3 && radActual <= 5) {
                categoria = "MODERADA";
            } else if (radActual >= 6 && radActual <= 7) {
                categoria = "ALTA";
            } else if (radActual >= 8 && radActual <= 10) {
                categoria = "MUY ALTA";
            } else if (radActual >= 11) {
                categoria = "EXTREMADAMENTE ALTA";
            }

            System.out.println("Ingrese el valor del ancho de banda actual en Megabytes: ");
            int anchoBanda = scanner.nextInt();

            String categoriaAnchoBanda = "";
            if (anchoBanda >= 1 && anchoBanda <= 10) {
                categoriaAnchoBanda = "BAJA";
            } else if (anchoBanda > 10 && anchoBanda <= 50) {
                categoriaAnchoBanda = "MODERADA";
            } else if (anchoBanda > 50 && anchoBanda <= 100) {
                categoriaAnchoBanda = "ALTA";
            } else if (anchoBanda > 1000) {
                categoriaAnchoBanda = "MUY ALTA";
            } else {
                categoriaAnchoBanda = "VALOR NO VÁLIDO";
            }

            prediccion = "Según el promedio de datos históricos del satélite de comunicaciones, " +
                    "es posible predecir los siguientes datos para el día de hoy:\n" +
                    "Radiación espacial: " + radiacionEspacial + "°\n" +
                    "Ancho de banda: " + anchoDeBanda + "\n" +
                    "Categoría de radiación actual: " + categoria + "\n" +
                    "Categoría de ancho de banda actual: " + categoriaAnchoBanda;
            System.out.println(prediccion);
        }
    }
}