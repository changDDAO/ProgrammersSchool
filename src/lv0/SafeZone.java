package lv0;

public class SafeZone {

    public int solution(int[][] board) {
        int answer = 0;
        int w = board[0].length;
        int h = board.length;
        int[][] nextDir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        boolean visited[][] = new boolean[h][w];
        for(int i= 0;i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j]==1){
                    visited[i][j]=true;
                    for(int [] nd : nextDir){
                        int nx = i+nd[0];
                        int ny = j+nd[1];
                        if(nx<0||nx>=h||ny<0||ny>=w||visited[nx][ny])continue;
                        visited[nx][ny]=true;
                    }
                }
            }
        }

        for(int i = 0; i<h;i++){
            for(int j=0;j<w;j++){
                if(!visited[i][j])answer++;
            }
        }


        return answer;
    }
}
