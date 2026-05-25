import java.util.Scanner;
//Aqui se ejecutar el programa y poco mas
public class Main {
    public static void main(String[] args){

        Traductor traductor = new Traductor();
        Scanner scanner = new Scanner(System.in);
        traductor.empezar(scanner);
    }
}