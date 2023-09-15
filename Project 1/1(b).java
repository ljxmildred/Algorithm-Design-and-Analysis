import java.util.*;

public class GenerateInput {
    static final int MIN = 1;
    public static void main(String[] args) {
        int minSize = 1000;
        int maxSize = 10000000;

        for (int size = minSize; size <= maxSize; size *= 10) {
            int[] testArr = generateRandom(size, 100);
            System.out.println("Generated array of size " + size);
        }
    }

    public static int[] generateRandom(int size, int max) {
        return new Random().ints(size, MIN, max + 1).toArray();
    }
}
