import java.util.Random;

public class Arquero extends Soldado {
    private int numeroFlechas;

    public Arquero(String nombre, int ataque, int vida) {
        super(nombre, ataque, vida);
        this.numeroFlechas = generarNumeroFlechas();
        aumentarAtaqueConNumeroFlechas();
    }

    private int generarNumeroFlechas() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private void aumentarAtaqueConNumeroFlechas() {
        aumentarAtaqueConAleatorio(numeroFlechas);
    }

}