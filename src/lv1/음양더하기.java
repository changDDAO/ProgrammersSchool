package lv1;

import java.util.Arrays;

public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        int [] nums = new int[absolutes.length];
        for(int i = 0; i<absolutes.length;i++){
            if(signs[i]) nums[i]=absolutes[i];
            else nums[i]= -absolutes[i];

        }
        answer = Arrays.stream(nums).sum();
        return answer;
    }
}
