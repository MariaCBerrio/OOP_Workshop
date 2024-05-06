import java.util.Scanner;

public class Navegacion extends Satelite{

    protected InfoNavegacion[] infoNavegaciones;
    protected int contadorInfo;

    public Navegacion(String tipo, String ubicacionOrbita, String trayectoria, String tipoDatos, int expectativaVida) {
        super(tipo, ubicacionOrbita, trayectoria, tipoDatos, expectativaVida);
        this.infoNavegaciones = new InfoNavegacion[3];
        this.contadorInfo = 0;
    }

    public void agregarInfo(InfoNavegacion infoNavegacion) {
        if (this.contadorInfo < this.infoNavegaciones.length) {
            this.infoNavegaciones[this.contadorInfo] = infoNavegacion;
            this.contadorInfo++;
        }
    }

    public void distanciaCiudades() {
        String nombreUbicacionActual;
        double x1, y1, x2, y2, senLatitud, senLongitud, cosX1, cosX2;
        int resp1;
        double rTierra, distancia;
        Scanner input = new Scanner(System.in);
//      Datos de la ciudad actual
        System.out.println("Ingrese su ubicación actual, proporcionando los siguientes datos:");
        System.out.printf("Nombre de la ciudad: %4s", "");
        nombreUbicacionActual = input.nextLine();
        System.out.printf("Latitud: %4s", "");
        x1 = Math.toRadians(input.nextDouble());
        System.out.printf("Longitud: %4s", "");
        y1 = Math.toRadians(input.nextDouble());

        System.out.println("Seleccione la ciudad con la cual desea calcular la distancia:");
        for (int i = 0; i < this.infoNavegaciones.length; i++) {
            System.out.println(i + 1 + "." + this.infoNavegaciones[i].nombreUbicacion);
        }
        resp1 = input.nextInt();
//      Datos de los objetos (ciudades) de la clase InfoNavegacion
        x2 = Math.toRadians(this.infoNavegaciones[resp1 - 1].latitud);
        y2 = Math.toRadians(this.infoNavegaciones[resp1 - 1].longitud);
//      Para el calculo se necesita el radio la tierra, a continuación se define
        rTierra = 6371.137;
/*      Ahora calculemos la distancia a partir de la siguiente fórmula:
        Haversine formula: https://www.calculator.net/distance-calculator.html*/
        senLatitud = Math.sin((x2-x1)/2) * Math.sin((x2-x1)/2);
        senLongitud = Math.sin((y2-y1)/2) * Math.sin((y2-y1)/2);
        cosX1 = Math.cos(x1);
        cosX2 = Math.cos(x2);
        distancia = (2 * rTierra) * Math.asin(Math.sqrt(senLatitud + cosX1 * cosX2 * senLongitud));
        distancia = Math.round(distancia * 100.0) / 100.0;

        System.out.println("La distancia entre su ubicación actual y la ciudad destino es:");
        System.out.println(distancia + "km");
    }
}
