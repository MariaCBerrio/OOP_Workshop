import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int resp1, resp2, resp3;

        Meteorologico satelite1 = new Meteorologico("Meteorológico", "Geoestacionaria", "Sincrónica","Datos meteorológicos", 8);
        InfoMeteorologica infoMeteorologica1 = new InfoMeteorologica(50.8f, 35.1f, 8f, 10f, "Baja" );
        InfoMeteorologica infoMeteorologica2 = new InfoMeteorologica(89.7f, 20.1f, 39.7f, 24,"Media");
        InfoMeteorologica infoMeteorologica3 = new InfoMeteorologica(150.5f,15.7f, 60.5f, 70.3f, "Alta");
        satelite1.agregarInfo(infoMeteorologica1);
        satelite1.agregarInfo(infoMeteorologica2);
        satelite1.agregarInfo(infoMeteorologica3);

        Navegacion satelite2 = new Navegacion("Navegación", "Geoestacionaria", "Órbita terrestre media", "Señales GPS", 5);
//OTM Órbita terrestre media
        InfoNavegacion infoNavegacion1 = new InfoNavegacion("Medellín", 6.244203, -75.581211, 1495.0);;
        InfoNavegacion infoNavegacion2 = new InfoNavegacion("Santa Marta", 11.2404, -74.1990, 9.0);
        InfoNavegacion infoNavegacion3 = new InfoNavegacion("Manizales", 5.0689, -75.5174, 2150.0);
        satelite2.agregarInfo(infoNavegacion1);
        satelite2.agregarInfo(infoNavegacion2);
        satelite2.agregarInfo(infoNavegacion3);

        Comunicacion satelite3 = new Comunicacion("Comunicación", "Geoestacionaria", "Circular", "Datos de comunicaciones", 6);
        InfoComunicacion infoComunicacion1 = new InfoComunicacion(5, 120);
        InfoComunicacion infoComunicacion2 = new InfoComunicacion(7, 100);
        InfoComunicacion infoComunicacion3 = new InfoComunicacion( 11, 180);
        satelite3.agregarInfo(infoComunicacion1);
        satelite3.agregarInfo(infoComunicacion2);
        satelite3.agregarInfo(infoComunicacion3);

        System.out.println("\n----------Bienvenido al sistema de gestión de satélites----------");

        do{
            System.out.println("\n Seleccione un tipo de satélite:");
            System.out.println("1.Satélite meteorológico");
            System.out.println("2.Satélite navegación");
            System.out.println("3.Satélite comunicación");
            System.out.println("4.Conocer la vida util de un satélite.");
            System.out.println("5.Trasmitir datos de un satélite a la base de datos.");
            System.out.println("6.Salir");
            resp1 = sc.nextInt();
            switch(resp1){
                case 1:
                    System.out.println("Los datos del satélite 1 son:");
                    System.out.println(satelite1.toString());
                    do {
                        System.out.println("Gracias a los datos recolectados por el satélite 1, es posible obtener una predicción del clima para el día de hoy. ¿Desea conocerla?");
                        System.out.println("1.Sí");
                        System.out.println("2.No");
                        resp2 = sc.nextInt();
                        if (resp2 == 1) {
                            satelite1.predecirClima();
                        } else if (resp2 == 2) {
                            System.out.println("Esperamos ayudarle en una próxima ocasión, ¡Hasta pronto!");
                        } else {
                            System.out.println("Respuesta inválida. Por favor intente nuevamente");
                        }
                    } while (resp2 < 1 || resp2 > 2);
                    break;
                case 2:
                    System.out.println("Los datos del satélite 2 son:");
                    System.out.println(satelite2.toString());
                    do {
                        System.out.println("Gracias a los datos recopilados por nuestro satélite de navegación, podemos conocer la distancia entre dos lugares. ¿Desea hacerlo?" );
                        System.out.println("1.Sí");
                        System.out.println("2.No");
                        resp2 = sc.nextInt();
                        if (resp2 == 1) {
                            satelite2.distanciaCiudades();
                        } else if (resp2 == 2) {
                            System.out.println("Esperamos ayudarle en una próxima ocasión, ¡Hasta pronto!");
                        } else {
                            System.out.println("Respuesta inválida. Por favor intente nuevamente");
                        }
                    } while (resp2 < 1 || resp2 > 2);
                    break;
                case 3:
                    System.out.println("Los datos del satélite 3 son:");
                    System.out.println(satelite3.toString());
                    do {
                        System.out.println("¿Desea conocer los datos obtenidos por el satélite de comunicaciones?" );
                        System.out.println("1.Sí");
                        System.out.println("2.No");
                        resp2 = sc.nextInt();
                        if (resp2 == 1) {
                            satelite3.comunicacionesEspaciales();
                        } else if (resp2 == 2) {
                            System.out.println("Esperamos ayudarle en una próxima ocasión, ¡Hasta pronto!");
                        } else {
                            System.out.println("Respuesta inválida. Por favor intente nuevamente");
                        }
                    } while (resp2 < 1 || resp2 > 2);
                    break;
                case 4:
                    do {
                        System.out.println("Seleccione el satélite al cual desea calcularle la vida útil:");
                        System.out.println("1.Satélite meteorológico");
                        System.out.println("2.Satélite navegación");
                        System.out.println("3.Satélite comunicación");
                        resp3 = sc.nextInt();
                        switch (resp3) {
                            case 1:
                                satelite1.calcularVidaUtil(satelite1.expectativaVida);
                            case 2:
                                satelite1.calcularVidaUtil(satelite2.expectativaVida);
                            case 3:
                                satelite1.calcularVidaUtil(satelite3.expectativaVida);
                            default:
                                System.out.println("Opción inválida. Intente nuevamente");
                        }
                        break;
                    } while (resp3 < 1 || resp3 > 3);
                    break;

                case 5:
                    do {
                        System.out.println("Seleccione el satélite del cual desea transmitir datos:");
                        System.out.println("1.Satélite meteorológico");
                        System.out.println("2.Satélite navegación");
                        System.out.println("3.Satélite comunicación");
                        resp3 = sc.nextInt();
                        switch (resp3) {
                            case 1:
                                satelite1.transmitirDatos();
                            case 2:
                                satelite2.transmitirDatos();
                            case 3:
                                satelite3.transmitirDatos();
                            default:
                                System.out.println("Opción inválida. Intente nuevamente");
                        }
                    } while (resp3 < 1 || resp3 > 3);
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema de gestión de satélites.¡Hasta pronto!");
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente");
            }
        }while(resp1 != 6);

    }

}
