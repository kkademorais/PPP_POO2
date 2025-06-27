package src2;

import java.util.ArrayList;

public class Revistas extends Biblioteca implements IBiblioteca{


    private String titulo;
    private String org;
    private String vol;
    private String numero;
    private String ano;

    public Revistas(){
    }
    public Revistas(String titulo, String org, String vol, String numero, String ano){
        this.titulo = titulo;
        this.org = org;
        this.vol = vol;
        this.numero = numero;
        this.ano = ano;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getResponsavel() {
        return org;
    }

    public String getVol() {
        return vol;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String getAno() {
        return ano;
    }

    @Override
    public void imprimirMaterial() {
        for(Biblioteca revistas: getMaterialBiblioteca()){
            System.out.println("Revistas: ");
        }
    }
    @Override
    public void adicionarMaterial(Biblioteca materialAdc) {
        getMaterialBiblioteca().add(materialAdc);
        System.out.println("Revista adicionada!");
    }

    @Override
    public String toString() {
        return String.format("Revista: %s - %s Vol %s - Nº %s (%s)", getTitulo(), getResponsavel(), getVol(), getNumero(), getAno());
    }
}