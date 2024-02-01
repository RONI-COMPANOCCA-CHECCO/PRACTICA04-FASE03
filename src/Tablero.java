import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Tablero extends JFrame {

    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;
    private static JButton[][] botones;
    private static Soldado[][] soldados; 
    private static Ejercito ejercito11;
    private static Ejercito ejercito22;

    public Tablero(String ejercito1, String ejercito2) {
        // Configuración básica de la ventana
        setTitle("BATALLA " + ejercito1 + " VS " + ejercito2); 
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un layout para la matriz de botones
        GridLayout gridLayout = new GridLayout(FILAS + 1, COLUMNAS + 1);
        setLayout(gridLayout);

        // Añadir una celda vacía en la esquina superior izquierda
        add(createLabel(""));

        // Añadir números de 1 a 10 en la primera fila
        for (int i = 0; i < COLUMNAS; i++) {
            add(createLabel(Integer.toString(i + 1)));
        }

        // Crear matriz de botones
        botones = new JButton[FILAS][COLUMNAS];
        soldados = new Soldado[FILAS][COLUMNAS];
        // Añadir letras A a J en la primera columna a partir de la segunda fila
        for (int i = 0; i < FILAS; i++) {
            add(createLabel(String.valueOf((char) ('A' + i))));
            for (int j = 0; j < COLUMNAS; j++) {
                botones[i][j] = createButton();
                add(botones[i][j]);
            }
        }

        // Añadir dos ejércitos al tablero
//        agregarEjercito("Ejercito1", Color.RED);
//        agregarEjercito("Ejercito2", Color.BLUE);
        ejercito11 = new Ejercito();
        ejercito11.reclutarSoldadosAleatorios();

//        ArrayList<JButton> botonesDisponibles1 = obtenerBotonesDisponibles();
//
//        for (Soldado soldado : ejercito11.getSoldados()) {
//            if (!botonesDisponibles1.isEmpty()) {
//                JButton botonAleatorio = obtenerBotonAleatorio(botonesDisponibles1);
//                botonAleatorio.setText(soldado.getNombre());
//                botonAleatorio.setBackground(Color.red);
//            }
//        }
        ejercito22 = new Ejercito();
        ejercito22.reclutarSoldadosAleatorios();

//        ArrayList<JButton> botonesDisponibles2 = obtenerBotonesDisponibles();
//
//        for (Soldado soldado : ejercito22.getSoldados()) {
//            if (!botonesDisponibles2.isEmpty()) {
//                JButton botonAleatorio = obtenerBotonAleatorio(botonesDisponibles2);
//                botonAleatorio.setText(soldado.getNombre());
//                botonAleatorio.setBackground(Color.blue);
//            }
//        }

        // Crear el controlador del juego
        ControladorJuego controladorJuego = new ControladorJuego(this);

        // Obtener información sobre la memoria
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Total de memoria: " + totalMemory + " bytes");
        System.out.println("Memoria libre: " + freeMemory + " bytes");
        System.out.println("Memoria utilizada: " + usedMemory + " bytes");

        // Hacer visible la ventana
        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

    public int getFilas() {
        return FILAS;
    }

    public int getColumnas() {
        return COLUMNAS;
    }

    private JButton createButton() {
        JButton button = new JButton();
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return button;
    }

    public void iniciarJuego(String ejercito1, String ejercito2) {
        // Puedes agregar lógica específica del juego aquí
        // Por ahora, solo imprimo en la consola
        System.out.println("Iniciando juego con ejércitos:");
        System.out.println("Ejército 1: " + ejercito1);
        System.out.println("Ejército 2: " + ejercito2);
    }

    private void agregarEjercito(String nombre, Color color) {
//        Ejercito ejercito = new Ejercito();
//        ejercito.reclutarSoldadosAleatorios();
//
//        ArrayList<JButton> botonesDisponibles = obtenerBotonesDisponibles();
//
//        for (Soldado soldado : ejercito.getSoldados()) {
//            if (!botonesDisponibles.isEmpty()) {
//                JButton botonAleatorio = obtenerBotonAleatorio(botonesDisponibles);
//                botonAleatorio.setText(soldado.getNombre());
//                botonAleatorio.setBackground(color);
//            }
//        }
    }

    private ArrayList<JButton> obtenerBotonesDisponibles() {
        ArrayList<JButton> botones = new ArrayList<>();
        Component[] componentes = getContentPane().getComponents();

        for (Component componente : componentes) {
            if (componente instanceof JButton && ((JButton) componente).getText().isEmpty()) {
                botones.add((JButton) componente);
            }
        }

        return botones;
    }

    private JButton obtenerBotonAleatorio(ArrayList<JButton> botonesDisponibles) {
        Collections.shuffle(botonesDisponibles);
        JButton botonAleatorio = botonesDisponibles.remove(0);
        return botonAleatorio;
    }

    public JButton[][] getBotones() {
        return botones;
    }  

    public Soldado obtenerSoldadoEnPosicion(int fila, int columna) {
        // Verificar que las coordenadas estén dentro de los límites del tablero
//        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
//            return soldados[fila][columna];
//        } else {
//            return null;
//        }
    	for(int i=0;i<ejercito11.getSoldados().size();i++) {
    	   Soldado soldado=ejercito11.getSoldados().get(i);
    	   if(soldado.getColumna()==columna&&soldado.getFila()==fila) {
    		   return soldado;
    	   }
    	}
    	for(int i=0;i<ejercito22.getSoldados().size();i++) {
     	   Soldado soldado=ejercito22.getSoldados().get(i);
     	   if(soldado.getColumna()==columna&&soldado.getFila()==fila) {
     		   return soldado;
     	   }
     	}
    	return null;
    }

    public void asignarSoldadoEnPosicion(Soldado soldado, int fila, int columna) {
        // Verificar que las coordenadas estén dentro de los límites del tablero
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            soldados[fila][columna] = soldado;
        }
    }

    public static void mostrarTablero(){
    	 for(int i=0; i<soldados.length; i++){
           for (int j =0; j<soldados[i].length; j++){
               botones[i][j].setBackground(Color.white);
               botones[i][j].setName("");
           }
       }
    	for(int i=0; i<ejercito11.getSoldados().size(); i++){
    		int fila=ejercito11.getSoldados().get(i).getFila();
    		int columna=ejercito11.getSoldados().get(i).getColumna();
    		String name=ejercito11.getSoldados().get(i).getNombre();
    		 botones[fila-1][columna-1].setBackground(Color.blue);
    		 botones[fila-1][columna-1].setName(name);
        }
    	for(int i=0; i<ejercito22.getSoldados().size(); i++){
    		int fila=ejercito22.getSoldados().get(i).getFila();
    		int columna=ejercito22.getSoldados().get(i).getColumna();
    		String name=ejercito22.getSoldados().get(i).getNombre();
    		 botones[fila-1][columna-1].setBackground(Color.red);
    		 botones[fila-1][columna-1].setName(name);
         }


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String ejercito1 = "Ejercito1";
            String ejercito2 = "Ejercito2";
            Tablero tablero = new Tablero(ejercito1, ejercito2);
        });
    }

}