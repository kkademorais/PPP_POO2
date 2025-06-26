package src2;

import java.util.ArrayList;

public class Livros implements IBiblioteca{

    private ArrayList<Livros> livrosList;

    private String titulo;
    private String autor;
    private int ano;

    public Livros(){
        this.livrosList = new ArrayList<Livros>();
    }
    public Livros(String titulo, String autor, int ano){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.livrosList = new ArrayList<Livros>();
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getResponsavel() {
        return autor;
    }

    @Override
    public int getAno() {
        return ano;
    }

    //Get do livrosList
    @Override
    public void imprimirMaterial() {
        for(Livros livros: livrosList){
            System.out.println("Livro: ");
            System.out.printf("Título: %s \n", livros.getTitulo());
            System.out.printf("Autor: %s \n", livros.getResponsavel());
            System.out.printf("Ano: %s \n", livros.getAno());
            System.out.println();
        }
    }

    @Override
    public ArrayList<Livros> getListaMaterial() {
        return livrosList;
    }

    // @Override
    //public void adicionarMaterial() {
    //    livrosList.add(Livros e);
    //}
}
