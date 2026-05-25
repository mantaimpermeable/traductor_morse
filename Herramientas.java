import java.util.HashMap;

public class Herramientas{

    //Atributos de nuestra clase herramientas
    private HashMap<Character, String> abecedario = new HashMap<>();
    private HashMap<String, Character> abecedarioInverso = new HashMap<>();

    //Constructor de la clase, solo incializa los hashMap 
    public Herramientas(){

        inicializar(this.abecedario);
        inicializarInverso(abecedarioInverso);
    }

    
    //Inicializador del abecedario, privado porque el abecedario siempre es el mismo
    private HashMap<Character, String> inicializar (HashMap<Character, String> abecedario){
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
        return abecedario;
    }

    //Inicializador del abecedarioInverso, privado porque no se debe de acceder a el
    private HashMap<String, Character> inicializarInverso (HashMap<String, Character> inverso){
        for(HashMap.Entry<Character, String> llave : abecedario.entrySet()){
        abecedarioInverso.put(llave.getValue(), llave.getKey());
        }
        return inverso;
    }


//Metodo para comprobar si un String es valido o no
    public boolean validString(String texto){
        return (texto != null && texto != "");
    }

    //GETTERS
    
    public HashMap<Character, String> getAbecedario(){
        return this.abecedario;
    }

    public HashMap<String, Character> getAbecedarioInverso(){
        return this.abecedarioInverso;
    }


}