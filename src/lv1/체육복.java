package lv1;

import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        //체육복을 잃어벼렸지만, 여분을 가지고 있는학생
        for(int i = 0; i<lost.length;i++){
            for(int j= 0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    answer++;
                    lost[i]=reserve[j]=-1; //전혀 관련없는 수로 초기화
                    break;
                }
            }
        }
        for(int lostPerson : lost){
            if(lostPerson==-1)continue;
            for(int i = 0;i<reserve.length;i++){

                if(lostPerson-1==reserve[i]||lostPerson+1==reserve[i]){
                    reserve[i]=-1;
                    answer++;
                    break;
                }

            }
        }
        return answer;
    }
}
