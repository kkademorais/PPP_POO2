package src2.GUI;

import src2.Biblioteca;
import src2.Livros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivrosGUI extends JFrame{

    private JFrame janelaPrincipal;
    private Biblioteca biblioteca;

    public LivrosGUI(Biblioteca biblioteca){
        this.janelaPrincipal = new JFrame("Livros");
        this.biblioteca = biblioteca;
        criarLivro(biblioteca);
    }

    public JFrame getJanelaPrincipal() {
        return janelaPrincipal;
    }

    private static LivrosGUI instancia;
    public static LivrosGUI getInstancia(Biblioteca biblioteca){
        if(instancia == null) instancia = new LivrosGUI(biblioteca);
        return instancia;
    }

    public void criarLivro(Biblioteca biblioteca){

        Biblioteca livros = new Livros();

        //Criação da Janela e do Painel Principal
        janelaPrincipal.setSize(350,200);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null); //Centraliza na tela

        //Container pra manipular o Content Pane
        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new BorderLayout());

        //Label - Título da página no topo
        JLabel livrosLabel = new JLabel("Livros", SwingConstants.CENTER);
        cp.add(livrosLabel, BorderLayout.NORTH);

        //Criação dos campos de texto e do Painel de Texto
        JTextField titulo = new JTextField(50);
        titulo.setMaximumSize(new Dimension(200, titulo.getPreferredSize().height));
        titulo.setAlignmentX(SwingConstants.CENTER);
        JLabel tituloLabel = new JLabel("Título: ", JLabel.LEFT);
        tituloLabel.setLabelFor(titulo);
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new BoxLayout(tituloPanel, BoxLayout.X_AXIS));
        tituloPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        tituloPanel.add(tituloLabel);
        tituloPanel.add(titulo);

        JTextField autor = new JTextField(30);
        autor.setMaximumSize(new Dimension(200, autor.getPreferredSize().height));
        autor.setAlignmentX(SwingConstants.CENTER);
        JLabel autorLabel = new JLabel("Autor: ", JLabel.LEFT);
        autorLabel.setLabelFor(autor);
        JPanel autorPanel = new JPanel();
        autorPanel.setLayout(new BoxLayout(autorPanel, BoxLayout.X_AXIS));
        autorPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        autorPanel.add(autorLabel);
        autorPanel.add(autor);

        JTextField ano = new JTextField(5);
        ano.setMaximumSize(new Dimension(ano.getPreferredSize().width, ano.getPreferredSize().height));
        ano.setAlignmentX(SwingConstants.CENTER);
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


        incluirButton.addActionListener(incluirLivro -> {
            biblioteca.adicionarMaterial(new Livros(titulo.getText(), autor.getText(), ano.getText()));
            titulo.setText("");
            autor.setText("");
            ano.setText("");
        });

        revistasButton.addActionListener(criarRevista -> {
            janelaPrincipal.setVisible(false);
            RevistasGUI.getInstancia(biblioteca).getJanela().setVisible(true);
        });
        listagemButton.addActionListener(listar -> {
            janelaPrincipal.setVisible(false);
            ListagemGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        });


    }

}
