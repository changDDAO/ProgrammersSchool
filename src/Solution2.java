import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        String temp = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining());
        String answer = Arrays.stream(temp.split("")).sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining());
        System.out.println(answer);

        String s = "changho";
        String[] sArray = s.split("");
        String answer1 = Arrays.stream(sArray).sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining());
        System.out.println(answer1);


    }
}
