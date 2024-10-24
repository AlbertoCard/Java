package Vistas;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import Controladores.Controlador;
import Modelos.Usuario;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vista extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelPrincipal, panelBienvenida, panelFormulario;
    private JLabel lblMensaje;
    private JTextField correoField;
    private JPasswordField nipField;
    private JButton btnIngresar, btnCerrarSesion;
    private ImageIcon imgBienvenida;

    public Vista() {
        super("Inicio de Sesión");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        hazInterfaz();
        setVisible(true);
    }

    private void hazInterfaz() {
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        crearPantallaBienvenida();
        crearPantallaInicio();

        panelPrincipal.add(panelBienvenida, "Bienvenida");
        panelPrincipal.add(panelFormulario, "Inicio");

        add(panelPrincipal);
        cardLayout.show(panelPrincipal, "Inicio");       
    }

    private void crearPantallaBienvenida() {
        panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelBienvenida.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        JPanel panelSaludo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.gray);
                g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 25, 25);
                g2.setColor(Color.white);
                g2.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 20, 20);
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 20, 20);
            }
        };
        panelSaludo.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelSaludo.setPreferredSize(new Dimension(750, 700));

        JLabel lblTitulo = new JLabel("Bienvenido");
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(50, 200, 0, 200));

        JLabel lblImagen = new JLabel();
        imgBienvenida = new ImageIcon(getClass().getResource("/Imagenes/mangos.jpeg"));
        Image imgEscala = imgBienvenida.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        lblImagen.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));
        lblImagen.setIcon(new ImageIcon(imgEscala));
        lblImagen.setHorizontalAlignment(JLabel.CENTER);

        btnCerrarSesion = new JButton("Cerrar Sesión");
        estiloBotones(btnCerrarSesion, new Color(231, 76, 60));
        
        panelSaludo.add(lblTitulo);
        panelSaludo.add(lblImagen);
        panelSaludo.add(btnCerrarSesion);
        panelBienvenida.add(panelSaludo);
        panelBienvenida.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        add(panelBienvenida, BorderLayout.CENTER);
    }
    
    private void crearPantallaInicio() {
        JLabel lblImagen = new JLabel();
        imgBienvenida = new ImageIcon(getClass().getResource("/Imagenes/welcome.png"));
        Image imgEscala = imgBienvenida.getImage().getScaledInstance(650, 650, Image.SCALE_SMOOTH);
        lblImagen.setIcon(new ImageIcon(imgEscala));
        lblImagen.setHorizontalAlignment(JLabel.CENTER);

        panelFormulario = new JPanel();
        panelFormulario.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JPanel panelCampos = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.GRAY);
                g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 25, 25);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 20, 20);
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 20, 20);
            }
        };
        panelCampos.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelCampos.setPreferredSize(new Dimension(590, 750));

        JLabel lblLogo = new JLabel();
        ImageIcon logo = new ImageIcon(getClass().getResource("/Imagenes/logo.png"));
        Image imgLogoEscala = logo.getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(imgLogoEscala));
        lblLogo.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        lblLogo.setHorizontalAlignment(JLabel.CENTER);

        correoField = new JTextField();
        cuadrosTexto(correoField, "Correo electrónico");
        correoField.setPreferredSize(new Dimension(550, 100));
        nipField = new JPasswordField();
        cuadrosTexto(nipField, "Contraseña");

        JLabel toggleLabel = createToggleLabel(nipField, "/Imagenes/PadlockClosed.png", "/Imagenes/PadlockOpen.png");

        btnIngresar = new JButton("Iniciar Sesión");
        estiloBotones(btnIngresar, new Color(46, 204, 113));

        lblMensaje = new JLabel("", JLabel.CENTER);
        lblMensaje.setFont(letraPequeña());
        lblMensaje.setPreferredSize(new Dimension(500, 150));

        panelCampos.add(lblLogo);
        panelCampos.add(correoField);
        panelCampos.add(nipField);
        panelCampos.add(toggleLabel);
        panelCampos.add(lblMensaje);
        panelCampos.add(btnIngresar);

        panelFormulario.add(panelCampos);
        panelFormulario.setAlignmentY(JPanel.CENTER_ALIGNMENT);

        add(lblImagen, BorderLayout.WEST);
        add(panelFormulario, BorderLayout.CENTER);
    }

    private void estiloBotones(JButton boton, Color color) {
        boton.setFont(letraGrande());
        boton.setPreferredSize(new Dimension(550, 70));
        boton.setBackground(color);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
    }

    private Font letraGrande() {
        return new Font("Arial", Font.PLAIN, 30);
    }

    private Font letraPequeña() {
        return new Font("Arial", Font.BOLD, 22);
    }

    private void cuadrosTexto(JTextField txt, String titulo) {
        txt.setFont(letraGrande());
        txt.setPreferredSize(new Dimension(550, 100));
        TitledBorder tituloBorder = BorderFactory.createTitledBorder(titulo);
        tituloBorder.setTitleFont(letraPequeña());
        txt.setBorder(tituloBorder);
        txt.setMargin(new Insets(10, 20, 5, 0));
    }

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
        return new JLabel();
    }

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

    public JButton getBtnLogin() {
        return btnIngresar;
    }

    public JButton getBtnLogout() {
        return btnCerrarSesion;
    }

    public String getCorreo() {
        return correoField.getText().trim();
    }

    public String getContraseña() {
        return new String(nipField.getPassword()).trim();
    }

    public void Limpiar() {
        nipField.setText("");
        correoField.setText("");
    }

    public void setListener(Controlador controlador) {
        btnIngresar.addActionListener(controlador);
        btnCerrarSesion.addActionListener(controlador);
    }

    public void mensaje(String mensaje, boolean error) { JOptionPane.showMessageDialog(null, mensaje, error == true ? "Error" : "Exito", error == true ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE); }

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

    public void cambiarTarjeta(String tarjeta) {
        cardLayout.show(panelPrincipal, tarjeta);
    }   
}
