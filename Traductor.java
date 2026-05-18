import java.util.HashMap;

public class Traductor {
    //clase donde se ejecutara toda la logica de la traduccion
    public static boolean validString(String palabra){
        return (palabra != null && palabra != "");
    }
    private static HashMap<Character, String> diccionarioMorse = new HashMap<>();
    {
        //Introducimos dentro del hashmap todas las llaves
    diccionarioMorse.put('A', ".-");
        diccionarioMorse.put('B', "-...");
        diccionarioMorse.put('C', "-.-.");
        diccionarioMorse.put('D', "-..");
        diccionarioMorse.put('E', ".");
        diccionarioMorse.put('F', "..-.");
        diccionarioMorse.put('G', "--.");
        diccionarioMorse.put('H', "....");
        diccionarioMorse.put('I', "..");
        diccionarioMorse.put('J', ".---");
        diccionarioMorse.put('K', "-.-");
        diccionarioMorse.put('L', ".-..");
        diccionarioMorse.put('M', "--");
        diccionarioMorse.put('N', "-.");
        diccionarioMorse.put('O', "---");
        diccionarioMorse.put('P', ".--.");
        diccionarioMorse.put('Q', "--.-");
        diccionarioMorse.put('R', ".-.");
        diccionarioMorse.put('S', "...");
        diccionarioMorse.put('T', "-");
        diccionarioMorse.put('U', "..-");
        diccionarioMorse.put('V', "...-");
        diccionarioMorse.put('W', ".--");
        diccionarioMorse.put('X', "-..-");
        diccionarioMorse.put('Y', "-.--");
        diccionarioMorse.put('Z', "--..");
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
                if(diccionarioMorse.containsKey(letra)){
                    provisional.append(diccionarioMorse.get(letra));

                    //Agregamos despues de cada caracter un espacio para diferenciar cada letra
                    //para el final de cada palabra ya se agregara un espacio distinto(7 espacios segun morse pero demasiado)
                    if(i < mayuscula.length() - 1){
                        provisional.append("");
                    }
                }else{
                    //Si no esta dentro de nuestro abecedario vamos a añadir un signo de interrogacion
                    provisional.append("?");
                    if(i < mayuscula.length() - 1){
                        //Seguimos añadiendo un espacio para identificar que es una letra
                        provisional.append("");
                    }
                }


            }
            resultado = provisional.toString();
        }
        
        return resultado;
    }
}
