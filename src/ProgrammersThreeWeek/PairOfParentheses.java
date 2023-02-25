package ProgrammersThreeWeek;

import java.util.Stack;

public class PairOfParentheses {
    class Parentheses {
        int left;
        int right;

        public Parentheses(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public int solution(int n) {
        int answer = 0;

        Stack<Parentheses> parenthesesStack = new Stack<>();
        parenthesesStack.push(new Parentheses(0,0));
        while (!parenthesesStack.isEmpty()) {
            Parentheses selectedParentheses =parenthesesStack.pop();
            if(selectedParentheses.left>n)continue;
            if(selectedParentheses.left<selectedParentheses.right)continue;

            if (selectedParentheses.left + selectedParentheses.right == 2 * n) {
                answer++;
                continue;
            }
            parenthesesStack.push(new Parentheses(selectedParentheses.left+1, selectedParentheses.right));
            parenthesesStack.push(new Parentheses(selectedParentheses.left, selectedParentheses.right+1));
        }
        return answer;
    }

}
