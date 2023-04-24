package lv1;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char [][] types= {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        int [] scores = {0,3,2,1,0,1,2,3};
        Map<Character, Integer> map = new HashMap<>();
        //map 초기화
        for(char [] type : types){
            map.put(type[0],0);
            map.put(type[1],0);
        }
        //map에 값넣기
        for(int i = 0; i<choices.length;i++){
            if(choices[i]>4){
                map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+scores[choices[i]]);
            }else{
                map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+scores[choices[i]]);
            }
        }
        for(char[] type : types){
            answer+= map.get(type[0])>=map.get(type[1])?type[0]:type[1];
        }



        return answer;
    }
}
