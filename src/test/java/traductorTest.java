
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class traductorTest {

    private Salida salida;
    private Traductor traductor;
    private Herramientas herramientas;
    

    @BeforeEach
    void inicializacion(){
        this.salida = new Salida();
        this.traductor = new Traductor();
        this.herramientas = new Herramientas();
    
    }

    //Tests de Herramientas
    @Test
    void testIsContained(){
        //test de metodo isContained que comprueba la existencia de las letras en el abecedario
        assertEquals("", herramientas.isContained("Esto es un texto valido"),"Retorna String vacio si todo esta en el abc");
    
    }

    @Test
    void testValidString(){
        //test de metodo validString que comprueba que un String sea valido
        assertFalse(herramientas.validString(null));
        assertFalse(herramientas.validString(""));
        assertTrue(herramientas.validString("Ejemplo"));
        assertTrue(herramientas.validString(" "));
    }


    //Test de traductor
    @Test
    void testTraductorAMorse(){
        assertEquals("", traductor.traductorAMorse(null));
        assertEquals("", traductor.traductorAMorse(""));
        assertEquals("-.-.", traductor.traductorAMorse("c"));
        assertEquals("/", traductor.traductorAMorse(" "));
        assertEquals(".- .-.. --. --- / .- .-.. --. ---",traductor.traductorAMorse("algo algo"));

    }

    @Test
    void testTraductorDemorse(){
        assertEquals("", traductor.traductorDeMorse(null));
        assertEquals("", traductor.traductorDeMorse(""));
        assertEquals("C", traductor.traductorDeMorse("-.-."));
        assertEquals("ALGO ALGO", traductor.traductorDeMorse(".- .-.. --. --- / .- .-.. --. ---"));
    
    }
   
}