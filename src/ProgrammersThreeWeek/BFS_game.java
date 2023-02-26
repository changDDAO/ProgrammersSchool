package ProgrammersThreeWeek;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_game {
    class CurPos {
        private int x;
        private int y;

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
        public boolean canGo(int mapHeight, int mapWidth) {
            if(this.getX()<0||this.getX()>=mapHeight)return false;
            if(this.getY()<0||this.getY()>=mapWidth)return false;
            return true;
        }
    }



    public int solution(int[][] maps) {
        int answer = 0;
        //현재 maps에 담긴값은 지도임 0 : 벽 1: 길
        //bfs문제이므로 queue를 사용
        //조건에는 벽이아닐때 갈수있고, 즉 1일때만 이동가능//2. 맵밖을 나갈 수 없음.//3. 방문한위치는 돌아가지않음
        int mapHeight = maps.length;
        int mapWidth = maps[0].length;
        boolean [][]visited = new boolean[mapHeight][mapWidth];//방문한 지점 표시
        int [][]count = new int[mapHeight][mapWidth];//초기부터 갈수있는길 count 누적하기위한 값을 담을 배열
        Queue<CurPos> curPosQueue = new LinkedList<>();
        CurPos curPos = new CurPos(0,0);// 초기 시작 지점
        curPosQueue.offer(curPos);
        count[0][0]=1;
        visited[0][0]=true;
        final int [][] nextPosList = {{1,0},{-1,0},{0,1},{0,-1}};//상 하 좌 우
        //code up 때문에 새로운 방법을 해봤지만 runtime error 걸림.. primitive type이 맞는듯 int []dx []dy 이거 질문해보자
        while (!curPosQueue.isEmpty()) {
            CurPos curPos1 = curPosQueue.poll();
            int curCnt = count[curPos1.getX()][curPos1.getY()];
            for (int i = 0; i < nextPosList.length; i++) {//예전에는 dx,dy 따로 처리했지만 code up
                CurPos nextPos = new CurPos(curPos1.getX()+nextPosList[i][0],curPos1.getY()+nextPosList[i][1]);
                //if(!visited[nextPos.getX()][nextPos.getY()]&&nextPos.canGo(mapHeight,mapWidth))
                //가독성이 너무 떨어져서 따로 처리하기
                if(!nextPos.canGo(mapHeight,mapWidth))continue;// 다음 포지션이 갈수없다면(map 범위를 넘어가는 경우)반복문 다시 순회
                if(visited[nextPos.getX()][nextPos.getY()])continue;
                if(maps[nextPos.getX()][nextPos.getY()]==0)continue; //다음 포지션이 갈수없다면(벽인 경우)
                count[nextPos.getX()][nextPos.getY()]=curCnt+1;
                visited[nextPos.getX()][nextPos.getY()]=true;
                curPosQueue.offer(nextPos);
            }

        }
        answer = (count[mapHeight-1][mapWidth-1]!=0)?count[mapHeight-1][mapWidth-1]:-1;



        return answer;
    }
}