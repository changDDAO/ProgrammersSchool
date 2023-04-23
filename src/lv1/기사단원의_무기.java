package lv1;

import java.util.Arrays;

public class 기사단원의_무기 {

    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int [] numList =  new int[number+1];
            for(int i=0;i<numList.length;i++)
                numList[i]=i; //자기자신으로 매핑
            for(int i=1;i<numList.length;i++){
                numList[i]=cntCd(numList[i]);
                if(numList[i]>limit)
                    numList[i]=power;
            }
            answer = Arrays.stream(numList).sum();
            System.out.println("cntCd:"+cntCd(0));
            return answer;
        }
        public int cntCd(int num){

            int count = 0;
            for (int i = 1; i<= (int) Math.sqrt(num); i++) {
                if (i*i== num) count++;
                else if (num % i == 0) count += 2;
            }
            return count;
        }



    }
}
