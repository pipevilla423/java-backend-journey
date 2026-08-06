package proyecto.pokemon;

import java.util.ArrayList;
import java.util.Iterator;

public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> equipo;
    private String region;

    public Entrenador(String nombre, String region){
        this.nombre = nombre;
        this.region = region;
        this.equipo = new ArrayList<>();
    }

    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<Pokemon> getEquipo(){
        return this.equipo;
    }

    public String getRegion(){
        return this.region;
    }

    public EstadoAgregarPokemon agregarPokemon(Pokemon pokemon){
        if(equipo.size() == 6){
            return EstadoAgregarPokemon.EQUIPO_LLENO;
        }
        if(nombrePokemonDuplicado(pokemon)){
            return EstadoAgregarPokemon.POKEMON_DUPLICADO;
        }
        this.equipo.add(pokemon);
        return EstadoAgregarPokemon.POKEMON_AGREGADO;
    }

    public EstadoEliminarPokemon eliminarPokemon(String nombre){
        if (equipo.isEmpty()){
            return EstadoEliminarPokemon.EQUIPO_VACIO;
        }
        Iterator<Pokemon> iterador = equipo.iterator();

        while(iterador.hasNext()){
            Pokemon pokemon = iterador.next();
            if(pokemon.getNombre().equalsIgnoreCase(nombre)){
                iterador.remove();
                return EstadoEliminarPokemon.POKEMON_ELIMINADO;
            }
        }
        return EstadoEliminarPokemon.POKEMON_NO_EXISTENTE;
    }

    public Pokemon buscarPokemonPorNombre(String nombrePokemon){
        for (Pokemon pokemon: equipo){
            if (pokemon.getNombre().equalsIgnoreCase(nombrePokemon)){
                return pokemon;
            }
        }
        return null;
    }

    public EstadoEditarInformacionPokemon editarNombrePokemon(Pokemon pokemon, String nuevoNombre){
        if(buscarPokemonPorNombre(nuevoNombre)!=null){
            return EstadoEditarInformacionPokemon.POKEMON_DUPLICADO;
        }
        pokemon.cambiarNombre(nuevoNombre);
        return EstadoEditarInformacionPokemon.NOMBRE_POKEMON_EDITADO;
    }

    public void editarTipoPokemon(Pokemon pokemon, String nuevoTipo){
        pokemon.cambiarTipo(nuevoTipo);
    }

    public void editarNivelPokemon(Pokemon pokemon, int nuevoNivel){
        pokemon.cambiarNivel(nuevoNivel);
    }

    public boolean equipoVacio(){
        return equipo.isEmpty();
    }

    public ArrayList<Pokemon> obtenerEquipo(){
        return new ArrayList<>(equipo);
    }

    private boolean nombrePokemonDuplicado(Pokemon pokemon){
        for(Pokemon p: this.equipo){
            if(pokemon.getNombre().equalsIgnoreCase(p.getNombre())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Nombre del entrenador: "+ nombre+ "\nRegion del entrenador: "+region+"\nEquipo del entrenador: "+ equipo;
    }
}
