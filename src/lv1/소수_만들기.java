package lv1;

public class 소수_만들기 {
    int result =0;
    int []genList = new int[3];
    int []refArr;
    public int solution(int[] nums) {
        refArr = nums;
        dfs(0,0);
        return result;
    }
    public boolean isPrime(int n){

        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
    public void dfs(int idx, int depth){
        if(depth==3){
            int sum = 0;
            for(int i =0;i<3;i++){
                sum+=genList[i];
            }
            if(isPrime(sum))result++;
            return;
        }
        for(int i= idx; i<refArr.length;i++){
            genList[depth] = refArr[i];
            dfs(i+1,depth+1);
        }
    }
}
