package lv0;

import java.util.*;
import java.util.stream.Collectors;

public class OneAlpha {
    // 리뷰를 통해 봤을 때 좋은코드
    public String solution(String s) {
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 1){
                answer.append((char)(i + 'a'));
            }
        }
        return answer.toString();
    }

    class Solution {
        public String solution(String s) {
            String answer = "";
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i<s.length();i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            List<Character> cList = new ArrayList<>();
            Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
            int sum = 0;
            while(iter.hasNext()){
                Map.Entry<Character, Integer> entry = iter.next();

                if(entry.getValue()==1)cList.add(entry.getKey());


            }
            if(cList.size()==0) return "";
            Collections.sort(cList);

            return  cList.stream().map(String::valueOf).collect(Collectors.joining());

        }
    }

    //내풀이 그냥 java 집약체

}
