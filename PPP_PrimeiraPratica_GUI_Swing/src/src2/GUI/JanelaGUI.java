package src2.GUI;

import javax.swing.*;
import java.awt.*;

public class JanelaGUI {
    public JanelaGUI(){

        //Criação da Janela e do Painel Principal
        JFrame janelaPrincipal = new JFrame("Livros");
        janelaPrincipal.setSize(800,500);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new BorderLayout());

        //Label - Título da página no topo
        JLabel livrosLabel = new JLabel("Livros");
        cp.add(livrosLabel, BorderLayout.NORTH);

        //Criação dos campos de texto e do Painel de Texto
        JTextField titulo = new JTextField(50);
        titulo.setMaximumSize(new Dimension(titulo.getPreferredSize().width, titulo.getPreferredSize().height));
        JLabel tituloLabel = new JLabel("Título: ", JLabel.LEFT);
        tituloLabel.setLabelFor(titulo);
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new BoxLayout(tituloPanel, BoxLayout.X_AXIS));
        tituloPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        tituloPanel.add(tituloLabel);
        tituloPanel.add(titulo);

        JTextField autor = new JTextField(30);
        autor.setMaximumSize(new Dimension(autor.getPreferredSize().width, autor.getPreferredSize().height));
        JLabel autorLabel = new JLabel("Autor: ", JLabel.LEFT);
        autorLabel.setLabelFor(autor);
        JPanel autorPanel = new JPanel();
        autorPanel.setLayout(new BoxLayout(autorPanel, BoxLayout.X_AXIS));
        autorPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        autorPanel.add(autorLabel);
        autorPanel.add(autor);

        JTextField ano = new JTextField(5);
        ano.setMaximumSize(new Dimension(ano.getPreferredSize().width, autor.getPreferredSize().height));
        JLabel anoLabel = new JLabel("Ano: ", JLabel.LEFT);
        anoLabel.setLabelFor(ano);
        JPanel anoPanel = new JPanel();
        anoPanel.setLayout(new BoxLayout(anoPanel, BoxLayout.X_AXIS));
        anoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        anoPanel.add(anoLabel);
        anoPanel.add(ano);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(tituloPanel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        textPanel.add(autorPanel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        textPanel.add(anoPanel);
        cp.add(textPanel, BorderLayout.WEST);

        //Criação dos campos de botões e do Painel de Botão
        JButton incluirButton = new JButton("Incluir");
        JButton revistasButton = new JButton("Revistas");
        JButton listagemButton = new JButton("Listagem");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(incluirButton);
        buttonsPanel.add(revistasButton);
        buttonsPanel.add(listagemButton);
        cp.add(buttonsPanel, BorderLayout.SOUTH);


        //janelaPrincipal.pack(); //Ajusta tamanho do JFrame aos seus componentes
        janelaPrincipal.setVisible(true);

    }
    public static void main(String[] args) {
        new JanelaGUI();
    }
}
