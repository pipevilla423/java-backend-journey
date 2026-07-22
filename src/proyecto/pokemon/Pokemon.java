package proyecto.pokemon;

public class Pokemon {

    private String tipo;
    private int nivel;
    private String nombre;

    public Pokemon(String nombre, String tipo,  int nivel){
        this.tipo = tipo;
        this.nombre = nombre;
        this.nivel = nivel;
    }
    public String getNombre(){
        return this.nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getNivel(){
        return this.nivel;
    }

    @Override
    public String toString() {
        return  "\n"+nombre + ", Tipo = "+tipo+", Nivel = "+ nivel;
    }
}
