package gui;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JFrame {

    public Inventario() {
        setTitle("Gestión de Inventarios (solo imágenes)");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior
        JLabel titulo = new JLabel("Imágenes del Inventario de Productos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        add(titulo, BorderLayout.NORTH);

        // Panel central para imágenes
        JPanel panelImagen = new JPanel();
        panelImagen.setLayout(new FlowLayout());

        ImageIcon img1 = new ImageIcon("src/images/audifonos.jpg");
        ImageIcon img2 = new ImageIcon("src/images/cablehdmi.jpg");
        ImageIcon img3 = new ImageIcon("src/images/celular.jpg");
        ImageIcon img4 = new ImageIcon("src/images/laptop.jpg");
        ImageIcon img5 = new ImageIcon("src/images/monitor.jpg");
        ImageIcon img6 = new ImageIcon("src/images/mouse.jpg");
        ImageIcon img7 = new ImageIcon("src/images/mousepad.jpg");
        ImageIcon img8 = new ImageIcon("src/images/pantalla.jpg");
        ImageIcon img9 = new ImageIcon("src/images/parlante.jpg");
        ImageIcon img10 = new ImageIcon("src/images/tablet.jpg");
        ImageIcon img11 = new ImageIcon("src/images/teclado.jpg");


        Image scaled1 = img1.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled2 = img2.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled3 = img3.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled4 = img4.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled5 = img5.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled6 = img6.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled7 = img7.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled8 = img8.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled9 = img9.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
        Image scaled10 = img10.getImage().getScaledInstance(220, 200, Image.SCALE_SMOOTH);
        Image scaled11 = img11.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);

        JLabel imagenProducto1 = new JLabel(new ImageIcon(scaled1));
        JLabel imagenProducto2 = new JLabel(new ImageIcon(scaled2));
        JLabel imagenProducto3 = new JLabel(new ImageIcon(scaled3));
        JLabel imagenProducto4 = new JLabel(new ImageIcon(scaled4));
        JLabel imagenProducto5 = new JLabel(new ImageIcon(scaled5));
        JLabel imagenProducto6 = new JLabel(new ImageIcon(scaled6));
        JLabel imagenProducto7 = new JLabel(new ImageIcon(scaled7));
        JLabel imagenProducto8 = new JLabel(new ImageIcon(scaled8));
        JLabel imagenProducto9 = new JLabel(new ImageIcon(scaled9));
        JLabel imagenProducto10 = new JLabel(new ImageIcon(scaled10));
        JLabel imagenProducto11 = new JLabel(new ImageIcon(scaled11));

        panelImagen.add(imagenProducto1);
        panelImagen.add(imagenProducto2);
        panelImagen.add(imagenProducto3);
        panelImagen.add(imagenProducto4);
        panelImagen.add(imagenProducto5);
        panelImagen.add(imagenProducto6);
        panelImagen.add(imagenProducto7);
        panelImagen.add(imagenProducto8);
        panelImagen.add(imagenProducto9);
        panelImagen.add(imagenProducto10);
        panelImagen.add(imagenProducto11);

        add(panelImagen, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new Inventario().setVisible(true);
    }
}