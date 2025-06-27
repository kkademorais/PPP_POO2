package src2;

import src2.GUI.BibliotecaGUI;

public class Main {
    public static void main(String[] args) {

        Biblioteca livros = new Livros();
        Biblioteca revistas = new Revistas();


        Biblioteca biblioteca = new Biblioteca();

        BibliotecaGUI bibliotecaGUI = new BibliotecaGUI(biblioteca);


    }
}
