package codingTestBasic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 베열_조각하기 {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(int i = 0; i<query.length;i++){
            if(i%2==0) arrList = arrList.subList(0,query[i]+1);
            else arrList = arrList.subList(query[i],arrList.size());
        }
        return arrList.stream().mapToInt(Integer::intValue)
                .toArray();
    }
}
