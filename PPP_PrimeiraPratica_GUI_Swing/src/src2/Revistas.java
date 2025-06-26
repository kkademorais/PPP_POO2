package src2;

import java.util.ArrayList;

public class Revistas implements IBiblioteca{

    private ArrayList<Revistas> revistasList;

    private String titulo;
    private String org;
    private int vol;
    private int numero;
    private int ano;

    public Revistas(){
        this.revistasList = new ArrayList<Revistas>();
    }
    public Revistas(String titulo, String org, int vol, int numero, int ano){
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

    public int getVol() {
        return vol;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int getAno() {
        return ano;
    }

    //Get do revistasList
    @Override
    public void imprimirMaterial() {
        for(Revistas revistas: revistasList){
            System.out.println("Revista: ");
            System.out.printf("Título: %s \n", revistas.getTitulo());
            System.out.printf("Org: %s \n", revistas.getResponsavel());
            System.out.printf("Volume: %d \n", revistas.getVol());
            System.out.printf("Número: %d \n", revistas.getNumero());
            System.out.printf("Ano: %d \n", revistas.getAno());
            System.out.println();
        }
    }

    @Override
    public ArrayList<Revistas> getListaMaterial() {
        return revistasList;
    }

}