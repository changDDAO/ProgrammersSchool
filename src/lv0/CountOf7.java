package lv0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountOf7 {
    public int solution(int[] array) {
        int answer =0;
        String s = Arrays.stream(array).mapToObj(String::valueOf)
                .collect(Collectors.joining());
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='7') answer ++;
        }
        return answer;
    }
}
