package src2.GUI;

import src2.Biblioteca;
import src2.Livros;

import javax.swing.*;
import java.awt.*;

public class ListagemGUI extends JFrame{

    private JFrame janelaPrincipal;
    Biblioteca biblioteca;

    public ListagemGUI(Biblioteca biblioteca){
        this.janelaPrincipal = new JFrame("Listagem dos materiais");
        this.biblioteca = biblioteca;
        criarListagem(biblioteca);
    }

    public JFrame getJanelaPrincipal() {
        return janelaPrincipal;
    }

    private static ListagemGUI instancia;
    public static ListagemGUI getInstancia(Biblioteca biblioteca){
        if(instancia == null) instancia = new ListagemGUI(biblioteca);
        return instancia;
    }

    public void criarListagem(Biblioteca biblioteca){
        janelaPrincipal.setSize(300, 250);
        janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);
        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new GridLayout(biblioteca.getMaterialBiblioteca().size()+1, 1));

        for(Biblioteca material: biblioteca.getMaterialBiblioteca()){
            System.out.println(biblioteca.getMaterialBiblioteca().toString());
            JTextField exibeMaterial = new JTextField(100);
            exibeMaterial.setEditable(false);
            exibeMaterial.setText(material.toString());
            cp.add(exibeMaterial);
        }
        JButton livrosButton = new JButton("Livros");
        JButton revistasButton = new JButton("Revistas");
        JPanel botoesPanel = new JPanel();
        botoesPanel.add(livrosButton);
        botoesPanel.add(revistasButton);
        cp.add(botoesPanel);

        janelaPrincipal.setVisible(true);

        livrosButton.addActionListener(telaLivros -> {
            janelaPrincipal.setVisible(false);
            LivrosGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        });
        revistasButton.addActionListener(telaRevistas -> {
            janelaPrincipal.setVisible(false);
            RevistasGUI.getInstancia(biblioteca).getJanela().setVisible(true);
        });

    }

}
