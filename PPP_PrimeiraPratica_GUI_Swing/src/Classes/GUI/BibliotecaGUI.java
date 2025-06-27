package Classes.GUI;

import Classes.Biblioteca;

import javax.swing.*;
import java.awt.*;

public class BibliotecaGUI extends JFrame{

        //Atributos
    private JFrame janelaPrincipal;
    Biblioteca biblioteca;

        //Construtor
    public BibliotecaGUI(Biblioteca biblioteca){
        this.janelaPrincipal = new JFrame("Biblioteca KKa");
        this.biblioteca = biblioteca;
        criarBiblioteca(biblioteca);
    }

        //Atributo e getter pra garantir a consistência dos dados
    private static BibliotecaGUI instancia;
    public static BibliotecaGUI getInstancia(Biblioteca biblioteca){
        if(instancia == null) instancia = new BibliotecaGUI(biblioteca);
        return instancia;
    }

        //Método principal pra criar a tela
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

            //ActionListeners pra navegar pras outras telas
        livroButton.addActionListener(livroGUI -> {
            janelaPrincipal.setVisible(false);
            LivrosGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        }); //Ir pra tela de livros
        revistaButton.addActionListener(revistaGUI -> {
            janelaPrincipal.setVisible(false);
            RevistasGUI.getInstancia(biblioteca).getJanela().setVisible(true);
        }); //Ir pra tela de revistas

    }

}
