import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit")); // Output: 3
        System.out.println(numDistinct("babgbag", "bag"));    // Output: 5
    }

    static public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Si t está vacío, hay exactamente 1 forma de formarlo
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Llenamos la matriz DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
