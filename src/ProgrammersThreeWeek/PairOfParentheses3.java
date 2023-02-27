package ProgrammersThreeWeek;

public class PairOfParentheses3 {
    int answer = 0;

    int solution(int n) {
        //n에는 괄호 쌍의 갯수가 주어지고 올바른 괄호의 갯수를 세서 return 한다.
        dfs(0,0,n);
        return answer;
    }
    private void dfs(int left, int right, int n) {
        //종료 조건 명시
        if(left>n||right>n) return;
        if(left<right) return;
        if(left==n&&right==n) answer++;

        //수행해야되는 동작
        dfs(left+1,right,n);
        dfs(left,right+1,n);
    }
}
