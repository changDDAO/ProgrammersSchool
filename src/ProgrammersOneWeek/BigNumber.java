package ProgrammersOneWeek;

import java.util.*;
import java.util.stream.*;
class BigNumber {
    public String solution(int[] numbers) {
        //String 배열로 변경하여 내림차순 정렬을 시킨다.
        //int [] numbers = [6, 10, 2]
        //int로 비교할 시 ex) 6210 이 원하는 가장 큰 수이지만 10 6 2가 될수 있기때문에 String으로 비교해야한다.
        String answer = Arrays.stream(numbers).mapToObj(String::valueOf)
                .sorted((a,b)->(b+a).compareTo(a+b))
                .collect(Collectors.joining());
        if(answer.startsWith("0")) return "0";

        return answer;
    }
}