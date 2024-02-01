//Acceder a un archivo (my_log_game.log) por varios procesos o métodos (3 procesos/metodos) que van a ecribir (Write).

//Ejemplo: ejecucion de querys SQL, Muerte de soldado, Mover soldado.
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private final String logFilePath = "my_log_game.log";

    public synchronized void escribirQuerySQL(String query) {
        escribirEnArchivo("Query SQL: " + query);
    }

    public synchronized void escribirMuerteSoldado(String nombreSoldado) {
        escribirEnArchivo("Muerte del soldado: " + nombreSoldado);
    }

    public synchronized void escribirMoverSoldado(String nombreSoldado, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        escribirEnArchivo("Movimiento del soldado: " + nombreSoldado + " de [" + filaOrigen + "," + columnaOrigen + "] a [" + filaDestino + "," + columnaDestino + "]");
    }

    private void escribirEnArchivo(String mensaje) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            writer.println(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

