package proyecto.pokemon;

import java.io.IOException;
import java.util.ArrayList;

public class Aplicacion {

    private final AdministradorTexto consola;
    private final GestorEntrenadores gestor;
    private final ArchivoEntrenadores archivo;

    public Aplicacion(){
        this.consola = new AdministradorTexto();
        this.gestor = new GestorEntrenadores();
        this.archivo =  new ArchivoEntrenadores("datos/entrenadores.txt");
    }

    public void iniciar() throws IOException {
        cargarEntrenadores();
        agregarEntrenador();
        agregarPokemon();
        eliminarPokemon();
        consultarPokemonDeEntrenador();
        editarInformacionDePokemon();
        guardarEntrenadores();
        mostrarEstadoEntrenadores();
    }

    private void cargarEntrenadores() throws IOException{
        ArrayList<Entrenador> entrenadoresCargados = archivo.cargarEntrenadores();
        for (Entrenador entrenador: entrenadoresCargados){
            gestor.agregarEntrenador(entrenador);
        }
        consola.imprimirMensaje("Entrenadores cargados: "+ entrenadoresCargados.size());
    }

    private void agregarEntrenador(){
        boolean deseaAgregarEntrenador = consola.pedirDecision("Desea agregar entrenador? (s/n): ");
        while(deseaAgregarEntrenador){
            String nombre = consola.pedirTexto("Ingrese el nombre de el entrenador: ");
            String region = consola.pedirTexto("Ingrese Region de el entrenador: ");
            gestor.registrarEntrenador(nombre, region);
            deseaAgregarEntrenador = consola.pedirDecision("Desea registrar otro entrenador? (s/n): ");
        }
    }

    private void agregarPokemon(){
        boolean deseaAgregarPokemonAEquipo = consola.pedirDecision("Desea agregar pokemon a el equipo de un entrenador? (s/n): ");
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

    }

    private void eliminarPokemon(){
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

    }

    private void consultarPokemonDeEntrenador(){
        boolean deseaConsultarInformacionDePokemon = consola.pedirDecision("Desea consultar informacion de un pokemon? (s/n)");
        while (deseaConsultarInformacionDePokemon){
            String nombreEntrenador = consola.pedirTexto("Ingrese el nombre de el entrenador: ");
            Entrenador entrenador = gestor.buscarEntrenador(nombreEntrenador);
            if(entrenador != null){
                if(entrenador.equipoVacio()){
                    consola.imprimirMensaje("El equipo de el entrenador esta vacio");
                }
                else {
                    consola.imprimirMensaje("---Equipo de el entrenador---");
                    for (Pokemon pokemon : entrenador.obtenerEquipo()) {
                        consola.imprimirMensaje("- " + pokemon.getNombre());
                    }
                    String nombrePokemon = consola.pedirTexto("Ingrese el nombre de el pokemon: ");
                    Pokemon pokemon = entrenador.buscarPokemonPorNombre(nombrePokemon);
                    if (pokemon != null) {
                        consola.imprimirMensaje(pokemon.toString());
                    } else {
                        consola.imprimirMensaje("Pokemon no existente en el equipo");
                    }
                }
            }
            else {
                consola.imprimirMensaje("Entrenador no existente");
            }
            deseaConsultarInformacionDePokemon = consola.pedirDecision("Desea consultar la informacion de otro pokemon? (s/n): ");
        }
    }

    private void editarInformacionDePokemon(){
        boolean deseaEditarInformacionPokemon = consola.pedirDecision("Desea modificar la informacion de un pokemon? (s/n): ");
        while (deseaEditarInformacionPokemon){
            String nombreEntrenador = consola.pedirTexto("Ingrese el nombre de el entrenador: ");
            Entrenador entrenador = gestor.buscarEntrenador(nombreEntrenador);
            if(entrenador != null){
                if(entrenador.equipoVacio()){
                    consola.imprimirMensaje("El equipo de el entrenador esta vacio");
                }
                else {
                    consola.imprimirMensaje("---Equipo de el entrenador---");
                    for (Pokemon pokemon : entrenador.obtenerEquipo()) {
                        consola.imprimirMensaje("- " + pokemon.getNombre());
                    }
                    String nombrePokemon = consola.pedirTexto("Ingrese el nombre de el pokemon a editar informacion: ");
                    Pokemon pokemon = entrenador.buscarPokemonPorNombre(nombrePokemon);
                    if (pokemon!= null) {
                        consola.imprimirMensaje(pokemon.toString());
                        String atributoAModificar = consola.pedirTexto("Que atributo desea modificar? (nombre, tipo, nivel): ");
                        if (atributoAModificar.equalsIgnoreCase("nombre")) {
                            String nuevoNombrePokemon = consola.pedirTexto("Ingrese el nuevo nombre de el pokemon: ");
                            switch (entrenador.editarNombrePokemon(pokemon, nuevoNombrePokemon)) {
                                case EstadoEditarInformacionPokemon.POKEMON_DUPLICADO ->
                                        consola.imprimirMensaje("Este pokemon ya esta en el equipo vuelva a intentar con otro nombre");
                                case EstadoEditarInformacionPokemon.NOMBRE_POKEMON_EDITADO ->
                                        consola.imprimirMensaje("Nombre de el Pokemon cambiado correctamente");
                            }
                        }
                        else if (atributoAModificar.equalsIgnoreCase("tipo")){
                            String nuevoTipo = consola.pedirTexto("Ingrese el nuevo tipo de el pokemon: ");
                            entrenador.editarTipoPokemon(pokemon, nuevoTipo);
                            consola.imprimirMensaje("Tipo cambiado correctamente");
                        }
                        else if (atributoAModificar.equalsIgnoreCase("nivel")){
                            int nuevoNivel = consola.pedirEntero("Ingrese el nuevo nivel de el pokemon: ");
                            entrenador.editarNivelPokemon(pokemon, nuevoNivel);
                            consola.imprimirMensaje("Nivel cambiado correctamente");
                        }
                        else {
                            consola.imprimirMensaje("Atributo no existente");
                        }
                    }
                    else {
                        consola.imprimirMensaje("Pokemon no existente en el equipo");
                    }
                }
            }
            else {
                consola.imprimirMensaje("Entrenador no existente");
            }
            deseaEditarInformacionPokemon = consola.pedirDecision("Desea modificar la informacion de otro pokemon? (s/n): ");
        }

    }

    private void guardarEntrenadores() throws IOException{
        archivo.guardarEntrenadores(gestor.getEntrenadores());
        consola.imprimirMensaje("Entrenadores guardados correctamente");
    }

    private void mostrarEstadoEntrenadores(){
        consola.imprimirMensaje(gestor.toString());
    }

}
