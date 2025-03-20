package main.java;

import main.java.core.DistinctSubsequencesMatrix;
import main.java.service.DistinctSubsequencesService;

public class Main {
    public static void main(String[] args) {
        DistinctSubsequencesMatrix calculator = new DistinctSubsequencesMatrix();
        DistinctSubsequencesService service = new DistinctSubsequencesService(calculator);

        String s1 = "rabbbit", t1 = "rabbit";
        String s2 = "babgbag", t2 = "bag";
        String s3 = "ezequiel", t3 = "eze";

        System.out.println("Distinct Subsequences for (rabbbit, rabbit): " + service.numDistinct(s1, t1));
        System.out.println("Distinct Subsequences for (babgbag, bag): " + service.numDistinct(s2, t2));
        System.out.println("Distinct Subsequences for (ezequiel, eze): " + service.numDistinct(s3, t3));
    }
}
