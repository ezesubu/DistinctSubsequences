// Optimización con Memoization
// O(n)
// Se usa HashMap para evitar cálculos repetidos.
// Ventajas:
//  -Evita cálculos repetitivos con memoization.
//  -Reduce drásticamente el número de operaciones.
// Desventajas:
//  -Puede ser más costoso en memoria que la optimización con dp[].

package main.java.core;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequencesMemoization implements DistinctSubsequencesSolver {
    private Map<String, Integer> memo = new HashMap<>();

    @Override
    public int numDistinct(String s, String t) {
            return dfs(s, t, 0, 0);
        }

    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        int count = dfs(s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j)) {
            count += dfs(s, t, i + 1, j + 1);
        }

        memo.put(key, count);
        return count;
    }
}


