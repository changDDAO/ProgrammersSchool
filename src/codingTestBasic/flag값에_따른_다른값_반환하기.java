package codingTestBasic;

public class flag값에_따른_다른값_반환하기 {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;
        if(flag) answer = a+b;
        else answer = a-b;
        return answer;
    }
}
