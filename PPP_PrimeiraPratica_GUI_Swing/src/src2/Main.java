package src2;

public class Main {
    public static void main(String[] args) {

        IBiblioteca livros = new Livros();
        IBiblioteca revistas = new Revistas();

        livros.getListaMaterial().add(new Livros(
                "Pequeno Principe",
                "Andrew Garfield",
                2005));

        livros.getListaMaterial().add(new Livros(
                "Harry Potter",
                "JK Rouwling",
                1995));

        revistas.getListaMaterial().add(new Revistas(
                //String titulo, String org, int vol, int numero, int ano
                "Descobrindo a natureza",
                "Nature",
                2,
                18,
                2010
        ));
        revistas.getListaMaterial().add(new Revistas(
                //String titulo, String org, int vol, int numero, int ano
                "História da Grécia Antiga",
                "Discovery Channel",
                4,
                10,
                2025
        ));

        livros.imprimirMaterial();
        revistas.imprimirMaterial();

    }
}
