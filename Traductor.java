import java.util.HashMap;

public class Traductor {
    //clase donde se ejecutara toda la logica de la traduccion
    public static boolean validString(String palabra){
        return (palabra != null && palabra != "");
    }
    private static HashMap<Character, String> diccionarioMorse = new HashMap<>();
    {
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
}
