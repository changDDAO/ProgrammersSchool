package practiceCodingTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class divideProblem {
    public static void main(String[] args) {
        //simpleTest
        int [] array = {1,3,5};
        int n = 10;
        int sum = Arrays.stream(array).sum();
        System.out.println(sum);
        int sum1 = IntStream.rangeClosed(2, n).filter(v -> v % 2 == 0)
                .sum();
        System.out.println(sum1);

    }
}
