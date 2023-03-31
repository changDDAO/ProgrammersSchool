package practiceCodingTest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RockScissorsPaper {


    public static void main(String[] args) {
        //가위 2, 바위 0, 보 5
       String rsp = "205";
        String answer = Arrays.stream(rsp.split(""))
                .map(s -> s.equals("0") ? "5" : s.equals("2") ? "0" : "2")
                .collect(Collectors.joining());
        System.out.println(answer);

    }
}
