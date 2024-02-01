import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJuego {

    private static Logger logger = new Logger();
    private Tablero tablero;  // Referencia al tablero
    private int filaSoldadoSeleccionado = -1;
    private int columnaSoldadoSeleccionado = -1;
	private boolean select1=true;
    // Puedes agregar más atributos y métodos según sea necesario

    public ControladorJuego(Tablero tablero) {
        this.tablero = tablero;
        inicializarListeners();
    }

    private void inicializarListeners() {
        JButton[][] botones = tablero.getBotones();

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manejarClicBoton((JButton) e.getSource());
                    }
                });
            }
        }
    }

    private void manejarClicBoton(JButton clickedButton) {
        int fila = -1;
        int columna = -1;
        JButton[][] botones = tablero.getBotones();

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (botones[i][j] == clickedButton) {
                    fila = i;
                    columna = j;
                    break;
                }
            }
        }

        if (select1 == true) {
            filaSoldadoSeleccionado = fila + 1;
            columnaSoldadoSeleccionado = columna + 1;
            select1 = false;
            logger.escribirMoverSoldado("SoldadoSeleccionado", filaSoldadoSeleccionado, columnaSoldadoSeleccionado, -1, -1);
        } else {
            select1 = true;
            realizarMovimiento(columnaSoldadoSeleccionado, filaSoldadoSeleccionado, columna + 1, fila + 1);
            logger.escribirMoverSoldado("Movimiento", filaSoldadoSeleccionado, columnaSoldadoSeleccionado, fila + 1, columna + 1);
            fila += 1;
            columna += 1;
            filaSoldadoSeleccionado = -1;
            columnaSoldadoSeleccionado = -1;
        }
    }

    // En la clase ControladorJuego
    private void realizarMovimiento(int columnaOrigen, int filaOrigen, int columnaDestino, int filaDestino) {
        JButton[][] botones = tablero.getBotones();
        Soldado soldadoOrigen = tablero.obtenerSoldadoEnPosicion(filaOrigen, columnaOrigen);
        Soldado soldadoDestino = tablero.obtenerSoldadoEnPosicion(filaDestino, columnaDestino);

        if (soldadoOrigen != null) {
            soldadoOrigen.setPosicion(filaDestino, columnaDestino);
            if (soldadoDestino == null || !soldadoOrigen.getTipo().equals(soldadoDestino.getTipo())) {
                if (soldadoDestino != null) {
                    restarVidaEnemigo(soldadoOrigen, soldadoDestino, botones);
                }
            }
        }
        Tablero.mostrarTablero();
    }

    private void restarVidaEnemigo(Soldado soldadoAtacante, Soldado soldadoDefensor, JButton[][] botones) {
        int nuevaVida = soldadoDefensor.getVidaActual() - soldadoAtacante.getNivelAtaque();
        soldadoDefensor.setVidaActual(Math.max(0, nuevaVida));

        if (nuevaVida <= 0) {
            botones[soldadoDefensor.getFila()][soldadoDefensor.getColumna()].setText("");
            logger.escribirMuerteSoldado("SoldadoMuerto: " + soldadoDefensor.getNombre());
        }
    }
}