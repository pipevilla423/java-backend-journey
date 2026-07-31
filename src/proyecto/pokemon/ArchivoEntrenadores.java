package proyecto.pokemon;

import java.io.*;
import java.util.ArrayList;

public class ArchivoEntrenadores {
    private final String rutaArchivo;

    public ArchivoEntrenadores(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public ArrayList<Entrenador> cargarEntrenadores() throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
        ArrayList<Entrenador> entrenadoresCargados = new ArrayList<>();
        String linea;

        while((linea = lector.readLine()) != null){
            String[] datosEntrenador = linea.split(";");

            String nombre = datosEntrenador[0];
            String region = datosEntrenador[1];
            Entrenador entrenador = new Entrenador(nombre, region);

            for (int i =2; i<datosEntrenador.length; i++) {
                Pokemon pokemon = convertirTextoAPokemon(datosEntrenador[i]);
                entrenador.agregarPokemon(pokemon);
            }
            entrenadoresCargados.add(entrenador);
        }

        lector.close();
        return entrenadoresCargados;
    }

    public void guardarEntrenadores(ArrayList<Entrenador> entrenadores) throws IOException{
        BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
        for(Entrenador entrenador: entrenadores){
            String datosEntrenador = entrenador.getNombre() + ";"  + entrenador.getRegion();
            escritor.write(datosEntrenador);
            for(Pokemon pokemon: entrenador.getEquipo()){
                escritor.write(";"+convertirPokemonATexto(pokemon));
            }
            escritor.newLine();
        }
        escritor.close();
    }

    private String convertirPokemonATexto(Pokemon pokemon){
        return pokemon.getNombre() + "," + pokemon.getTipo() + "," + pokemon.getNivel();
    }

    private Pokemon convertirTextoAPokemon(String textoPokemon){
        String[] datosPokemon = textoPokemon.split(",");
        String nombrePokemon = datosPokemon[0];
        String tipoPokemon = datosPokemon[1];
        String nivel = datosPokemon[2];
        return new Pokemon(nombrePokemon, tipoPokemon, Integer.parseInt(nivel));
    }
}
