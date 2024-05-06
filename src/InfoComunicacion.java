public class InfoComunicacion {

    protected int radEspacial, anchoBanda;

    //-------------CONSTRUCTOR-------------//
    public InfoComunicacion(int radEspacial, int anchoBanda){
        this.anchoBanda = anchoBanda;
        this.radEspacial = radEspacial;
    }

    @Override
    public String toString() {
        return "{" +
                "Radiación espacial = " + radEspacial +
                ", ancho de banda = " + anchoBanda +
                '}';
    }
}