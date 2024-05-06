import java.util.Scanner;

public class Navegacion extends Satelite{

    protected InfoNavegacion[] infoNavegacions;
    protected int contadorInfo;

    public Navegacion(String tipo, String ubicacionOrbita, String trayectoria, String tipoDatos, int expectativaVida) {
        super(tipo, ubicacionOrbita, trayectoria, tipoDatos, expectativaVida);
        this.infoNavegacions = new InfoNavegacion[3];
        this.contadorInfo = 0;
    }
    public void agregarInfo(InfoNavegacion infoNavegacion) {
        if (this.contadorInfo < this.infoNavegacions.length) {
            this.infoNavegacions[this.contadorInfo] = infoNavegacion;
            this.contadorInfo ++;
            transmitirDatos();
        }
        System.out.println("La capacidad de información del sátelite está al límite");
    }

    public void presicionGPS() {
        boolean[] reflectante = new boolean[3];
        boolean[] atmosfera = new boolean[3];
        float distanciaSatelite;
        String presicion;


        distanciaSatelite = 0;

        for(int i = 0; i < infoNavegacions.length; i++) {
            if (!reflectante[i] && !atmosfera[i] && distanciaSatelite >= 50){
                presicion = "Para que el GPS pueda funcionar deben cumplirse las siguientes condiciones, "  +
                        "La ubicacion tiene algun reflejo (Como un gran conjunto de agua):" + reflectante [i] +
                        "La ubicacion del satelite esta en una atmosfera funcional?: " + atmosfera[i] +
                        "El satelite esta lo suficientemente alejado del anterior? " + distanciaSatelite;
            }
        }

        if(this.contadorInfo == infoNavegacions.length){
            for (int i = 0; i < infoNavegacions.length; i++){
                reflectante[i] = this.infoNavegacions[i].multipath;
                atmosfera[i] = this.infoNavegacions[i].ionosferaTroposfera;
                distanciaSatelite = this.infoNavegacions[i].geometria;
            }
        }
    }
}