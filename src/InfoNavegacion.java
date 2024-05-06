public class InfoNavegacion {

    protected float geometria;
    protected boolean ionosferaTroposfera, multipath;

    public InfoNavegacion(float geometria,boolean ionosferaTroposfera, boolean multipath) {
        this.geometria = geometria; //entre mas separados los satelites mejor senal
        this.multipath = multipath; //objetos reflectantes
        this.ionosferaTroposfera = ionosferaTroposfera; //se debilitan en estas
    }
}

