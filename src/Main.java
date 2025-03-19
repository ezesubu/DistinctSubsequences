
public class Main {
    public static void main(String[] args) {
        DistictSubsequences ds = new DistictSubsequences();
        System.out.println(ds.numDistinct("rabbbit", "rabbit")); // Output: 3
        System.out.println(ds.numDistinct("babgbag", "bag"));    // Output: 5
        System.out.println(ds.numDistinct("ezequiel", "eze"));
    }
}
