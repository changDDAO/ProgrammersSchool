package lv1;

import java.util.Arrays;

public class 크기가_작은_부분문자열 {
    int answer = 0;
    public int solution(String t, String p) {

        StringBuilder sb = new StringBuilder();
        if(p.length()==1){
            Arrays.stream(t.split("")).forEach(v->{
                if(Integer.parseInt(v)<=Integer.parseInt(p))
                    answer++;
            });
            return answer;
        }
        for(int i=0; i<t.length()-(p.length()-1);i++){
            for(int j = i; j<p.length()+i;j++){
                sb.append(t.charAt(j));
            }
            String temp = sb.toString();
            if(temp.compareTo(p)<=0) answer++;
            sb.setLength(0);
        }
        return answer;
    }
}
