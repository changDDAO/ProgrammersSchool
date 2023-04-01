package practiceCodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringProblem {
    public static void main(String[] args) {
        String ex1 = "DCBA";

        ex1 = ex1.toLowerCase();
        System.out.println("ex1 = " + ex1);
        String collect = Arrays.stream(ex1.split("")).sorted().collect(Collectors.joining());
        System.out.println("collect = " + collect);
        String [] temp = new String[10];

        int [] numbers = {1,2,3,4,5};
        numbers = Arrays.stream(numbers).map(v->v*2).toArray();
        int asInt = IntStream.rangeClosed(0, 5).min().getAsInt();
        System.out.println("asInt = " + asInt);
        Character a = '4';


        char a1 = 'A';
        char a2 = 'a';
        System.out.println((int)a1);




    }
}
