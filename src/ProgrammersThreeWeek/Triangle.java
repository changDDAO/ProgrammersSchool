package ProgrammersThreeWeek;
import java.util.Arrays;
class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        //leftUp, rightUp 왼쪽에서 오는경우와 오른쪽에서 오는경우
        //bottomUp 방식으로 해결하자
        /*ㅁ
          ㅁㅁ
          ㅁㅁㅁ
          ㅁㅁㅁㅁ
          ㅁㅁㅁㅁㅁ*/
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                if(j==0)triangle[i][j]=triangle[i][j]+triangle[i-1][j];
                else if (i == j) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
                } else {
                    //왼쪽 위에서 오는경우
                    int leftUp = triangle[i][j]+triangle[i-1][j-1];
                    //오른쪽 위에서 오는경우
                    int rightUp = triangle[i][j]+triangle[i-1][j];
                    triangle[i][j]= Math.max(leftUp,rightUp);
                }

            }
        }
        answer = Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        return answer;
    }
}