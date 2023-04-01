package practiceCodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringProblem {
    public static void main(String[] args) {
        String ex1 = "DCBA";

        ex1 = ex1.toLowerCase();
        System.out.println("ex1 = " + ex1);
        String collect = Arrays.stream(ex1.split("")).sorted().collect(Collectors.joining());
        System.out.println("collect = " + collect);
        String [] temp = new String[10];


    }
}
