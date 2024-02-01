import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazJuego {

    private JFrame frame;

    public InterfazJuego() {
        frame = new JFrame("Juego de Estrategia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Agregar la siguiente línea para centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Agregar JLabel en la parte superior
        JLabel labelTerritorio = new JLabel("ELIGE UN TERRITORIO", SwingConstants.CENTER);
        labelTerritorio.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(labelTerritorio, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3));

        // Agregar botones con imágenes y etiquetas
        String[] nombres = {"Bosque", "Campo abierto", "Montaña", "Desierto", "Playa"};
        for (int i = 1; i <= 5; i++) {
            JButton boton = createBotonConImagen("img/imagen" + i + ".jpg", nombres[i - 1]);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Al hacer clic, abre la ventana de selección de ejércitos
                    abrirVentanaSeleccionEjercitos();
                }
            });
            panelBotones.add(boton);
        }

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

    private JButton createBotonConImagen(String rutaImagen, String etiqueta) {
        JButton boton = new JButton();
        ImageIcon icono = new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        boton.setIcon(icono);
        boton.setText(etiqueta);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        return boton;
    }

    private void abrirVentanaSeleccionEjercitos() {
        SwingUtilities.invokeLater(() -> {
            SeleccionEjercitos ventanaSeleccion = new SeleccionEjercitos();
            ventanaSeleccion.mostrarVentana();
            frame.dispose(); // Cierra la ventana actual al abrir la nueva
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfazJuego::new);
    }
}