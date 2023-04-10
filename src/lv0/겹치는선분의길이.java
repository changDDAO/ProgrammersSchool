package lv0;

public class 겹치는선분의길이 {
    public int solution(int[][] lines) {
        int answer = 0;
        //선분에 -값을 인덱스로 둘수없으므로
        int [] segment = new int[201];
        for(int []line : lines){
            int start = line[0];
            int end = line[1];
            while(start<end){
                segment[start+100]++;
                start++;
            }
        }
        for(int i =0; i<segment.length;i++){
            if(segment[i]>=2)
                answer++;
        }
        return answer;
    }
}
