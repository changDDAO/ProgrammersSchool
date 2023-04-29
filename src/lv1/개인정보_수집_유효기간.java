package lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보_수집_유효기간 {

        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answerList = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for(String term : terms){
                String[] temp = term.split(" ");
                map.put(temp[0],Integer.parseInt(temp[1]));
            }
            String [] dateSum = today.split("[.]");
            int year = Integer.parseInt(dateSum[0]);
            int month = Integer.parseInt(dateSum[1]);
            int day = Integer.parseInt(dateSum[2]);
            int ds = year*28*12 + month*28 + day;
            for(int i=0; i<privacies.length; i++){
                String[] temp = privacies[i].split(" ");
                String []date = temp[0].split("[.]");
                int ps = Integer.parseInt(date[0])*28*12+Integer.parseInt(date[1])*28+Integer.parseInt(date[2])
                        +map.get(temp[1])*28;
                if(ds>=ps)answerList.add(i+1);
            }



            return answerList.stream().mapToInt(v->v).toArray();
        }
}
