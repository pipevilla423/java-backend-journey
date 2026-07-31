package proyecto.pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        GestorEntrenadores gestor = new GestorEntrenadores();
        ArchivoEntrenadores archivo = new ArchivoEntrenadores("datos/entrenadores.txt");
        ArrayList<Entrenador> entrenadoresCargados = archivo.cargarEntrenadores();

        for (Entrenador entrenador : entrenadoresCargados) {
            gestor.agregarEntrenador(entrenador);
        }

        System.out.println("Entrenadores cargados: " + entrenadoresCargados.size());
        System.out.println("Desea agregar mas entrenadores? (s/n): ");
        String deseaAgregarEntrenador = scanner.nextLine();
        while (deseaAgregarEntrenador.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el nombre de el entrenador: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese Region de el entrenador: ");
            String region = scanner.nextLine();
            gestor.registrarEntrenador(nombre, region);
            System.out.println("Desea registrar otro entrenador? (s/n): ");
            deseaAgregarEntrenador = scanner.nextLine();
        }

        System.out.println("Desea agregar un pokemon al equipo de algun entrenador? (s/n): ");
        String deseaAgregarPokemonAEquipo = scanner.nextLine();

        while (deseaAgregarPokemonAEquipo.equalsIgnoreCase("s")) {
            System.out.println("Digite el nombre de el entrenador a agregar pokemon: ");
            String nombre = scanner.nextLine();
            Entrenador entrenador = gestor.buscarEntrenador(nombre);
            if (entrenador == null) {
                System.out.println("El entrenador no esta registrado");
            } else {
                String deseaIngresarOtroPokemon = "s";
                while (deseaIngresarOtroPokemon.equalsIgnoreCase("s")) {
                    System.out.println("Ingrese el nombre de el pokemon: ");
                    String nombrePokemon = scanner.nextLine();
                    System.out.println("Ingrese el tipo de el pokemon: ");
                    String tipo = scanner.nextLine();
                    System.out.println("Ingrese el nivel de el pokemon: ");
                    int nivel = scanner.nextInt();
                    scanner.nextLine();
                    Pokemon pokemon = new Pokemon(nombrePokemon, tipo, nivel);
                    EstadoAgregarPokemon estado = entrenador.agregarPokemon(pokemon);
                    switch (estado) {
                        case EQUIPO_LLENO -> System.out.println("EL equipo esta lleno (maximo 6 pokemon)");
                        case POKEMON_DUPLICADO -> System.out.println("Este pokemon ya se encuentra en el equipo");
                        case POKEMON_AGREGADO -> System.out.println("Pokemon agregado exitosamente");
                    }
                    System.out.println("Desea ingresar otro pokemon? (s/n): ");
                    deseaIngresarOtroPokemon = scanner.nextLine();
                }
            }
            System.out.println("Desea cambiar de entrenador? (s/n): ");
            deseaAgregarPokemonAEquipo = scanner.nextLine();
        }

        archivo.guardarEntrenadores(gestor.getEntrenadores());
        System.out.println("Entrenadores guardados correctamente");
        System.out.println(gestor);
    }
}

