import java.util.Random;

public class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin(String nombre, int ataque, int vida) {
        super(nombre, ataque, vida);
        this.longitudEspada = generarLongitudEspada();
        aumentarAtaqueConLongitudEspada();
    }

    private int generarLongitudEspada() {
        Random random = new Random();
        return random.nextInt(4) + 2;
    }

    private void aumentarAtaqueConLongitudEspada() {
        aumentarAtaqueConAleatorio(longitudEspada);
    }

}
