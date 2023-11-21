package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.Palabras;

import java.util.ArrayList;

import main.domain.classes.Frecuencias;
import main.domain.classes.Texto;
import main.domain.classes.functions.InOut;
import main.domain.classes.types.PairFrequency;
import org.junit.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import java.lang.IndexOutOfBoundsException;
import java.lang.NegativeArraySizeException;

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