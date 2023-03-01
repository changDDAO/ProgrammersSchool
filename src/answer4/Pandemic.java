package answer4;

import java.util.*;

class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

class Pandemic {
    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        Queue<Cell> queue = new LinkedList<>();

        for (int[] q : queries) {
            // 방문한 곳을 확인하기 위해 Set 을 사용
            // (Cell 이 hashCode, equals 를 재정의 하고 있기 때문에 가능)
            Set<Cell> visited = new HashSet<>();

            // 세균을 증식했을 때 연쇄적으로 주변에 증식되는 것을 BFS적으로 계산
            queue.offer(new Cell(q[0] - 1, q[1] - 1)); // 인덱스로 만들기 위해 -1
            while (!queue.isEmpty()) {
                Cell current = queue.poll();

                // 영역 밖이면 무시
                if (current.row < 0 || current.row >= rows || current.col < 0 || current.col >= columns) continue;
                // 이미 방문한 곳이면 무시
                if (visited.contains(current)) continue;

                visited.add(current);
                if (answer[current.row][current.col] < max_virus) {
                    answer[current.row][current.col] += 1;
                    continue;
                }

                // 주변에 증식
                queue.offer(new Cell(current.row, current.col + 1));
                queue.offer(new Cell(current.row, current.col - 1));
                queue.offer(new Cell(current.row + 1, current.col));
                queue.offer(new Cell(current.row - 1, current.col));
            }
        }


        return answer;
    }
}