package lv1;

public class 이상한_문자_만들기 {
    class Solution {
        public String solution(String s) {

            String answer = "";
            int cnt = 0;
            String[] array = s.split("");

            for(String ss : array) {
                cnt = ss.contains(" ") ? 0 : cnt + 1;
                answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
            }
            return answer;
        }
    }
}
