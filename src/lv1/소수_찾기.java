package lv1;

public class 소수_찾기 {
    public int solution(int n) {
        int answer = 0;
        int []numArr = new int[n+1];
        for(int i =2; i<=n;i++){
            numArr[i]=i;//자기 자신으로 초기화
        }
        for(int i=2;i<=n;i++){
            if(numArr[i]==0) continue;
            for(int j = 2*i;j<=n;j+=i){
                numArr[j]=0;
            }
        }

        for(int i=2;i<=n;i++){
            if(numArr[i]!=0)answer++;
        }

        return answer;
    }
}
