package lv0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 글자_지우기 {
    public String solution(String my_string, int[] indices) {
        String [] myString = my_string.split("");
        for(int i=0; i<myString.length;i++){
            for(int j= 0; j<indices.length;j++){
                if(i==indices[j]){
                    myString[i]="";
                }
            }
        }
        String answer = Arrays.stream(myString).collect(Collectors.joining());
        System.out.println(answer);
        return answer;
    }
}
