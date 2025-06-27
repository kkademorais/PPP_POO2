package Classes;

import Classes.GUI.BibliotecaGUI;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaGUI bibliotecaGUI = new BibliotecaGUI(biblioteca);
    }
}
