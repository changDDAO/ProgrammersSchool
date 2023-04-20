package lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 숫자_짝꿍 {
    public String solution(String X, String Y) {
        String answer = "";
        List<String> strList = new ArrayList<>();
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();
        for(String key : X.split("")){
            xMap.put(key, xMap.getOrDefault(key,0)+1);
        }
        for(String key : Y.split("")){
            yMap.put(key, yMap.getOrDefault(key,0)+1);
        }
        for(String key : xMap.keySet()){
            if(!yMap.containsKey(key)) continue;
            int range = Math.min(xMap.get(key),yMap.get(key));
            for(int i = 0 ;i<range;i++)
                strList.add(key);
        }
        if (strList.size()==0) return "-1";
        String ans = strList.stream().sorted((a,b)->b.compareTo(a))
                .collect(Collectors.joining());
        if(ans.startsWith("0")) return "0";


        return ans;

    }
}
