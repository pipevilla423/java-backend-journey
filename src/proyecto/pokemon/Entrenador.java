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

    public void setEquipo(ArrayList<Pokemon> equipo) {
        this.equipo = equipo;
    }

    public void agregarPokemon(Pokemon pokemon){
        this.equipo.add(pokemon);
    }
    @Override
    public String toString(){
        return "Nombre del entrenador: "+ nombre+ "\nEquipo del entrenador: "+ equipo+"\nRegion del entrenador: "+region;
    }
}
