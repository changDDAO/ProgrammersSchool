package lv1;

import java.util.Arrays;

public class 문자열_내마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        String [] answer = Arrays.stream(strings)
                .sorted((a,b)->a.charAt(n)-b.charAt(n)).toArray(String[]::new);
        return answer;
    }
}
