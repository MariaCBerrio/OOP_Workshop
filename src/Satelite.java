import java.util.Scanner;

public abstract class Satelite implements Datos{

//    Atributos
    protected String tipo, ubicacionOrbita, trayectoria, tipoDatos;
    protected int expectativaVida;
//    Constructor
    public Satelite(String tipo, String ubicacionOrbita, String trayectoria,  String tipoDatos, int expectativaVida) {
        this.tipo = tipo;
        this.ubicacionOrbita = ubicacionOrbita;
        this.trayectoria = trayectoria;
        this.tipoDatos = tipoDatos;
        this.expectativaVida = expectativaVida;
    }

//    Métodos

    @Override
    public void transmitirDatos() {
        String transmitir;
        transmitir = "Transfiriendo información a la base de datos..." +
                     "Transferencia completada con éxito.";
        System.out.println(transmitir);
    }
    @Override
    public void agregarInfo() {

    }
    @Override
    public void calcularVidaUtil(int expectativaVida){
        Scanner input = new Scanner(System.in);
        int tiempoUso;
        System.out.println("\n--------Calculo de vida util--------");
        do {
            System.out.println("Por favor ingrese el tiempo de uso en años hasta el momento del satélite:");
            tiempoUso = input.nextInt();
            if (tiempoUso <= expectativaVida) {
                System.out.println("Calculando vida util restante...");
                expectativaVida -= tiempoUso;
                System.out.println("Ahora, la expectativa de vida del satélite es: " + expectativaVida);
            } else {
                System.out.println("El tiempo de uso no puede ser mayor a la expectativa de vida del satélite. Por favor verifique la información e intente nuevamente.");
            }
        } while(tiempoUso > expectativaVida);

    }

    @Override
    public String toString() {
        return "{" +
                "Tipo = " + tipo  +
                ", ubicación de la órbita = " + ubicacionOrbita  +
                ", trayectoria = " + trayectoria  +
                ", tipo de datos = " + tipoDatos +
                ", expectativa vida = " + expectativaVida + " años" +
                '}' + "\n";
    }

}
