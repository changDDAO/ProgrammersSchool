package ProgrammersThreeWeek;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 0;
        //현재 종류의 갯수를 count 하여 있어도 되고 없어도 되는경우가 있으므로 +1
        //각 종류를 곱한뒤 모두없는경우 1을 빼주면된다. 문제조건에서 어떤의상이라도 하나는 입고있어야 하므로
        //종류의 갯수만 count 하면되므로
        Map<String, Integer> countsByCase = new HashMap<>();
        for (String[] c : clothes) {
            countsByCase.put(c[1], countsByCase.getOrDefault(c[1],0)+1);
        }
        answer =1;
        for (int v : countsByCase.values()) {
            answer*=(v+1);
        }


        return answer-1;
    }
}
