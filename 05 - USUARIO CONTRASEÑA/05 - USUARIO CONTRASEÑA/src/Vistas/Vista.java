package Vistas;

import javax.swing.*;

import Controladores.Controlador;
import Modelos.Usuario;

import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vista extends JFrame {
    private JPanel panelPrincipal, nipPanel;
    private JLabel iconLabel, correoLabel, nipLabel;
    private JTextField correoField;
    private JPasswordField nipField;
    private JButton btnLogin;

    public Vista() {
        setTitle("Iniciar Sesión");
        realizarInterfaz();
    }

    private void realizarInterfaz() {
        this.setSize(400, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centra la ventana

        // Crear el panel principal con un Layout moderno (GridBagLayout)
        panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(Color.WHITE); // Fondo blanco para un estilo limpio
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Agregar imagen de usuario
        iconLabel = createImageLabel("/Imagenes/Usuario.png", 80, 80);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2; // Hace que la imagen ocupe el espacio de dos filas
        constraints.anchor = GridBagConstraints.CENTER; // Centrar la imagen verticalmente
        panelPrincipal.add(iconLabel, constraints);

        // Etiqueta y campo de texto para el correo
        correoLabel = new JLabel("Correo:");
        correoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; // Volver a una sola fila
        constraints.anchor = GridBagConstraints.LINE_END; // Alinear a la derecha
        panelPrincipal.add(correoLabel, constraints);

        correoField = new JTextField(15);
        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_START; // Alinear a la izquierda
        panelPrincipal.add(correoField, constraints);

        // Etiqueta y campo de texto para el NIP
        nipLabel = new JLabel("NIP:");
        nipLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelPrincipal.add(nipLabel, constraints);

        nipPanel = new JPanel(new BorderLayout());
        nipField = new JPasswordField(15);
        nipField.setEchoChar('•'); // Caracter para ocultar el NIP
        nipPanel.add(nipField, BorderLayout.CENTER);

        // Crear el JLabel para mostrar/ocultar el NIP
        JLabel toggleLabel = createToggleLabel(nipField, "/Imagenes/PadlockClosed.png", "/Imagenes/PadlockOpen.png");

        nipPanel.add(toggleLabel, BorderLayout.EAST); // Añadir el JLabel al panel del NIP
        constraints.gridx = 2;
        constraints.gridwidth = 2; // Hacer que el campo y el icono ocupen espacio juntos
        constraints.anchor = GridBagConstraints.LINE_START;
        panelPrincipal.add(nipPanel, constraints);

        // Botón de Iniciar Sesión
        btnLogin = new JButton("INICIAR SESIÓN");
        btnLogin.setBackground(new Color(76, 175, 80)); // Color verde moderno
        btnLogin.setForeground(Color.WHITE); // Texto en blanco
        btnLogin.setFocusPainted(false); // Quitar borde por defecto
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4; // Ocupa el ancho total del formulario
        constraints.anchor = GridBagConstraints.CENTER;
        this.panelPrincipal.add(btnLogin, constraints);
        this.add(panelPrincipal);
        this.setVisible(true);
    }

    // Método para crear un JLabel con una imagen escalada
    private JLabel createImageLabel(String path, int width, int height) {
        try (InputStream imageStream = getClass().getResourceAsStream(path)) {
            if (imageStream != null) {
                Image img = ImageIO.read(imageStream);
                if (img != null) {
                    img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    return new JLabel(new ImageIcon(img));
                } else {
                    System.out.println("Imagen leída es nula: " + path);
                }
            } else {
                System.out.println("Imagen no encontrada: " + path);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        return new JLabel(); // Retorna un JLabel vacío si hay un error
    }

    // Método para crear el JLabel para el candado
    private JLabel createToggleLabel(JPasswordField nipField, String closedLockPath, String openLockPath) {
        JLabel toggleLabel = createImageLabel(closedLockPath, 20, 20); // Tamaño del icono
        toggleLabel.setPreferredSize(new Dimension(20, 20)); // Tamaño fijo
        toggleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cambiar el cursor para indicar que es
                                                                               // clickeable
        toggleLabel.addMouseListener(new MouseAdapter() {
            private boolean isPasswordVisible = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPasswordVisible) {
                    nipField.setEchoChar('•'); // Volver a ocultar el NIP
                    toggleLabel.setIcon(createImageLabel(closedLockPath, 20, 20).getIcon()); // Cambiar a candado
                                                                                             // cerrado
                } else {
                    nipField.setEchoChar((char) 0); // Mostrar el NIP
                    toggleLabel.setIcon(createImageLabel(openLockPath, 20, 20).getIcon()); // Cambiar a candado abierto
                }
                isPasswordVisible = !isPasswordVisible;
            }
        });
        return toggleLabel;
    }
    @SuppressWarnings("deprecation")
    public Usuario getUsuario()
    {
        Usuario usuario = null;
        if (!correoField.getText().isEmpty() && !nipField.getText().isEmpty())
        {
            usuario = new Usuario(correoField.getText(), nipField.getText());
        }
        return usuario;
    }
    public JButton getBtnLogin() {
        return btnLogin;
    }
    public void mensaje(String mensaje, boolean error) { JOptionPane.showMessageDialog(null, mensaje, error == true ? "Error" : "Exito", error == true ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE); }
    public void setListener(Controlador controlador) {
        btnLogin.addActionListener(controlador);
    }
}