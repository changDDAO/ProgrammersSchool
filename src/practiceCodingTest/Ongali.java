package practiceCodingTest;

import java.util.Arrays;

public class Ongali {
    public static void main(String[] args) {
        int [] numbers ={1,3,5,5};
        int n = 5;
        double avg = Arrays.stream(numbers).average().orElse(0);
        int answer = (int)Arrays.stream(numbers).filter(e -> e == 5).count();
        System.out.println(answer);

    }

}
