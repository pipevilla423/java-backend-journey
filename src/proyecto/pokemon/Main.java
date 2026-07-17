package proyecto.pokemon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorEntrenadores gestor = new GestorEntrenadores();
        String decision = "s";

        while(decision.equals("s")){
            System.out.println("Ingrese nombre del Entrenador = ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese region del entrenador = ");
            String region = scanner.nextLine();

            gestor.registrarEntrenador(nombre, region);

            System.out.println("Desea registrar otro entrenador(s/n) = ");
            decision = scanner.nextLine();

        }


        System.out.println(gestor);





    }
}
