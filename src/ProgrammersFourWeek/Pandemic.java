package ProgrammersFourWeek;


import java.util.*;

public class Pandemic {
    class Virus{
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this ==obj) return true;
            if(obj==null||this.getClass()!=obj.getClass())return false;
            Virus virus = (Virus) obj;
            return this.x == virus.x && this.y == virus.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        Queue<Virus> virusQueue = new LinkedList<>();

        for (int[] query : queries) {

            Set<Virus> visited = new HashSet<>();
            virusQueue.offer(new Virus(query[0]-1, query[1]-1));//인덱스로 바꿔서
            while (!virusQueue.isEmpty()) {

                Virus curPos = virusQueue.poll();//현재 쿼리에서 뽑아와서 주입
                if (curPos.x < 0 || curPos.x >= rows || curPos.y < 0 || curPos.y >= columns) continue;
                if(visited.contains(curPos)) continue; //이미 방문했던 경우라면 pass
                visited.add(curPos);
                if (answer[curPos.x][curPos.y] < max_virus) {
                    answer[curPos.x][curPos.y]+=1;
                    continue;
                }

                virusQueue.offer(new Virus(curPos.x-1,curPos.y));
                virusQueue.offer(new Virus(curPos.x+1,curPos.y));
                virusQueue.offer(new Virus(curPos.x,curPos.y+1));
                virusQueue.offer(new Virus(curPos.x,curPos.y-1));



            }

        }


        return answer;
    }
}
