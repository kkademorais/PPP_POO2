package src2;

import java.util.ArrayList;

public interface IBiblioteca {
    String getTitulo();
    String getResponsavel();
    int getAno();
    ArrayList getListaMaterial();

    void imprimirMaterial();
    //void adicionarMaterial();
}
