package Classes;

import java.util.ArrayList;

public class Filmes extends Biblioteca implements IBiblioteca{

        // Atributos
    private String nome;
    private String diretor;
    private String ano;
    private String genero;

        // Construtores
    public Filmes(){
    }
    public Filmes(String nome, String diretor, String ano, String genero){
        this.nome = nome;
        this.diretor = diretor;
        this.ano = ano;
        this.genero = genero;
    }

        // Override dos métodos herdados da interface
    @Override
    public String getAno() {
        return ano;
    }
    @Override
    public String getResponsavel() {
        return diretor;
    }
    @Override
    public String getTitulo() {
        return nome;
    }
    public String getGenero() {
        return genero;
    }

        // Adiciona filme no arrayList de material
    @Override
    public void adicionarMaterial(Biblioteca materialAdc) {
        getMaterialBiblioteca().add(materialAdc);
        System.out.println("Filme adicionado!");
    }
        // Get dos filmes dentro do arrayList
    @Override
    public void imprimirMaterial() {
        for(Biblioteca filmes: getMaterialBiblioteca()){
            System.out.println("Filme: ");
        }
    }

        // Override pra formatar string
    @Override
    public String toString() {
        return String.format("Filme: %s - %s (%s)", getTitulo(), getResponsavel(), getAno());
    }
}
