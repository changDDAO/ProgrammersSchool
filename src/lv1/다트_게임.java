package lv1;

import java.util.Arrays;

public class 다트_게임 {
    public int solution(String dartResult) {
        //*이라면 이전점수 2배씩 S D T single double triple //옵션 # 바로이전꺼 -
        int answer =0;
        int [] dartScore = new int[3];
        char[] result = dartResult.toCharArray();
        int idx = 0;
        String str = "";
        for(int i=0;i<result.length;i++){
            char temp = result[i];
            if(temp>='0'&&temp<='9'){
                str+=String.valueOf(temp);
            }
            else if(temp =='S'||temp =='D'||temp=='T'){
                int sc = Integer.parseInt(str);
                if(temp=='S')dartScore[idx++]=(int)Math.pow(sc,1);
                if(temp=='D')dartScore[idx++]=(int)Math.pow(sc,2);
                if(temp=='T')dartScore[idx++]=(int)Math.pow(sc,3);
                str ="";
            }else{
                if(temp=='*'){
                    dartScore[idx-1]*=2;
                    if(idx-2>=0)
                        dartScore[idx-2]*=2;
                }else{
                    dartScore[idx-1]*=-1;
                }

            }
        }
        return Arrays.stream(dartScore).sum();

    }
}
