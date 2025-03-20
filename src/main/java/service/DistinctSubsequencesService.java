package main.java.service;


import main.java.core.DistinctSubsequencesSolver;

public class DistinctSubsequencesService implements DistinctSubsequencesSolver {
    private final DistinctSubsequencesSolver calculator;

    // Permite inyectar diferentes implementaciones si es necesario. Siguiente commit
    public DistinctSubsequencesService(DistinctSubsequencesSolver calculator) {
        this.calculator = calculator;
    }

    @Override
    public int numDistinct(String s, String t) {
        return calculator.numDistinct(s, t);
    }
}
