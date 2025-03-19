import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DistictSubsequencesTest {

    @Test
    void testNumDistinct() {
        DistictSubsequences solver = new DistictSubsequences();

        // Caso 1: "rabbbit" -> "rabbit", resultado esperado: 3
        assertEquals(3, solver.numDistinct("rabbbit", "rabbit"));

        // Caso 2: "babgbag" -> "bag", resultado esperado: 5
        assertEquals(5, solver.numDistinct("babgbag", "bag"));

        // Caso 3: "ezequiel" -> "eze", resultado esperado: 2
        assertEquals(2, solver.numDistinct("ezequiel", "eze"));

        // Caso 4: "abcd" -> "d", resultado esperado: 1
        assertEquals(1, solver.numDistinct("abcd", "d"));

        // Caso 5: "abcd" -> "e" (no se puede formar), resultado esperado: 0
        assertEquals(0, solver.numDistinct("abcd", "e"));

        // Caso 6: "aaa" -> "a", resultado esperado: 3 (cada 'a' es una subsecuencia válida)
        assertEquals(3, solver.numDistinct("aaa", "a"));

        // Caso 7: "abcdef" -> "f", resultado esperado: 1
        assertEquals(1, solver.numDistinct("abcdef", "f"));
    }
}
