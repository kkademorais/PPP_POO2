package src2.GUI;

import src2.Biblioteca;
import src2.Revistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaGUI extends JFrame{

    private JFrame janelaPrincipal;
    Biblioteca biblioteca;

    public BibliotecaGUI(Biblioteca biblioteca){
        this.janelaPrincipal = new JFrame("Biblioteca KKa");
        this.biblioteca = biblioteca;
        criarBiblioteca(biblioteca);
    }

    private static BibliotecaGUI instancia;

    public static BibliotecaGUI getInstancia(Biblioteca biblioteca){
        if(instancia == null) instancia = new BibliotecaGUI(biblioteca);
        return instancia;
    }

    public void criarBiblioteca(Biblioteca biblioteca){

        janelaPrincipal.setSize(350,200);
        janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);
        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        JButton livroButton = new JButton("Livros");
        JButton revistaButton = new JButton("Revistas");
        livroButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        revistaButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        cp.add(Box.createRigidArea(new Dimension(0, 35)));
        cp.add(livroButton);
        cp.add(Box.createRigidArea(new Dimension(0, 15)));
        cp.add(revistaButton);

        janelaPrincipal.setVisible(true);

        livroButton.addActionListener(livroGUI -> {
            janelaPrincipal.setVisible(false);
            LivrosGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        });
        revistaButton.addActionListener(revistaGUI -> {
            janelaPrincipal.setVisible(false);
            RevistasGUI.getInstancia(biblioteca).getJanela().setVisible(true);
        });

    }

}
