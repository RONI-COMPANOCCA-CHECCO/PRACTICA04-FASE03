import java.util.Random;

public class Lancero extends Soldado {
    private int longitudLanza;

    public Lancero(String nombre, int ataque, int vida) {
        super(nombre, ataque, vida);
        this.longitudLanza = generarLongitudLanza();
        aumentarAtaqueConLongitudLanza();
    }

    private int generarLongitudLanza() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private void aumentarAtaqueConLongitudLanza() {
        aumentarAtaqueConAleatorio(longitudLanza);
    }

}

