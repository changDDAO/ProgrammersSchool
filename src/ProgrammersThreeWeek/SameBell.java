package ProgrammersThreeWeek;

import java.util.HashMap;
import java.util.Map;

public class SameBell {

    public int solution(int[] bell) {
        int answer = 0;
        //zeroSum 방식을 이용
        for (int i = 0; i < bell.length; i++) {
            if(bell[i]==2) bell[i]=-1;
        }
        //key : 누적합, value: index
        Map<Integer, Integer> zeroSumTable = new HashMap<>();
        int zeroSum = bell[0];
        zeroSumTable.put(0, -1);
        zeroSumTable.put(zeroSum,0);
        for (int i = 1; i < bell.length; i++) {
            zeroSum +=bell[i];
            if (!zeroSumTable.containsKey(zeroSum)) {
                zeroSumTable.put(zeroSum, i);// 현재 누적합이 처음 있는 경우라면 누적합과 index를 key value 쌍으로 저장
            } else {
                answer = Math.max(answer, i-zeroSumTable.get(zeroSum)); //아니라면 새로 생긴 누적합과 현재 i의 key가 0으로 수렴함을
                //의미함으로 최댓값 비교
            }
        }


        return answer;

    }

}
