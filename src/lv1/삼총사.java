package lv1;

public class 삼총사 {
    private static int [] nArr;
    private static int N;
    private static int [] answer = new int[3];
    private static int result=0;
    public int solution(int[] number) {
        N = number.length;
        nArr = number;
        dfs(0,0);
        return result;
    }
    public void dfs(int index, int depth){
        if(depth == 3){
            int sum =0;
            for(int i=0;i<3;i++){
                sum+=answer[i];
            }
            if(sum==0) result++;
            return;
        }
        for(int i = index;i<N;i++){
            answer[depth]=nArr[i];
            dfs(i+1,depth+1);
        }
    }
}
