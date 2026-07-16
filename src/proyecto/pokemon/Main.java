package proyecto.pokemon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Pokemon mudkip = new Pokemon("agua", 5, "Mudkip");
        Pokemon charmander = new Pokemon("fuego", 5, "Charmander");
        Pokemon chikorita = new Pokemon("planta", 5, "Chikorita");
        Pokemon lucario = new Pokemon("lucha", 5, "Lucario");

        Entrenador pipe = new Entrenador("Pipe", "Kanto");
        Entrenador rafa = new Entrenador("Rafa", "Alola");

        pipe.agregarPokemon(mudkip);
        pipe.agregarPokemon(charmander);

        rafa.agregarPokemon(chikorita);
        rafa.agregarPokemon(lucario);

        System.out.println("\n" + pipe.toString());
        System.out.println("\n" + rafa.toString());




    }
}
