package Classes.GUI;

import Classes.Biblioteca;
import Classes.Revistas;

import javax.swing.*;
import java.awt.*;

public class RevistasGUI extends BibliotecaGUI{

        //Atributos
    private JFrame janelaPrincipal;
    private Biblioteca biblioteca;

        //Getter
    public JFrame getJanela() {
        return janelaPrincipal;
    }
    @Override
    public JFrame getJanelaPrincipal() {
        return janelaPrincipal;
    }

        //Construtor
    public RevistasGUI(Biblioteca biblioteca){
        this.janelaPrincipal = new JFrame("Revistas");
        this.biblioteca = biblioteca;
        criarRevista(biblioteca);
    }

        //Atributo e getter pra garantir consistência das telas
    private static RevistasGUI instancia;
    public static RevistasGUI getInstancia(Biblioteca biblioteca){
        if(instancia==null) instancia = new RevistasGUI(biblioteca);
        return instancia;
    }

    @Override
    public void configJanelaPrincipal(JFrame janelaPrincipal) {
        super.configJanelaPrincipal(janelaPrincipal);
    }

    @Override
    public void buttonAddActionListener(BibliotecaGUI botao) {
        super.buttonAddActionListener(botao);
    }

    //Método principal -> cria tela
    public void criarRevista(Biblioteca biblioteca){

        //Criação da Janela e do Painel Principal
        configJanelaPrincipal(janelaPrincipal);

        //Container pra manipular o Content Pane
        Container cp = janelaPrincipal.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));

        //Label - Título da página no topo
        JLabel revistasLabel = new JLabel("Revistas", SwingConstants.CENTER);
        revistasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cp.add(revistasLabel);

        //Criação dos campos de texto e do Painel de Texto
            //Título: campo de texto
        JTextField titulo = new JTextField(50);
        titulo.setMaximumSize(new Dimension(200, titulo.getPreferredSize().height));
        titulo.setAlignmentX(SwingConstants.CENTER);
            //Título: label de id
        JLabel tituloLabel = new JLabel("Título: ", JLabel.LEFT);
        tituloLabel.setLabelFor(titulo);
            //Título: panel de layout
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new BoxLayout(tituloPanel, BoxLayout.X_AXIS));
        tituloPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        tituloPanel.add(tituloLabel);
        tituloPanel.add(titulo);

            //Org: campo de texto
        JTextField org = new JTextField(30);
        org.setMaximumSize(new Dimension(200, org.getPreferredSize().height));
        org.setAlignmentX(SwingConstants.CENTER);
            //Org: label de id
        JLabel orgLabel = new JLabel("Org: ", JLabel.LEFT);
        orgLabel.setLabelFor(org);
            //Org: panel de layout
        JPanel orgPanel = new JPanel();
        orgPanel.setLayout(new BoxLayout(orgPanel, BoxLayout.X_AXIS));
        orgPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        orgPanel.add(orgLabel);
        orgPanel.add(org);

            //Panel pra título e org
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2,1));
        textPanel.add(tituloPanel);
        textPanel.add(orgPanel);
        textPanel.setMaximumSize(new Dimension(200, textPanel.getPreferredSize().height));

        cp.add(textPanel);


        //Vol: campo de texto
        JTextField vol = new JTextField(5);
        vol.setMaximumSize(new Dimension(vol.getPreferredSize().width, vol.getPreferredSize().height));
        vol.setAlignmentX(SwingConstants.CENTER);
        //Vol: label de id
        JLabel volLabel = new JLabel("Vol: ", JLabel.LEFT);
        volLabel.setLabelFor(vol);
        //Vol: panel de layout
        JPanel volPanel = new JPanel();
        volPanel.setLayout(new BoxLayout(volPanel, BoxLayout.X_AXIS));
        volPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        volPanel.add(volLabel);
        volPanel.add(vol);

        //Nº: campo de texto
        JTextField nro = new JTextField(5);
        nro.setMaximumSize(new Dimension(nro.getPreferredSize().width, nro.getPreferredSize().height));
        nro.setAlignmentX(SwingConstants.CENTER);
        //Nº: label de id
        JLabel nroLabel = new JLabel("Nº: ", JLabel.LEFT);
        nroLabel.setLabelFor(nro);
        //Nº: panel de layout
        JPanel nroPanel = new JPanel();
        nroPanel.setLayout(new BoxLayout(nroPanel, BoxLayout.X_AXIS));
        nroPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        nroPanel.add(nroLabel);
        nroPanel.add(nro);

        //Ano: campo de texto
        JTextField ano = new JTextField(5);
        ano.setMaximumSize(new Dimension(ano.getPreferredSize().width, ano.getPreferredSize().height));
        ano.setAlignmentX(SwingConstants.CENTER);
        //Ano: label de id
        JLabel anoLabel = new JLabel("Ano: ", JLabel.LEFT);
        anoLabel.setLabelFor(ano);
        //Ano: panel de layout
        JPanel anoPanel = new JPanel();
        anoPanel.setLayout(new BoxLayout(anoPanel, BoxLayout.X_AXIS));
        anoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        anoPanel.add(anoLabel);
        anoPanel.add(ano);

        JPanel minorTextPanel = new JPanel();
        minorTextPanel.add(volPanel);
        minorTextPanel.add(nroPanel);
        minorTextPanel.add(anoPanel);

        cp.add(minorTextPanel);

        //Criação dos campos de botões e do Painel de Botão
        JButton incluirButton = new JButton("Incluir");
        JButton livrosButton = new JButton("Livros");
        JButton filmesButton = new JButton("Filmes");
        JButton listagemButton = new JButton("Listagem");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(incluirButton);
        buttonsPanel.add(livrosButton);
        buttonsPanel.add(filmesButton); // Feature nova
        buttonsPanel.add(listagemButton);
        cp.add(buttonsPanel);

        //janelaPrincipal.pack(); //Ajusta tamanho do JFrame aos seus componentes
        janelaPrincipal.setVisible(true);

            //ActionListener de incluir revista
        incluirButton.addActionListener(inserirRevista -> {
            biblioteca.adicionarMaterial(new Revistas(titulo.getText(), org.getText(), vol.getText(), nro.getText(), ano.getText()));
            titulo.setText("");
            org.setText("");
            vol.setText("");
            nro.setText("");
            ano.setText("");
        });

        livrosButton.addActionListener(livros -> buttonAddActionListener(LivrosGUI.getInstancia(biblioteca)));
        listagemButton.addActionListener(listar -> buttonAddActionListener(ListagemGUI.getInstancia(biblioteca)));
        filmesButton.addActionListener(filmes -> buttonAddActionListener(FilmesGUI.getInstancia(biblioteca)));

    }


}
