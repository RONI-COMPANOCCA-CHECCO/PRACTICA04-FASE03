import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionEjercitos {

    private JFrame frame;
    private JComboBox<String> comboEjercito1;
    private JComboBox<String> comboEjercito2;

    public SeleccionEjercitos() {
        frame = new JFrame("Selección de Ejércitos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Agregar la siguiente línea para centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        JLabel fondo = new JLabel(new ImageIcon("img/batalla.jpg"));
        fondo.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2));

        comboEjercito1 = new JComboBox<>(new String[]{"INGLATERRA", "FRANCIA", "SACRO IMPERIO ROMANO GERMANICO", "ARAGON", "MOROS"});
        comboEjercito2 = new JComboBox<>(new String[]{"INGLATERRA", "FRANCIA", "SACRO IMPERIO ROMANO GERMANICO", "ARAGON", "MOROS"});

        panel.add(new JLabel("Ejército 1:"));
        comboEjercito1.setPreferredSize(new Dimension(20, 30)); // Ajusta el tamaño del JComboBox
        panel.add(comboEjercito1);

        panel.add(new JLabel("Ejército 2:"));
        comboEjercito2.setPreferredSize(new Dimension(20, 30)); // Ajusta el tamaño del JComboBox
        panel.add(comboEjercito2);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setPreferredSize(new Dimension(20, 30)); // Ajusta el tamaño del botón

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setPreferredSize(new Dimension(20, 30)); // Ajusta el tamaño del botón

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ejercitoSeleccionado1 = (String) comboEjercito1.getSelectedItem();
                String ejercitoSeleccionado2 = (String) comboEjercito2.getSelectedItem();

                if (confirmarInicioBatalla()) {
                    iniciarJuego(ejercitoSeleccionado1, ejercitoSeleccionado2);
                }
                frame.dispose();
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(botonAceptar);
        panel.add(botonCancelar);

        fondo.add(panel, BorderLayout.CENTER);
        frame.setContentPane(fondo);
    }

    private boolean confirmarInicioBatalla() {
        int opcion = JOptionPane.showConfirmDialog(frame, "¿Iniciar la batalla?", "Confirmación", JOptionPane.YES_NO_OPTION);
        return opcion == JOptionPane.YES_OPTION;
    }

    private void iniciarJuego(String ejercito1, String ejercito2) {
        SwingUtilities.invokeLater(() -> {
            Tablero tablero = new Tablero(ejercito1, ejercito2);  // Proporciona los nombres de los ejércitos
            tablero.setLocationRelativeTo(frame);
            tablero.setVisible(true);
            // No es necesario llamar a tablero.iniciarJuego(ejercito1, ejercito2) aquí, ya que eso ya se hace en el constructor de Tablero
        });
    }

    public void mostrarVentana() {
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SeleccionEjercitos ventanaSeleccion = new SeleccionEjercitos();
            ventanaSeleccion.mostrarVentana();
        });
    }
}