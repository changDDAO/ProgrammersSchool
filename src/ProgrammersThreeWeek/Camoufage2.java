package ProgrammersThreeWeek;

import java.util.HashMap;
import java.util.Map;

public class Camoufage2 {
    public int solution(String[][] clothes) {
        int answer = 1;
        //현재 옷의 종류만 가지고 와서 count 해주고 경우의 수를 비교하면된다
        Map<String, Integer> countByCase = new HashMap<>();
        for (String[] clothCase : clothes) {
            countByCase.put(clothCase[1],countByCase.getOrDefault(clothCase[1],0)+1);
        }
        for(int i: countByCase.values())answer*=(i+1);
        return answer-1;
    }

}
