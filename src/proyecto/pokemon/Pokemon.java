package proyecto.pokemon;

public class Pokemon {

    private String tipo;
    private int nivel;
    private String nombre;

    public Pokemon(String tipo, int nivel, String nombre){
        this.tipo = tipo;
        this.nivel = nivel;
        this.nombre = nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getNivel(){
        return this.nivel;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString() {
        return "\n" + nombre + "\nNivel = "+ nivel+"\nTipo = "+tipo;
    }
}
