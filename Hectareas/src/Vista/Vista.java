package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Controlador.Controlador;
import Modelo.Hectareas;
import java.util.List;

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

        titulo = new JLabel("CRUD Catalogo",JLabel.RIGHT);
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
        add(new JLabel("de Hectareas",JLabel.LEFT));
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

    public void interfazHectareas(List<Hectareas> hectarea){
        //abrir nueva ventana
        JFrame frame = new JFrame("Catalogo de Hectareas");
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);

        String[] columnas = {"IdHectarea","Comunidad","Renta","Ubicacion"};

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(580,380));


        for (Hectareas hectareas : hectarea){
            modelo.addRow(new Object[]{
                    hectareas.getIdHectarea(),
                    hectareas.getComunidad(),
                    hectareas.getRenta(),
                    hectareas.getUbicacion()
            });
        }


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scroll,BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);

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



    public void setHectarea(Hectareas hectarea){
        txtIdHectarea.setText(hectarea.getIdHectarea()+"");
        txtComunidad.setText(hectarea.getComunidad());
        txtRenta.setText(hectarea.getRenta()+"");
        txtUbicacion.setText(hectarea.getUbicacion());
    }

    public int getIdHectarea() {
        int res = -1;
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog("Introduce la id de la hectarea"));
            if (input != 0) {
                res = input;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
        }
        return res;
    }

    public Hectareas getHectarea(){
        int idHectarea = Integer.parseInt(txtIdHectarea.getText());
        String comunidad = txtComunidad.getText();
        int renta = Integer.parseInt(txtRenta.getText());
        String ubicacion = txtUbicacion.getText();
        Hectareas hectarea = new Hectareas(idHectarea,comunidad,renta,ubicacion);
        return hectarea;
    }

    public String getTxtIdHectarea(){
        return txtIdHectarea.getText();
    }

    public String getTxtRenta(){
        return txtRenta.getText();
    }

    public void setEscuchador(Controlador controlador){
        btnRecuperar.addActionListener(controlador);
        btnLimpiar.addActionListener(controlador);
        btnGrabar.addActionListener(controlador);
        btnModificar.addActionListener(controlador);
        btnBorrar.addActionListener(controlador);
        btnConsultar.addActionListener(controlador);
    }


    public void informarOperacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
