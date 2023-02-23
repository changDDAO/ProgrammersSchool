package answer3;
import java.util.HashMap;
import java.util.Map;

class Bell {
    public int solution(int[] bell) {
        for(int i=0; i<bell.length; i++) {
            // 절대값 측정을 위해 -1로 값 변경
            if(bell[i] == 2) {
                bell[i] = -1;
            }
        }

        int total = bell[0]; // 첫번째 방울의 값
        int answer = 0;

        // <방울의 값들의 합, 현재 누적합이 처음으로 나온 인덱스>
        Map<Integer, Integer> dict = new HashMap<>();
        dict.put(0, -1);
        dict.put(total, 0);

        for(int i=1; i<bell.length; i++) {
            total += bell[i];
            if(!dict.containsKey(total)) {
                // 누적합이 처음 나온 경우, 인덱스를 저장
                dict.put(total, i);
            } else {
                // 처음 방문한 지점의 인덱스부터 현재 인덱스까지 짝이 맞아있음을 의미
                answer = Math.max(answer, i - dict.get(total));
            }
        }

        return answer;
    }
}