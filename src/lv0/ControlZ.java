package lv0;

import java.util.Stack;

public class ControlZ {
    //stack 자료구조를 이용하면 좋은풀이
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (String w : s.split(" ")) {
            if (w.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(w));
            }
        }
        for (int i : stack) {
            answer += i;
        }
        return answer;
    }
}
