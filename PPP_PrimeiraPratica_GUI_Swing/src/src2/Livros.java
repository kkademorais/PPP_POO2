package src2;

import java.util.ArrayList;

public class Livros extends Biblioteca implements IBiblioteca{

    private String titulo;
    private String autor;
    private String ano;

    public Livros(){
    }
    public Livros(String titulo, String autor, String ano){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        //this.livrosList = new ArrayList<Livros>();
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
    public String getAno() {
        return ano;
    }

    //Get do livrosList
    @Override
    public void imprimirMaterial() {
        for(Biblioteca livros: getMaterialBiblioteca()){
            System.out.println("Livros: ");
        }
    }
    @Override
    public void adicionarMaterial(Biblioteca materialAdc) {
        getMaterialBiblioteca().add(materialAdc);
        System.out.println("Livro adicionado!");
    }

    @Override
    public String toString() {
        return String.format("Livro: %s - %s (%s)", getTitulo(), getResponsavel(), getAno());
    }
}
