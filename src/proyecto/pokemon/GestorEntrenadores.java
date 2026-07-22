package proyecto.pokemon;

import java.util.ArrayList;

public class GestorEntrenadores {

    private ArrayList<Entrenador> entrenadores;

    public GestorEntrenadores(){
        this.entrenadores = new ArrayList<>();
    }

    public void addEntrenador(Entrenador entrenador){
        this.entrenadores.add(entrenador);
    }

    public void registrarEntrenador(String nombre, String region){
        Entrenador entrenador = new Entrenador(nombre, region);
        addEntrenador(entrenador);
    }

    public Entrenador buscarEntrenador(String nombreEntrenador){
        for(Entrenador entrenador : entrenadores){
            if(entrenador.getNombre().equalsIgnoreCase(nombreEntrenador)) {
                return entrenador;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "Informacion de los entrenadores: " + entrenadores;
    }
}
