package proyecto.pokemon;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        AdministradorTexto consola = new AdministradorTexto();
        GestorEntrenadores gestor = new GestorEntrenadores();
        ArchivoEntrenadores archivo = new ArchivoEntrenadores("datos/entrenadores.txt");
        ArrayList<Entrenador> entrenadoresCargados = archivo.cargarEntrenadores();

        for (Entrenador entrenador : entrenadoresCargados) {

            gestor.agregarEntrenador(entrenador);

        }

        consola.imprimirMensaje("Entrenadores cargados: " + entrenadoresCargados.size());
        boolean deseaAgregarEntrenador = consola.pedirDecision("Desea agregar mas entrenadores? (s/n): ");

        while (deseaAgregarEntrenador) {

            String nombre = consola.pedirTexto("Ingrese el nombre de el entrenador: ");
            String region = consola.pedirTexto("Ingrese Region de el entrenador: ");
            gestor.registrarEntrenador(nombre, region);
            deseaAgregarEntrenador = consola.pedirDecision("Desea registrar otro entrenador? (s/n): ");

        }

        boolean deseaAgregarPokemonAEquipo = consola.pedirDecision("Desea agregar un pokemon al equipo de algun entrenador? (s/n): ");

        while (deseaAgregarPokemonAEquipo) {

            String nombre = consola.pedirTexto("Digite el nombre de el entrenador a agregar pokemon: ");
            Entrenador entrenador = gestor.buscarEntrenador(nombre);

            if (entrenador == null) {

                consola.imprimirMensaje("El entrenador no esta registrado");

            } else {

                boolean deseaIngresarOtroPokemon = true;

                while (deseaIngresarOtroPokemon) {

                    String nombrePokemon = consola.pedirTexto("Ingrese el nombre de el pokemon: ");
                    String tipo = consola.pedirTexto("Ingrese el tipo de el pokemon: ");
                    int nivel = consola.pedirEntero("Ingrese el nivel de el pokemon: ");

                    Pokemon pokemon = new Pokemon(nombrePokemon, tipo, nivel);
                    EstadoAgregarPokemon estadoAgregarPokemon = entrenador.agregarPokemon(pokemon);

                    switch (estadoAgregarPokemon) {

                        case EQUIPO_LLENO -> consola.imprimirMensaje("EL equipo esta lleno (maximo 6 pokemon)");
                        case POKEMON_DUPLICADO -> consola.imprimirMensaje("Este pokemon ya se encuentra en el equipo");
                        case POKEMON_AGREGADO -> consola.imprimirMensaje("Pokemon agregado exitosamente");

                    }

                    deseaIngresarOtroPokemon = consola.pedirDecision("Desea ingresar otro pokemon? (s/n): ");

                }
            }

            deseaAgregarPokemonAEquipo = consola.pedirDecision("Desea cambiar de entrenador? (s/n): ");

        }

        boolean deseaEliminarPokemon = consola.pedirDecision("Desea eliminar un pokemon? (s/n): ");

        while (deseaEliminarPokemon){

            String nombreEntrenador = consola.pedirTexto("Ingrese el nombre de el entrenador a eliminar pokemon: ");
            Entrenador entrenador = gestor.buscarEntrenador(nombreEntrenador);

            if(entrenador == null){

                consola.imprimirMensaje("El entrenador no esta registrado");

            }

            else {

                String nombrePokemon = consola.pedirTexto("Ingrese el nombre de el pokemon: ");
                EstadoEliminarPokemon estadoEliminarPokemon = entrenador.eliminarPokemon(nombrePokemon);

                switch (estadoEliminarPokemon) {

                    case POKEMON_ELIMINADO -> consola.imprimirMensaje("Pokemon eliminado correctamente");
                    case POKEMON_NO_EXISTENTE -> consola.imprimirMensaje("Este pokemon no se encuentra en el equipo");
                    case EQUIPO_VACIO -> consola.imprimirMensaje("El equipo de este entrenador esta vacio");

                }

                deseaEliminarPokemon = consola.pedirDecision("Desea eliminar otro pokemon? (s/n): ");

            }
        }

        archivo.guardarEntrenadores(gestor.getEntrenadores());
        consola.imprimirMensaje("Entrenadores guardados correctamente");
        consola.imprimirMensaje(gestor.toString());

    }
}

