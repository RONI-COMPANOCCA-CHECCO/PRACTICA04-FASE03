import java.util.Random;

public class Caballero extends Soldado {
    private int montando;

    public Caballero(String nombre, int ataque, int vida) {
        super(nombre, ataque, vida);
        this.montando = envestir();
        envestida();
    }

    private int envestir() {
        Random random = new Random();
        return random.nextInt(3) + 2;
    }

    private void envestida() {
        aumentarAtaqueConAleatorio(montando);
    }

}