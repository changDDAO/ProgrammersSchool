package lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 두개_뽑아서_더하기 {

        public int[] solution(int[] numbers) {
            List<Integer> iList = new ArrayList<>();
            for(int i =0; i<numbers.length-1;i++){
                for(int j=i+1;j<numbers.length;j++){
                    int sum = numbers[i]+numbers[j];
                    if(!iList.contains(sum))
                        iList.add(sum);
                }
            }
            Collections.sort(iList);
            int [] answer =iList.stream().mapToInt(Integer::intValue).toArray();

            return answer;

        }
}
