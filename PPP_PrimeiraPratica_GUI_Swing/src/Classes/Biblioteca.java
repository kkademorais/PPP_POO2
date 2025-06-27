package Classes;

import java.util.ArrayList;

public class Biblioteca {

        //Atributo principal -> armazena os dados das sub-classes
    private ArrayList<Biblioteca> materialBiblioteca;

        //Construtor
    public Biblioteca(){
        this.materialBiblioteca = new ArrayList<>();
    }

        //Getter e Setter
    public ArrayList<Biblioteca> getMaterialBiblioteca() {
        return materialBiblioteca;
    }
    public void setMaterialBiblioteca(ArrayList<Biblioteca> materialBiblioteca) {
        this.materialBiblioteca = materialBiblioteca;
    }

    public void imprimirMaterial(){
        for(Biblioteca material: materialBiblioteca){
            System.out.println("Material: ");
        }
    }
    public void adicionarMaterial(Biblioteca materialAdc){
        materialBiblioteca.add(materialAdc);
        System.out.println("Material adicionado");
    }

}
