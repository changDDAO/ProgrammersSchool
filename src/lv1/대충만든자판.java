package lv1;

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(String temp : keymap){
            for(int i=0; i<temp.length();i++){
                char c = temp.charAt(i);
                if(!map.containsKey(c)||i<map.get(c)){
                    map.put(c,i+1);
                }
            }

        }
        for(int i = 0; i< targets.length;i++){
            int sum=0;
            for(int j = 0; j<targets[i].length();j++){
                if(!map.containsKey(targets[i].charAt(j))){
                    sum=0;
                    break;
                }else{
                    sum+=map.get(targets[i].charAt(j));
                }


            }
            answer[i] = sum!=0?sum:-1;
        }
        return answer;
    }
}
