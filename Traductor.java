import java.util.HashMap;
import java.util.Scanner;

public class Traductor {
    //clase donde se ejecutara toda la logica de la traduccion
    public static boolean validString(String texto){
        return (texto != null && texto != "");
    }
    private static HashMap<Character, String> abecedario = new HashMap<>();
    {
        //Introducimos dentro del hashmap todas las llaves
    abecedario.put('A', ".-");
        abecedario.put('B', "-...");
        abecedario.put('C', "-.-.");
        abecedario.put('D', "-..");
        abecedario.put('E', ".");
        abecedario.put('F', "..-.");
        abecedario.put('G', "--.");
        abecedario.put('H', "....");
        abecedario.put('I', "..");
        abecedario.put('J', ".---");
        abecedario.put('K', "-.-");
        abecedario.put('L', ".-..");
        abecedario.put('M', "--");
        abecedario.put('N', "-.");
        abecedario.put('O', "---");
        abecedario.put('P', ".--.");
        abecedario.put('Q', "--.-");
        abecedario.put('R', ".-.");
        abecedario.put('S', "...");
        abecedario.put('T', "-");
        abecedario.put('U', "..-");
        abecedario.put('V', "...-");
        abecedario.put('W', ".--");
        abecedario.put('X', "-..-");
        abecedario.put('Y', "-.--");
        abecedario.put('Z', "--..");

        abecedario.put('0', "-----");
        abecedario.put('1', ".----");
        abecedario.put('2', "..---");
        abecedario.put('3', "...--");
        abecedario.put('4', "....-");
        abecedario.put('5', ".....");
        abecedario.put('6', "-....");
        abecedario.put('7', "--...");
        abecedario.put('8', "---..");
        abecedario.put('9', "----.");

        abecedario.put(' ', "/");  // Espacio entre palabras
        abecedario.put('.', ".-.-.-");
        abecedario.put(',', "--..--");
        abecedario.put('?', "..--..");
        abecedario.put('!', "-.-.--");
        abecedario.put(';', "-.-.-.");
        abecedario.put(':', "---...");
        abecedario.put('"', ".-..-.");
        abecedario.put('\'', ".----.");
        abecedario.put('(', "-.--.");
        abecedario.put(')', "-.--.-");
        abecedario.put('&', ".-...");
        abecedario.put('@', ".--.-.");
        abecedario.put('=', "-...-");
        abecedario.put('+', ".-.-.");
        abecedario.put('-', "-....-");
        abecedario.put('_', "..--.-");
        abecedario.put('/', "-..-.");
    }
    public static String traductor(String texto){
        String resultado = "";
        //Si la texto no es valida no se ejecuta y se devuelve un string vacio
        if(validString(texto)){
            StringBuilder provisional = new StringBuilder();
            //Pasamos la texto a mayuscula porque asi tenemos las llaves en el hashmap
            String mayuscula = texto.toUpperCase();
            //Recorremos la texto y vamos traduciendo por caracter
            for(int i = 0; i < mayuscula.length(); i++){
                //sacamos cada letra por posicion en el string
                char letra = mayuscula.charAt(i);
                //Si nuestro abecedario contiene la letra, que es una llave del hashmap entonces hacemos
                //append del contenido de la llave que es el equivalente en morse
                if(abecedario.containsKey(letra)){
                    provisional.append(abecedario.get(letra));

                    //Agregamos despues de cada caracter un espacio para diferenciar cada letra
                    //para el final de cada texto ya se agregara un espacio distinto(7 espacios segun morse pero demasiado)
                    if(i < mayuscula.length() - 1){
                        provisional.append(" ");
                    }
                }else{
                    //Si no esta dentro de nuestro abecedario vamos a añadir un signo de interrogacion
                    provisional.append("?");
                    if(i < mayuscula.length() - 1){
                        //Seguimos añadiendo un espacio para identificar que es una letra
                        provisional.append(" ");
                    }
                }


            }
            resultado = provisional.toString();
        }
        
        return resultado;
    }


    //Logica del traductor
    public static void empezar (Scanner scanner){
        //uso booleano para controlar el while por costumbre de clase
        boolean jugar = true;

        System.out.println("Bienvenido al traductor de codigo morse hecho a las 1:36 de un martes cualquiera");
        System.out.println("Puedes traducir palabras que contengan letras de la A a la Z, del 0 al 9 y algunos simbolos");
        System.out.println("Si algun caracter no esta dentro de nuestro abecedario se mostrara con un ? y posiblemente se añada en algun momento");
        System.out.println("Para salir del programa escribe : kirkexiting");

        while(jugar){
            System.out.println("Comienza a meter texto para traducir:");
            String texto = scanner.nextLine();

            //Si se introduce el texto de salida se da un mensaje y se rompe el bucle terminando el programa
            if(texto.equalsIgnoreCase("kirkexiting")){
                System.out.println("Saliendo del programa");
                jugar = false;
            }

            //Si la entrada de texto esta vacia repetimos el programa y pedimos texto
            if(texto.trim().isEmpty()){
                System.out.println("No me ralles e introduce texto");
                //creo que primera vez que uso continuo
                continue;
            }

            //Damos el texto original y la traduccion en morse
            String morse = traductor(texto);
            System.out.println("Texto original: " + texto);
            System.out.println("Texto en morse: " + morse);
        }
        scanner.close();
    }
}

