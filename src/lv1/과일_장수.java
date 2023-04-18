package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 과일_장수 {
    public int solution(int k, int m, int[] score) {
        //k는 최대 점수 m는 한상자에 담기는 사과의 갯수 score[]는 사과들의 점수
        int answer = 0;
        int sum = 0;
        List<Integer> appleList = new ArrayList<>();
        if(score.length<m) return 0;
        Arrays.sort(score);

        for(int i = score.length-1;i>=0;i--){
            appleList.add(score[i]);
            if(appleList.size()==m){
                sum+=appleList.get(appleList.size()-1)*m;
                appleList.clear();
            }
        }

        return sum;
    }
//다른사람의 풀이
  /*  public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }*/

}
