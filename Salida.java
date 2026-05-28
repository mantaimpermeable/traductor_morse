public class Salida {

    //Metodo que maneja un texto y lo devuelve en parrafo separando por / y
    // y lo devuelve encuadrado
    //En este metodo se han puesto bullet points y espacios adicionales pero no deberia de ser asi
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
        for(int i = 0; i < longitud + 2; i++){
            tope += "-";
        }
        StringBuilder formato = new StringBuilder();
        formato.append(String.format("%s \n|%s   |\n", tope, fillVoids(" ", longitud)));
        for(int i = 0; i < texto.length; i++){
            String frase = texto[i];
            formato.append(String.format("|  ·%s", fillVoids(frase, longitud)));
            
            formato.append("|\n");
        }
        formato.append(String.format("|%s   |\n%s", fillVoids(" ", longitud), tope));


        return formato.toString();
    }

    public String fillVoids(String texto, int end){
       
        int ocupacion = texto.length();
        while(ocupacion <= end){
            texto += " ";
            ocupacion++;
        }
        return texto;
    }
}
