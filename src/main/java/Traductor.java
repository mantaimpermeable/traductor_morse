package src.main.java;
import java.util.HashMap;
import java.util.Scanner;

public class Traductor {

    Herramientas herramientas = new Herramientas();

    //Abecedario con los que trabajamos
    private HashMap<Character, String> abecedario = herramientas.getAbecedario();
    private HashMap<String, Character> abecedarioInverso = herramientas.getAbecedarioInverso();

    //Traductor de texto normal a codigo morse utilizando nuestro abecedario
    public String traductorAMorse(String texto){
        String resultado = "";
        //Si la texto no es valida no se ejecuta y se devuelve un string vacio
        if(herramientas.validString(texto)){
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

    //Traductor de codigo morse a tetxo normal utilizando un abecedario inverso
    private  String traductorDeMorse(String texto){
        StringBuilder provisional = new StringBuilder();
        if(herramientas.validString(texto)){
            
            //Separamos el texto en palabras
            String[] palabras = texto.split("/");

            //iteramos por cada palabra que tenga el texto
          for(int i = 0; i < palabras.length; i++){
            //Creamos variable que representa cada palabra del texto
            String palabra = palabras[i].trim();
            //Comprobamos que la palabra sea valida
            if(herramientas.validString(palabra)){
                //Metemos todas las letras de la palabra en un array
                String[] letras = palabra.split(" ");
                //usamos un for each para cada elemento de letras
                for(String letra : letras){
                    //Si la letra esta en nuestro abecedario inverso entonces se añade
                    if(abecedarioInverso.containsKey(letra)){
                        provisional.append(abecedarioInverso.get(letra));
                    }else{
                        provisional.append("?");
                    }
                }
                
            }
            //Despues de cada palabra añadimos un espacio a no ser que sea la ultima
            if(i < palabras.length - 1){
                provisional.append(" ");
            }

           }
        }
        //Hay que pasar el metodo a tipo String porque estabamos trabajado con un objeto StringBuilder
        return provisional.toString();
    }


    //Logica del ejecucion del programa  que puede que moidfique en futuro
    public void empezar (Scanner scanner){

        //Utilizamos la variable texto para hacer las conversiones pero tambien segun su valor se sigue o no el bucle
        String texto = "";
        while(true){

            System.out.println("\nEl texto que vas a introducir es M (morse) o C (corriente)?");
            String eleccion = scanner.nextLine();

            if(eleccion.isEmpty() || (!(eleccion.equalsIgnoreCase("c")) && !(eleccion.equalsIgnoreCase("m")))){
                System.out.println("No es tan dificil va, una de las dos opcinoes");
                //usamos el continue para volver al principio del bucle
                continue;
            }
            //Si utilizo un else la variable no funciona para futura comprbacion, pero no es necesario porque si no tiene los valores que queremos
            //se ejecutara un continue y no se llegara a la parte del programa
                //Primera vez que uso el operador ternario
                boolean morse = eleccion.equalsIgnoreCase("M");
                String modo = (morse) ? "morse" : "corriente";
            
            System.out.print("Comienza a meter texto para traducir:");
             texto = scanner.nextLine();

             if(texto.equalsIgnoreCase("kirkexiting")){
                break;
             }
            
            //Si la entrada de texto esta vacia repetimos el programa y pedimos texto
            if(texto.trim().isEmpty()){
                System.out.println("No me ralles e introduce texto");
                //creo que primera vez que uso continuo
                continue;
            }
            else{
            //Damos el texto original y la traduccion en morse
            String traduccion;
    
            //Si se ha elegido la opcion morse se hace una traduccion del texto en morse y si no la otra
            if(morse){
                traduccion = traductorDeMorse(texto);
                
            }
            else {
                traduccion = traductorAMorse(texto);
                String error = herramientas.isContained(texto);
                if(!error.isEmpty()){
                    System.out.printf("\nLos siguientes caracteres no se encuentran en nuestro abecedario: %s\nson reemplazados por un ?\n\n", error);
                }
            }
             
            //sout del resultado de la ejecucion
            System.out.println("Texto original : " + texto);
            System.out.println("Texto en " + modo + " : " + traduccion);
            
        }
    }
        //Cerramos el scanner y mandamos mensaje indicando que se sale del programa
        scanner.close();
        System.out.println("Saliendo del programa");
    }
}

