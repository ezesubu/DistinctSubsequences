package test.java.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.core.DistinctSubsequences;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.service.DistinctSubsequencesService;


public class DistinctSubsequencesServiceTest {

    private DistinctSubsequencesService service;

    /**
     * Antes de cada prueba, inicializamos el servicio.
     * Idealmente, en pruebas más complejas podríamos usar Mockito para simular dependencias,
     * pero en este caso, dado que el servicio no depende de otros componentes externos,
     * opte por pruebas en Java puro.
     */
    @BeforeEach
    void setUp() {
        DistinctSubsequences calculator = new DistinctSubsequences();
        service = new DistinctSubsequencesService(calculator);
    }

    /**
     * Caso de prueba basado en el primer ejemplo del problema.
     */
    @Test
    void testExample1() {
        assertEquals(3, service.numDistinct("rabbbit", "rabbit"));
    }

    /**
     * Caso de prueba basado en el segundo ejemplo del problema.
     */
    @Test
    void testExample2() {
        assertEquals(5, service.numDistinct("babgbag", "bag"));
    }

    /**
     * Si t está vacío, siempre hay exactamente una forma de formarlo.
     */
    @Test
    void testEmptyT() {
        assertEquals(1, service.numDistinct("anything", ""));
    }

    /**
     * Si s está vacío pero t no lo está, no hay forma de formar t.
     */
    @Test
    void testEmptyS() {
        assertEquals(0, service.numDistinct("", "rabbit"));
    }

    /**
     * Si no hay coincidencias entre s y t, el resultado debe ser 0.
     */
    @Test
    void testNoMatch() {
        assertEquals(0, service.numDistinct("abc", "d"));
    }

    /**
     * Si s y t son exactamente iguales, solo hay una forma de formar t.
     */
    @Test
    void testSameStrings() {
        assertEquals(1, service.numDistinct("rabbit", "rabbit"));
    }

    /**
     * Se prueba un caso con repeticiones del mismo carácter en s.
     */
    @Test
    void testSingleCharacterMatch() {
        assertEquals(3, service.numDistinct("aaa", "a"));
    }
}
