public class Salida {

    //Metodo que maneja un texto y lo devuelve en parrafo separando por / y
    // y lo devuelve encuadrado
    public String encuadrar (String mensaje){

        int longitud = 0;
        String[] texto = mensaje.split("/");
        
        String tope = "----";
        //Recorremos el array de lineas para encontrar cual tiene mayor longitud y
        //modificamos nuestro parametro de longitud
        for(int i = 0; i < texto.length; i++){
            int local = texto[i].length();
            if(local > longitud){
                longitud = local;
            }
        }

        //Modificamos el top para que tenga tantos guiones como la longitud que queremos
        //mas dos guionesnpara que no se choquen
        for(int i = 0; i < longitud; i++){
            tope += "-";
        }
        StringBuilder formato = new StringBuilder();
        formato.append(tope+"\n\n");
        for(int i = 0; i < texto.length; i++){
            String frase = texto[i];
            int ocupacion = frase.length();
            formato.append(String.format("| %s", frase));
            while(ocupacion <= longitud){
                formato.append(" ");
                ocupacion++;
            }
            formato.append("|\n");
        }
        formato.append("\n" + tope);


        return formato.toString();
    }
}
