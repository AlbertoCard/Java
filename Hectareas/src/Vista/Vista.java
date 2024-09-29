package Vista;

import javax.swing.*;
import java.awt.*;
import Controlador.Controlador;

public class Vista extends JFrame{
    private JLabel titulo, idHectarea,comunidad,renta,ubicacion;
    private JTextField txtIdHectarea, txtComunidad, txtRenta, txtUbicacion;
    private JButton btnRecuperar, btnLimpiar, btnGrabar, btnModificar, btnBorrar, btnConsultar;

    public Vista(){
        super("Hectareas");
        HazInterfaz();
    }

    private void HazInterfaz(){
        setLayout(new GridLayout(0,2,5,5));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        this.setLocationRelativeTo(null);

        titulo = new JLabel("Hectareas",JLabel.CENTER);
        idHectarea = new JLabel("IdHectarea",JLabel.RIGHT);
        comunidad = new JLabel("Comunidad",JLabel.RIGHT);
        renta = new JLabel("Renta",JLabel.RIGHT);
        ubicacion = new JLabel("Ubicacion",JLabel.RIGHT);

        txtIdHectarea = new JTextField();
        txtComunidad = new JTextField();
        txtRenta = new JTextField();
        txtUbicacion = new JTextField();

        btnRecuperar = new JButton("Recuperar");
        btnLimpiar = new JButton("Limpiar");
        btnGrabar = new JButton("Grabar");
        btnModificar = new JButton("Modificar");
        btnBorrar = new JButton("Borrar");
        btnConsultar = new JButton("Consultar");

        add(titulo);
        add(new JLabel(""));
        add(idHectarea);
        add(txtIdHectarea);
        add(comunidad);
        add(txtComunidad);
        add(renta);
        add(txtRenta);
        add(ubicacion);
        add(txtUbicacion);
        add(btnRecuperar);
        add(btnLimpiar);
        add(btnGrabar);
        add(btnModificar);
        add(btnBorrar);
        add(btnConsultar);

        setVisible(true);
    }

    public void Limpiar(){
        txtIdHectarea.setText("");
        txtComunidad.setText("");
        txtRenta.setText("");
        txtUbicacion.setText("");
    }

    public JButton getBtnRecuperar(){
        return btnRecuperar;
    }

    public JButton getBtnLimpiar(){
        return btnLimpiar;
    }

    public JButton getBtnGrabar(){
        return btnGrabar;
    }

    public JButton getBtnModificar(){
        return btnModificar;
    }

    public JButton getBtnBorrar(){
        return btnBorrar;
    }

    public JButton getBtnConsultar(){
        return btnConsultar;
    }

    public void setEscuchador(Controlador controlador){
        btnRecuperar.addActionListener(controlador);
        btnLimpiar.addActionListener(controlador);
        btnGrabar.addActionListener(controlador);
        btnModificar.addActionListener(controlador);
        btnBorrar.addActionListener(controlador);
        btnConsultar.addActionListener(controlador);
    }

}
