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
        }
    }

    public void comunicacionesEspaciales() {
        int radiacionEspacial = 0;
        int anchoDeBanda = 0;
        String prediccion;
        Scanner scanner = new Scanner(System.in);

        if (this.contadorComunicacion == this.infoComunicacion.length) {
            for (int i = 0; i < this.infoComunicacion.length; i++) {
                radiacionEspacial += this.infoComunicacion[i].radEspacial;
                anchoDeBanda += this.infoComunicacion[i].anchoBanda;
            }
            radiacionEspacial /= infoComunicacion.length;
            anchoDeBanda /= infoComunicacion.length;

            System.out.println("El satélite de comunicaciones ha recolectado los siguientes datos:");
            for (int i = 0; i < this.infoComunicacion.length; i++) {
                System.out.println("Información " + (i + 1) + ": " + this.infoComunicacion[i].toString());
            }

            System.out.println("\n A continuación, conozca un promedio de los datos recolectados:");
            prediccion = "Radiación espacial: " + radiacionEspacial + "°\n" +
                    "Ancho de banda: " + anchoDeBanda + " MB\n";
            System.out.println(prediccion);

            System.out.println("-------------------------------------------------------------");
            System.out.println("Ahora, ingrese algunos valores para conocer su clasificación.");
            System.out.println("Ingrese el valor de la radiación actual:");
            int radActual = scanner.nextInt();

            String categoria = calcularCategoriaRadiacion(radActual);

            String categoriaAnchoBanda = "";
            boolean comproDoWhile;
            do {
                System.out.println("Ingrese el valor del ancho de banda actual en Megabytes:");
                int anchoBandaActual = scanner.nextInt();
                categoriaAnchoBanda = calcularCategoriaAnchoBanda(anchoBandaActual);
                comproDoWhile = !categoriaAnchoBanda.equals("VALOR NO VÁLIDO");
                if (!comproDoWhile) {
                    System.out.println("Valor de ancho de banda no válido. Intente nuevamente.");
                }
            } while (!comproDoWhile);

            prediccion = "Categoría de radiación actual: " + categoria + "\n" +
                    "Categoría de ancho de banda actual: " + categoriaAnchoBanda;
            System.out.println(prediccion);
        }
    }

    private String calcularCategoriaRadiacion(int radActual) {
        String categoria;
        if (radActual >= 1 && radActual <= 2) {
            categoria = "BAJA";
        } else if (radActual >= 3 && radActual <= 5) {
            categoria = "MODERADA";
        } else if (radActual >= 6 && radActual <= 7) {
            categoria = "ALTA";
        } else if (radActual >= 8 && radActual <= 10) {
            categoria = "MUY ALTA";
        } else {
            categoria = "EXTREMADAMENTE ALTA";
        }
        return categoria;
    }

    private String calcularCategoriaAnchoBanda(int anchoBandaActual) {
        if (anchoBandaActual >= 1 && anchoBandaActual <= 10) {
            return "BAJA";
        } else if (anchoBandaActual > 10 && anchoBandaActual <= 50) {
            return "MODERADA";
        } else if (anchoBandaActual > 50 && anchoBandaActual <= 100) {
            return "ALTA";
        } else if (anchoBandaActual > 1000) {
            return "MUY ALTA";
        } else {
            return "VALOR NO VÁLIDO";
        }
    }

}