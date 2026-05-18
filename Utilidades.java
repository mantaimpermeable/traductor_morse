
//Clase donde se encuentran metodos para el manejo de strings
public class Utilidades {
    
    public static String conversor(String palabra, Abecedario abecedario){
       
        if(validString(palabra)){
            for(int i = 0; i < palabra.length(); i++){
             char letra = palabra.charAt(i);
             

            }
        }
        return "";
    }
    public static boolean validString(String palabra){
        return (palabra != null && palabra != "");
    }
    
}
