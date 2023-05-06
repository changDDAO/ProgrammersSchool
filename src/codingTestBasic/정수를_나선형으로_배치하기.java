package codingTestBasic;

public class 정수를_나선형으로_배치하기 {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int [][]directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirIdx = 0;
        int x=0;
        int y =-1;
        int num = 1;
        while(num<=n*n){
            x += directions[dirIdx][0];
            y += directions[dirIdx][1];
            //조건넣기
            if(x<0||x>=n||y<0||y>=n||answer[x][y]!=0){
                x -= directions[dirIdx][0];
                y -= directions[dirIdx][1];
                dirIdx++;
                if(dirIdx==4)dirIdx =0;
                x+=directions[dirIdx][0];
                y+=directions[dirIdx][1];
            }
            answer[x][y]=num++;
        }
        return answer;
    }
}
