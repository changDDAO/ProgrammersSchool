package lv1;

public class 문자열_나누기 {
    public int solution(String s) {
        int answer = 0;
        char src = s.charAt(0);
        int srcNum =0;
        int another =0;
        for(int i =0; i<s.length();i++){
            if(srcNum==another){
                answer++;
                src = s.charAt(i);
            }
            if(src==s.charAt(i)) srcNum++;
            else another++;
        }

        return answer;
    }
}
