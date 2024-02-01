public class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int vidaActual;
    private static int cuantos = 0;
    private Flyweight flyweight;
    private String tipo;
    private int fila;
    private int columna;

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public Soldado(String nomb, int ataque, int vida) {
        nombre = nomb;
        nivelAtaque = ataque;
        vidaActual = vida;
        cuantos++;
    }

    public void setFlyweight(Flyweight flyweight) {
        this.flyweight = flyweight;
    }

    public Soldado(String tipo, Flyweight flyweight) {
        this.tipo = tipo;
        this.flyweight = flyweight;
    }

    public String getTipo() {  // Agrega el método getTipo()
        return tipo;
    }

    public void mostrarInformacion() {
        flyweight.mostrarInformacion();
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nuevoAtaque) {
        nivelAtaque = nuevoAtaque;
    }

    public static int cuantos() {
        return cuantos;
    }

    public void setVidaActual(int nuevaVida) {
        this.vidaActual = nuevaVida;
    }

    // Método genérico para aumentar el ataque con un valor aleatorio
    protected void aumentarAtaqueConAleatorio(int valorAleatorio) {
        setNivelAtaque(getNivelAtaque() + valorAleatorio);
    }
    
}