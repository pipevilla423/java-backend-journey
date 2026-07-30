package proyecto.pokemon;

import java.util.ArrayList;

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
        if(pokemonDuplicado(pokemon)){
            return EstadoAgregarPokemon.POKEMON_DUPLICADO;
        }
        this.equipo.add(pokemon);
        return EstadoAgregarPokemon.POKEMON_AGREGADO;
    }

    private boolean pokemonDuplicado(Pokemon pokemon){
        for(Pokemon p: equipo){
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
