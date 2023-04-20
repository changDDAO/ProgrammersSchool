package lv1;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int curWall = 0;

        for(int i=0;i<section.length;i++){
            if(curWall<=section[i]){
                answer++;
                curWall=section[i]+m;
            }


        }
        return answer;
    }
}
