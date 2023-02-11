import java.util.Arrays;

class ManageFac {
    public long solution(int goal, int[] durations) {
        long answer;
        int targetTime = findTime(goal, durations);
        int [] madeDollByPerson = Arrays.stream(durations).map(w->(targetTime/w)).toArray();
        int min = Arrays.stream(durations).map(w->(targetTime/w)).min().getAsInt();
        int sum = Arrays.stream(madeDollByPerson).filter(b->(b>min)).map(b->(b-min)).sum();
        answer = 10000*sum;
        return answer;
    }
    public int findTime(int goal, int[]durations) {
        int start = 1;
        int end = (int)1e6;
        int targetTime=0;
        while (start <= end) {
            int mid = (start+end)/2; //현재 시간
            //총 만들수 있는 인형 갯수
            int madeDolls = Arrays.stream(durations).map(d->mid/d).sum();
            if (madeDolls < goal) start = mid+1;

            else {end =mid -1;
                targetTime =mid;
            }
        }
        return targetTime;
    }
}