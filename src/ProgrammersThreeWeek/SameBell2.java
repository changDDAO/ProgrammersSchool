package ProgrammersThreeWeek;

import java.util.HashMap;
import java.util.Map;

public class SameBell2 {
    public int solution(int[] bell) {
        int answer = 0;
        for (int i = 0; i < bell.length; i++) {
            if(bell[i]==2) bell[i]=-1;
        }//1과 2가 주어지므로 2를 -1로 다 replace하고 HashTable을 이용하여
        //key에는 누적합을 저장 value에는 index를 담는다.
        Map<Integer, Integer> accumulateSumTable = new HashMap<>();
        int aC = bell[0];
        accumulateSumTable.put(0,-1);
        accumulateSumTable.put(aC,0);
        for (int i = 1; i < bell.length; i++) {
            aC+=bell[i];//aC변수에 누적합을 저장
            if (!accumulateSumTable.containsKey(aC)) {
                accumulateSumTable.put(aC, i);
            } else {
                answer = Math.max(answer, i - accumulateSumTable.get(aC));
            }
        }
        return answer;
    }
}
