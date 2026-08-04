package proyecto.pokemon;

import java.util.Scanner;

public class AdministradorTexto {

    private final Scanner consola;

    public AdministradorTexto(){
        this.consola = new Scanner(System.in);
    }

    public String pedirTexto(String mensaje){
        System.out.println(mensaje);
        return consola.nextLine();
    }

    public int pedirEntero(String mensaje){
        System.out.println(mensaje);
        int numero = consola.nextInt();
        consola.nextLine();
        return numero;
    }

    public boolean pedirDecision(String mensaje){
        System.out.println(mensaje);
        String decision = consola.nextLine();
        return decision.equalsIgnoreCase("s");
    }

    public void imprimirMensaje(String mensaje){
        System.out.println(mensaje);
    }

}
