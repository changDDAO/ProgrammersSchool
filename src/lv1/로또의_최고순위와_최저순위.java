package lv1;

public class 로또의_최고순위와_최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zero = 0;
        for(int i =0; i<lottos.length;i++){
            if(lottos[i]==0)zero++;
            else{
                for(int j = 0;j<win_nums.length;j++){
                    if(lottos[i]==win_nums[j])cnt++;
                }
            }
        }
        int max = 7-(zero+cnt);
        int min = 7-cnt;
        if(max>6) max = 6;
        if(min>6) min = 6;
        return new int[]{max,min};
    }
}
