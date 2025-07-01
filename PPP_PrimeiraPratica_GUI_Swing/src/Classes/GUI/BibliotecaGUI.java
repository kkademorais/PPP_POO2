package Classes.GUI;

import Classes.Biblioteca;

import javax.swing.*;
import java.awt.*;

public class BibliotecaGUI {

        //Atributos
    private JFrame janelaPrincipal;
    Biblioteca biblioteca;

        //Construtor
    public BibliotecaGUI(){}
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

    public JFrame getJanelaPrincipal() {
        return janelaPrincipal;
    }

    public void configJanelaPrincipal(JFrame janelaPrincipal){
        janelaPrincipal.setSize(350,200);
        janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);
    }

    public void buttonAddActionListener(BibliotecaGUI botao){
        getJanelaPrincipal().setVisible(false);
        botao.getJanelaPrincipal().setVisible(true);
    }


        //Método principal pra criar a tela
    public void criarBiblioteca(Biblioteca biblioteca){

        configJanelaPrincipal(janelaPrincipal);
        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        JButton livroButton = new JButton("Livros");
        JButton revistaButton = new JButton("Revistas");
        JButton filmesButton = new JButton("Filmes"); // Feature nova
        livroButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        revistaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        filmesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        cp.add(Box.createRigidArea(new Dimension(0, 35)));
        cp.add(livroButton);
        cp.add(Box.createRigidArea(new Dimension(0, 15)));
        cp.add(revistaButton);
        cp.add(Box.createRigidArea(new Dimension(0, 15)));
        cp.add(filmesButton);

        janelaPrincipal.setVisible(true);

        livroButton.addActionListener(livros -> buttonAddActionListener(LivrosGUI.getInstancia(biblioteca)));
        revistaButton.addActionListener(revistas -> buttonAddActionListener(RevistasGUI.getInstancia(biblioteca)));
        filmesButton.addActionListener(filmes -> buttonAddActionListener(FilmesGUI.getInstancia(biblioteca)));


    }

}
