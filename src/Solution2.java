import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
       String s = "changho";
        System.out.println(s.substring(0,1));
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        System.out.println(s);

    }
}
