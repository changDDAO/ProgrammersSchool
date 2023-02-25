package ProgrammersThreeWeek;

public class PairOfParentheses2 {
    int answer = 0;
    public void dfs(int left, int right, int n) {
        //dfs를 돌면서 찾고자 하는것은 괄호의 갯수 쌍이 n일 때 매칭되는 괄호의 갯수
        if(left>n||right>n) return;
        if(right>left) return;
        if (left == n && right == n) {
            answer++;
            return;
        }
        dfs(left+1,right,n);
        dfs(left,right+1,n);
    }
}
