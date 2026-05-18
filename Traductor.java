import java.util.HashMap;

public class Traductor {
    //clase donde se ejecutara toda la logica de la traduccion
    public static boolean validString(String palabra){
        return (palabra != null && palabra != "");
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
    public static String traductor(String palabra){
        String resultado = "";
        //Si la palabra no es valida no se ejecuta y se devuelve un string vacio
        if(validString(palabra)){
            StringBuilder provisional = new StringBuilder();
            //Pasamos la palabra a mayuscula porque asi tenemos las llaves en el hashmap
            String mayuscula = palabra.toUpperCase();
            //Recorremos la palabra y vamos traduciendo por caracter
            for(int i = 0; i < mayuscula.length(); i++){
                //sacamos cada letra por posicion en el string
                char letra = mayuscula.charAt(i);
                //Si nuestro abecedario contiene la letra, que es una llave del hashmap entonces hacemos
                //append del contenido de la llave que es el equivalente en morse
                if(abecedario.containsKey(letra)){
                    provisional.append(abecedario.get(letra));

                    //Agregamos despues de cada caracter un espacio para diferenciar cada letra
                    //para el final de cada palabra ya se agregara un espacio distinto(7 espacios segun morse pero demasiado)
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
}
