import java.util.HashMap;
import java.util.Scanner;

public class Traductor {

    Herramientas herramientas = new Herramientas();
    private HashMap<Character, String> abecedario = herramientas.getAbecedario();
    private HashMap<String, Character> abecedarioInverso = herramientas.getAbecedarioInverso();
    
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
        return provisional.toString();
    }


    //Logica del traductor
    public void empezar (Scanner scanner){

        System.out.println("Bienvenido al traductor de codigo morse hecho a las 1:36 de un martes cualquiera");
        System.out.println("Puedes traducir palabras que contengan letras de la A a la Z, del 0 al 9 y algunos simbolos");
        System.out.println("Si algun caracter no esta dentro de nuestro abecedario se mostrara con un ? y posiblemente se añada en algun momento");
        System.out.println("Para salir del programa escribe : kirkexiting");

        //Utilizamos la variable texto para hacer las conversiones pero tambien segun su valor se sigue o no el bucle
        String texto = "";
        while(true){

            System.out.println("El texto que vas a introducir es M (morse) o C (corriente)?");
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
        
            if(morse)traduccion = traductorDeMorse(texto);
            else traduccion = traductorAMorse(texto);
             
            System.out.println("Texto original : " + texto);
            System.out.println("Texto en " + modo + " : " + traduccion);
            
        }
    }
        scanner.close();
        System.out.println("Saliendo del programa");
    }
}

