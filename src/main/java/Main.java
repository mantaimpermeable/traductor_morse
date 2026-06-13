package src.main.java;
import java.util.Scanner;
//Aqui se ejecutar el programa y poco mas
public class Main {
    public static void main(String[] args){

        Traductor traductor = new Traductor();
        System.out.println(Herramientas.instrucciones());
        Scanner scanner = new Scanner(System.in);
        traductor.empezar(scanner);
    }
}