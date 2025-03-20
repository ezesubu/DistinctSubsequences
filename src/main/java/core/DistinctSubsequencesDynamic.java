// Programación Dinámica con Espacio Optimizado
// O(n·m) en tiempo y O(n) en espacio,
// Aquí reducimos la matriz a un solo array O(n) en lugar de O(n·m).
// Ventajas:
//  - Reduce el espacio de O(n·m) → O(n) sin perder eficiencia.
//  - Más rápido en ejecución.
// Desventajas:
//  - Más difícil de entender que la primera versión.

package main.java.core;

public class DistinctSubsequencesDynamic implements DistinctSubsequencesSolver {

    @Override
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Siempre hay una forma de formar una subsecuencia vacía

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) { // Recorremos de derecha a izquierda
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}
