import java.util.ArrayList;
import java.util.Random;

public class Ejercito {
    private ArrayList<Soldado> soldados;

    public Ejercito() {
        this.soldados = new ArrayList<>();
    }

    public void reclutarSoldadosAleatorios() {
        Random random = new Random();
        int cantidadSoldados = random.nextInt(11); // Entre 0 y 10 soldados

        for (int i = 0; i < cantidadSoldados; i++) {
            Soldado soldado = crearSoldadoAleatorio();
            int fila=(int)(Math.random()*10+1);
            int columna=(int)(Math.random()*10+1);
            soldado.setPosicion(fila, columna);
            soldados.add(soldado);
        }
    }

    private Soldado crearSoldadoAleatorio() {
        Random random = new Random();
        int tipoSoldado = random.nextInt(4);

        switch (tipoSoldado) {
            case 0:
                return new Lancero("L" + Soldado.cuantos(), 3, 10);
            case 1:
                return new Caballero("C" + Soldado.cuantos(), 5, 15);
            case 2:
                return new Arquero("A" + Soldado.cuantos(), 4, 12);
            case 3:
                return new Espadachin("E" + Soldado.cuantos(), 6, 14);
            default:
                return null; // Nunca debería llegar aquí
        }
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public static void main(String[] args) {
        Ejercito ejercito = new Ejercito();
        ejercito.reclutarSoldadosAleatorios();

        System.out.println("Soldados reclutados:");
        for (Soldado soldado : ejercito.getSoldados()) {
            System.out.println(soldado.getNombre() + " - Ataque: " + soldado.getNivelAtaque() + " - Vida: " + soldado.getVidaActual());
        }
    }
}

