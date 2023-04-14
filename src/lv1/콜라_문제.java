package lv1;

public class 콜라_문제 {
    int result = 0;
    public int solution(int a, int b, int n) {
        dfs(a,b,n);
        return result;
    }
    public void dfs(int give,int ret,int n){
        if(n <give) return;
        int get = (n/give)*ret;
        int rest = n%give;
        result+=get;
        dfs(give,ret,get+rest);
    }
}
