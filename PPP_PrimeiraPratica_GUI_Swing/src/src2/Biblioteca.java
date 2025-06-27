package src2;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Biblioteca> materialBiblioteca;

    public Biblioteca(){
        this.materialBiblioteca = new ArrayList<>();
    }

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
