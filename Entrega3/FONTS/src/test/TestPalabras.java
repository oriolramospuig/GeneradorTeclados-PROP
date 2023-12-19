package test;

import main.domain.classes.Palabras;

import org.junit.*;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestPalabras
{
    private Palabras palabras;

    @Before
    public void setUp() {
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ai", 4);
        frecuenciaLetras.put("ac", 2);
        palabras = new Palabras("nombreP", "aiacaia", frecuenciaLetras);
    }

    // ---------- CONSTRUCTORAS ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestConstructora` tiene como objetivo verificar el correcto funcionamiento
     * del constructor de la clase `Palabras`. Este constructor debería inicializar correctamente
     * los atributos de la instancia.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de la lógica interna del constructor de la clase `Palabras`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `Palabras`.
     * 2. Se verifica que el nombre de la instancia sea el esperado.
     * 3. Se verifica que el texto de la instancia sea el esperado.
     * 4. Se verifica que la frecuencia de letras esté vacía.
     * 5. Se verifica que las asociaciones vinculadas estén vacías.
     *
     * Operativa:
     * 1. Se crea una instancia de `Palabras`.
     * 2. Se verifican los atributos de la instancia.
     */
    public void TestConstructora () {
        System.out.println("Test Constructora");

        assertEquals("nombreP", palabras.getNombre());
        assertEquals("aiacaia", palabras.getTexto());
        assertTrue(palabras.getTexto().isEmpty());
        assertTrue(palabras.getFrecuenciaLetras().isEmpty());
        assertTrue(palabras.getAsociacionesVinculadas().isEmpty());
    }

}