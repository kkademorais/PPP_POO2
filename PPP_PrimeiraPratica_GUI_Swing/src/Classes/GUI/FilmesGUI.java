package Classes.GUI;

import Classes.Biblioteca;
import Classes.Filmes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FilmesGUI extends JFrame {

        // Atributos
    private JFrame janelaPrincipal;
    private Biblioteca biblioteca;

        // Construtor
    public FilmesGUI(Biblioteca biblioteca){
        this.janelaPrincipal = new JFrame("Filmes: ");
        this.biblioteca = biblioteca;
        criarJanela(biblioteca);
    }

    public JFrame getJanelaPrincipal() {
        return janelaPrincipal;
    }

        // Garante consistência das telas
    private static FilmesGUI instancia;
    public static FilmesGUI getInstancia(Biblioteca biblioteca){
        if(instancia == null) instancia = new FilmesGUI(biblioteca);
        return instancia;
    }

        // Método principal pra criar a GUI
    public void criarJanela(Biblioteca biblioteca){

            // Config do jFrame
        janelaPrincipal.setSize(350, 200);
        janelaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);

            // Content Pane principal
        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        JLabel filmesLabel = new JLabel("Filmes", SwingConstants.CENTER);
        cp.add(filmesLabel);


        //String nome, String diretor, String ano, String genero

        JTextField nomeText = new JTextField(30);
        nomeText.setPreferredSize(new Dimension(200, nomeText.getPreferredSize().height));
        JLabel nomeLabel = new JLabel("Título: ");
        JPanel nomePanel = new JPanel();
        nomeLabel.setLabelFor(nomeText);
        nomePanel.setLayout(new BoxLayout(nomePanel, BoxLayout.X_AXIS));
        nomePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeText);

        JTextField diretorText = new JTextField(30);
        diretorText.setPreferredSize(new Dimension(200, diretorText.getPreferredSize().height));
        JLabel diretorLabel = new JLabel("Diretor: ");
        JPanel diretorPanel = new JPanel();
        diretorLabel.setLabelFor(diretorText);
        diretorPanel.setLayout(new BoxLayout(diretorPanel, BoxLayout.X_AXIS));
        diretorPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        diretorPanel.add(diretorLabel);
        diretorPanel.add(diretorText);

        JTextField generoText = new JTextField(30);
        generoText.setPreferredSize(new Dimension(200, generoText.getPreferredSize().height));
        JLabel generoLabel = new JLabel("Gênero: ");
        JPanel generoPanel = new JPanel();
        generoLabel.setLabelFor(generoText);
        generoPanel.setLayout(new BoxLayout(generoPanel, BoxLayout.X_AXIS));
        generoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        generoPanel.add(generoLabel);
        generoPanel.add(generoText);

        JTextField anoText = new JTextField(5);
        anoText.setMaximumSize(new Dimension(anoText.getPreferredSize().width, anoText.getPreferredSize().height));
        JLabel anoLabel = new JLabel("Ano: ");
        JPanel anoPanel = new JPanel();
        anoLabel.setLabelFor(anoText);
        anoPanel.setLayout(new BoxLayout(anoPanel, BoxLayout.X_AXIS));
        anoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        anoPanel.add(anoLabel);
        anoPanel.add(anoText);

            // Panel dos textField e Label pra inserir dados
        JPanel dadosInserirPanel = new JPanel();
        dadosInserirPanel.setLayout(new GridLayout(2,2));
        dadosInserirPanel.add(nomePanel);
        dadosInserirPanel.add(diretorPanel);
        dadosInserirPanel.add(generoPanel);
        dadosInserirPanel.add(anoPanel);


            // Botões e Panel respectivos
        JButton livrosButton = new JButton("Livros");
        JButton revistasButton = new JButton("Revistas");
        JPanel guiButtonsPanel = new JPanel();
        guiButtonsPanel.setLayout(new GridLayout(1, 2));
        guiButtonsPanel.add(livrosButton);
        guiButtonsPanel.add(revistasButton);

        JButton incluirButton = new JButton("Incluir");
        JButton listagemButton = new JButton("Listagem");
        JPanel manipulaDadosButtonPanel = new JPanel();
        manipulaDadosButtonPanel.setLayout(new GridLayout(1, 2));
        manipulaDadosButtonPanel.add(incluirButton);
        manipulaDadosButtonPanel.add(listagemButton);

        cp.add(dadosInserirPanel);
        cp.add(guiButtonsPanel);
        cp.add(manipulaDadosButtonPanel);
        janelaPrincipal.setVisible(true);

            // ActionListener pra ir pra GUI de livros
        livrosButton.addActionListener(livros -> {
            janelaPrincipal.setVisible(false);
            LivrosGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        });

            // ActionListener pra ir pra GUI de revistas
        revistasButton.addActionListener(revistas -> {
            janelaPrincipal.setVisible(false);
            RevistasGUI.getInstancia(biblioteca).getJanela().setVisible(true);
        });

            // ActionListener pra ir pra GUI de listagem
        listagemButton.addActionListener(listar -> {
            janelaPrincipal.setVisible(false);
            ListagemGUI.getInstancia(biblioteca).getJanelaPrincipal().setVisible(true);
        });

            // ActionListener pra incluir dados inseridos no arrayList principal
        incluirButton.addActionListener(inserirDados -> {
            biblioteca.adicionarMaterial(new Filmes(nomeText.getText(), diretorText.getText(), anoText.getText(), generoText.getText()));
            nomeText.setText("");
            diretorText.setText("");
            anoText.setText("");
            generoText.setText("");
        });





    }


    public static void main(String[] args) {
        new FilmesGUI(new Biblioteca());
    }

}
