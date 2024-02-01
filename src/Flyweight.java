public class Flyweight {
    private String tipo;

    public Flyweight(String tipo) {
        this.tipo = tipo;
    }

    public void mostrarInformacion() {
        System.out.println("Soldado tipo: " + tipo);
    }
}
