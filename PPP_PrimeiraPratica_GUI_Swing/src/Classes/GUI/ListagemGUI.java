package Classes.GUI;

import Classes.Biblioteca;

import javax.swing.*;
import java.awt.*;

public class ListagemGUI extends JFrame{

        //Atributos
    private JFrame janelaPrincipal;
    Biblioteca biblioteca;

        //Construtor
    public ListagemGUI(Biblioteca biblioteca){
        this.janelaPrincipal = new JFrame("Listagem dos materiais");
        this.biblioteca = biblioteca;
        criarListagem(biblioteca);
    }

        //Getter
    public JFrame getJanelaPrincipal() {
        return janelaPrincipal;
    }

        //Atributo e getter pra garantir consistência das telas
    private static ListagemGUI instancia;
    public static ListagemGUI getInstancia(Biblioteca biblioteca){
        if(instancia == null) instancia = new ListagemGUI(biblioteca);
        return instancia;
    }

        //Método principal pra criar a tela
    public void criarListagem(Biblioteca biblioteca){
        janelaPrincipal.setSize(300, 250);
        janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);
        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new GridLayout(biblioteca.getMaterialBiblioteca().size()+1, 1));

            //Cria e adiciona um grid pra cada material
        for(Biblioteca material: biblioteca.getMaterialBiblioteca()){
            System.out.println(biblioteca.getMaterialBiblioteca().toString());
            JTextField exibeMaterial = new JTextField(100);
            exibeMaterial.setEditable(false);
            exibeMaterial.setText(material.toString());
            cp.add(exibeMaterial);
        }
        JButton livrosButton = new JButton("Livros");
        JButton revistasButton = new JButton("Revistas");
        JButton filmesButton = new JButton("Filmes"); // Feature nova
        JPanel botoesPanel = new JPanel();
        botoesPanel.add(livrosButton);
        botoesPanel.add(revistasButton);
        botoesPanel.add(filmesButton);
        cp.add(botoesPanel);

        janelaPrincipal.setVisible(true);

            //ActionListeners pra navegar pras outras telas
        livrosButton.addActionListener(telaLivros -> {
            janelaPrincipal.setVisible(false);
            LivrosGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        }); //Ir pra tela de livros
        revistasButton.addActionListener(telaRevistas -> {
            janelaPrincipal.setVisible(false);
            RevistasGUI.getInstancia(biblioteca).getJanela().setVisible(true);
        }); //Ir pra tela de revistas
        filmesButton.addActionListener(filmes -> {
            janelaPrincipal.setVisible(false);
            FilmesGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        }); //Tela de Filmes -> Feature nova


    }

}
