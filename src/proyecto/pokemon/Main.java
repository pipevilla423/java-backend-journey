package proyecto.pokemon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorEntrenadores gestor = new GestorEntrenadores();
        String decision = "s";

        while(decision.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el nombre de el entrenador: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese Region de el entrenador: ");
            String region = scanner.nextLine();
            gestor.registrarEntrenador(nombre, region);
            System.out.println("Desea registrar otro entrenador? (s/n): ");
            decision = scanner.nextLine();
        }
        decision = "s";
        while(decision.equalsIgnoreCase("s")) {
            System.out.println("Digite el nombre de el entrenador a agregar pokemon: ");
            String nombre = scanner.nextLine();
            Entrenador entrenador = gestor.buscarEntrenador(nombre);
            if (entrenador == null) {
                System.out.println("El entrenador no esta resgistrado");
            } else {
                String decision2 = "s";
                while (decision2.equalsIgnoreCase("s")) {
                    System.out.println("Ingrese el nombre de el pokemon: ");
                    String nombrePokemon = scanner.nextLine();
                    System.out.println("Ingrese el tipo de el pokemon: ");
                    String tipo = scanner.nextLine();
                    System.out.println("Ingrese el nivel de el pokemon: ");
                    int nivel = scanner.nextInt();
                    scanner.nextLine();
                    Pokemon pokemon = new Pokemon(nombrePokemon, tipo, nivel);
                    entrenador.agregarPokemon(pokemon);
                    System.out.println("Desea ingresar otro pokemon? (s/n): ");
                    decision2 = scanner.nextLine();
                }
            }
            System.out.println("Desea cambiar de entrenador? (s/n): ");
            decision = scanner.nextLine();
        }
        System.out.println(gestor);
    }
}
