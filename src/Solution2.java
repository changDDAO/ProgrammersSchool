import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
       String s = "changho";
        System.out.println(s.substring(0,1));
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();

        String [] temp = s.split("");
        for (int i = 0; i < temp.length; i+=3) {
            for (int j = i; j < j + 3; j++) {
                if(j== temp.length-1)return;
                System.out.print(temp[j]);
            }
            System.out.println();
        }

    }
}
