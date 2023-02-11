import java.util.Arrays;

class Solution {
    //철수는 k번째 연속으로 동전만 뒤집을 수 있다.
    //최종목표는 동전이 모두 같은면이 나오게 1또는 0
    //제약조건이 coin length가 3부터이므로 동전하나일때는 고려xx
    //제약조건 2 만약 철수가 모두 같은면으로 만들 수 없다면 return -1
    //제약조건 2(동전면이 1또는 0인데 동전의 합이 k(한번에 뒤집을 연속된 동전갯수)가 아니면서 coin.length가 k일 때)
    public int solution(int[] coin, int k) {
        int answer = 0;
        int sum = Arrays.stream(coin).sum();
        if(sum==0||sum==coin.length) return 0;
        if(k!=sum&&coin.length==k) return -1;
        int allZero = flip(Arrays.copyOf(coin,coin.length), k, 0);
        int allOne = flip(Arrays.copyOf(coin,coin.length),k,1);
        answer = Math.min(allOne,allZero);
        if (answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    public int flip(int []coins, int k, int want) {
        int flipCnt = 0;
        //coin 배열에서 k만큼 flip시킬 수 있는 횟수
        for (int i = 0; i < coins.length - k + 1; i++) {
            if(coins[i]==want)continue;//만약 for문을 돌면서 현 index가 원하는 값일 경우 flip xx
            for (int j = 0;j<k;j++ ) {
                coins[i+j] = 1 - coins[i+j]; // 진짜 참신한데 0->1, 1->0
            }
            flipCnt++;
        }
        int cnt  =0;
        for(int coin : coins) if(coin==want)cnt++; //전체 coins 배열을 순회하면서 목표하는 동전면과 같다면 cnt증가
        if(cnt == coins.length) return flipCnt;
        else return Integer.MAX_VALUE;


    }
}