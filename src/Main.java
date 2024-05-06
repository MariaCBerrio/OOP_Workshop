import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int resp1;

        Meteorologico satelite1 = new Meteorologico("Meteorológico", "Geoestacionaria", "Sincrónica","Datos meteorológicos", 8);
        InfoMeteorologica infoMeteorologica1 = new InfoMeteorologica(50.8f, 35.1f, 8f, 10f, "Baja" );
        InfoMeteorologica infoMeteorologica2 = new InfoMeteorologica(89.7f, 20.1f, 39.7f, 24,"Media");
        InfoMeteorologica infoMeteorologica3 = new InfoMeteorologica(150.5f,15.7f, 60.5f, 70.3f, "Alta");
        satelite1.agregarInfo(infoMeteorologica1);
        satelite1.agregarInfo(infoMeteorologica2);
        satelite1.agregarInfo(infoMeteorologica3);

        Navegacion satelite2 = new Navegacion("Navegación", "Geoestacionaria", "OTM", "Senales GPS", 5);
//OTM Órbita terrestre media: TIENE UN PERIODO ORBITAL DE 24H, sirve para gps
        InfoNavegacion infoNavegacion1 = new InfoNavegacion(50, true, false);
        InfoNavegacion infoNavegacion2 = new InfoNavegacion(150, true, false);
        InfoNavegacion infoNavegacion3 = new InfoNavegacion(350, true, false);
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

        System.out.println("----------Bienvenido al sistema de satélites----------");

        do{
            System.out.println("Seleccione un tipo de satélite:");
            System.out.println("1.Satélite meteorológico");
            System.out.println("2.Satélite navegación");
            System.out.println("3.Satélite comunicación");
            resp1 = sc.nextInt();
            switch(resp1){
                case 1:
                    System.out.println("Los datos del satélite 1 son:");
                    satelite1.toString();
                    break;
                case 2:
                    System.out.println("Los datos del satélite 2 son:");
                    satelite2.toString();
                    break;
                case 3:
                    System.out.println("Los datos del satélite 3 son:");
                    satelite3.toString();
                    break;
            }
        }while();

        System.out.println("Ahora, el satélite 1");
    }

}
