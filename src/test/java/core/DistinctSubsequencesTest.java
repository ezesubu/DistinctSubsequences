package test.java.core;

import main.java.core.DistinctSubsequences;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistinctSubsequencesTest {

    @Test
    void testExample1() {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        assertEquals(3, ds.numDistinct(s, t));
    }

    @Test
    void testExample2() {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "babgbag";
        String t = "bag";
        assertEquals(5, ds.numDistinct(s, t));
    }

    @Test
    void testEzequiel() {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "ezequiel";
        String t = "eze";
        assertEquals(2, ds.numDistinct(s, t));
    }
    @Test
    void testNoMatch() {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "abc";
        String t = "xyz";
        assertEquals(0, ds.numDistinct(s, t));
    }

    @Test
    void testEmptyTarget() {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "anything";
        String t = "";
        assertEquals(1, ds.numDistinct(s, t)); // Solo 1 forma: eliminar anything
    }

    @Test
    void testSameStrings() {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "abc";
        String t = "abc";
        assertEquals(1, ds.numDistinct(s, t)); // Solo hay 1 forma posible
    }

    @Test
    void testSingleCharacterMultipleOccurrences() {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "aaaaa";
        String t = "aa";
        assertEquals(10, ds.numDistinct(s, t)); // Combinaciones de "aa" en "aaaaa"
    }
}
