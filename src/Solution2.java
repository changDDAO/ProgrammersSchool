import java.util.*;

public class Solution2 {
    class Cell{
        int row;
        int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj==null||this.getClass()!=obj.getClass()) return false;
            Cell cell = (Cell) obj;
            return this.row == cell.row&& this.column==cell.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row,column);
        }
    }
    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        Queue<Cell> queue = new LinkedList<>();

        for (int[] query : queries) {
            Set<Cell> visited = new HashSet<>();
            queue.offer(new Cell(query[0]-1,query[1]-1));//인덱스로 바꾸기위해 -1
            while (!queue.isEmpty()) {
                Cell current = queue.poll();
                if(current.getRow()<0||current.getRow()>=rows||current.getColumn()<0||current.getColumn()>=columns) continue;
                if(visited.contains(current))continue;
                visited.add(current);
                if (answer[current.getRow()][current.getColumn()] < max_virus) {
                    answer[current.getRow()][current.getColumn()]+=1;
                    continue;
                }
                queue.offer(new Cell(current.getRow()+1,current.getColumn()));
                queue.offer(new Cell(current.getRow()-1,current.getColumn()));
                queue.offer(new Cell(current.getRow(),current.getColumn()+1));
                queue.offer(new Cell(current.getRow(),current.getColumn()-1));

            }


        }

        return answer;
    }
}
