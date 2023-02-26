package ProgrammersThreeWeek;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_game2 {
    //벽이 있는 경우 : 0, 벽이 없는 경우 :1
    // 갈수 있는길인지 판단하자. 초기 맵은 훼손 되면 안되므로 가는길을 카운트 할수 있는 맵을 하나 더 두자
    //BFS 알고리즘을 이용하여 풀이 할것이므로 queue를 사용하자
    // 시작점은 0, 0이다
    class CurPos{
        int x; //위아래
        int y; // 왼오

        public CurPos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        boolean canGo(int height, int width) {
            if (this.x < 0 || this.x >= height) return false;
            if (this.y < 0 || this.y >= width) return false;
            return true;
        }
    }
    public int solution(int[][] maps) {
    int answer = 0;
    int width = maps[0].length;
    int height = maps.length;
        int[][] roadCount = new int[height][width];
        boolean[][] visited = new boolean[height][width];
    //최종적으로 return 해야되는 값은 시작 진영부터 상대방 진영까지의 count값 중 최솟값
        Queue<CurPos> queue = new LinkedList<>();
        queue.add(new CurPos(0, 0));
        visited[0][0]=true;
        roadCount[0][0]=1;
        //갈수있는 방향 정의하기
        int[][] nextGo = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            CurPos curPos = queue.poll();
            int curPosCnt = roadCount[curPos.getX()][curPos.getY()];
            for (int[] nG : nextGo) {
                CurPos nextPos = new CurPos(curPos.getX() + nG[0], curPos.getY() + nG[1]);
                if(!nextPos.canGo(height,width)) continue;
                if(visited[nextPos.getX()][nextPos.getY()])continue;
                if(maps[nextPos.getX()][nextPos.getY()]==0)continue;
                roadCount[nextPos.getX()][nextPos.getY()]=curPosCnt+1;
                visited[nextPos.getX()][nextPos.getY()]=true;
                queue.offer(nextPos);
            }
        }
    answer = (roadCount[height-1][width-1]!=0)?roadCount[height-1][width-1]:-1;
        return answer;
    }

}
