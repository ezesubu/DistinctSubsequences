// Programación Dinámica con Matrix
//  O(n²)
// Ventajas:
//  - Fácil de entender y codificar.
// Desventaja:
//  -Usa O(n·m) espacio adicional por la matriz.

package main.java.core;

public class DistinctSubsequencesMatrix implements DistinctSubsequencesSolver {

    @Override
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        prev[0] = 1; // Si t es vacío, hay exactamente 1 forma de formarlo.

        for (int i = 1; i <= m; i++) {
            curr[0] = 1; // Siempre hay una forma de formar una cadena vacía.

            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }

            prev = curr.clone();
        }

        return prev[n];
    }
}
