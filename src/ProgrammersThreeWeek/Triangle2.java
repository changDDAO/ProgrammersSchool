package ProgrammersThreeWeek;

import java.util.Arrays;

/*
    ㅁ
   ㅁㅁ
  ㅁㅁㅁ
 ㅁㅁㅁㅁ
ㅁㅁㅁㅁㅁ
*/
// dp로 해결한다. 왼쪽위에서 오는경우 오른쪽위에서 오는경우
public class Triangle2 {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //j==0인경우 오른쪽위에서 밖에 올수없음
                if(j==0)
                    triangle[i][j]=triangle[i][j]+triangle[i-1][j];
                else if (j == triangle[i].length - 1){
                    triangle[i][j]=triangle[i][j]+triangle[i-1][j-1];
                }
                else{
                    int leftUp = triangle[i][j] + triangle[i - 1][j - 1];
                    int rightUp = triangle[i][j]+ triangle[i-1][j];
                    triangle[i][j]=Math.max(leftUp,rightUp);
                }
            }
            //현재 2중 for문 돌면서 값이 다갱신이 되었고 1층에 있는(가장밑에있는)값들 중 가장 큰값을 return
            answer = Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
        }
        return answer;
    }

}
