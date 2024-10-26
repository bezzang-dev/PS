import java.util.*;

class Solution {
    
    static int[] rowDir = {1, -1, 0, 0};  // 하, 상, 우, 좌
    static int[] colDir = {0, 0, 1, -1};  // 하, 상, 우, 좌
    
    static int rowGoal = 0;
    static int colGoal = 0;
    
    public int solution(String[] board) {
        int rowMax = board.length;
        int colMax = board[0].length();
        
        char[][] map = new char[rowMax][colMax];
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 맵 초기화 및 시작점, 목표지점 찾기
        for(int i = 0; i < rowMax; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < colMax; j++) {
                if (map[i][j] == 'R') {
                    queue.offer(new int[]{i, j, 0});  // 현재 행, 열, 이동 횟수
                } else if (map[i][j] == 'G') {
                    rowGoal = i;
                    colGoal = j;
                }
            }
        }
        
        boolean[][] isVisited = new boolean[rowMax][colMax];
        
        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int moves = current[2];
            
            // 목표 지점 도달 시 이동 횟수 반환
            if (currentRow == rowGoal && currentCol == colGoal) {
                return moves;
            }
            
            // 방문 체크
            if (isVisited[currentRow][currentCol]) {
                continue;
            }
            isVisited[currentRow][currentCol] = true;

            // 4방향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow;
                int nextCol = currentCol;
                
                // 장애물이나 경계를 만날 때까지 이동
                while (true) {
                    int tempRow = nextRow + rowDir[i];
                    int tempCol = nextCol + colDir[i];
                    
                    // 경계를 벗어나거나 장애물을 만나면 중단
                    if (tempRow < 0 || tempRow >= rowMax || tempCol < 0 || tempCol >= colMax || map[tempRow][tempCol] == 'D') {
                        break;
                    }
                    
                    nextRow = tempRow;
                    nextCol = tempCol;
                }
                
                // 새로운 위치가 유효하고 아직 방문하지 않았다면 큐에 추가
                if (!isVisited[nextRow][nextCol]) {
                    queue.offer(new int[]{nextRow, nextCol, moves + 1});
                }
            }
        }
        
        // 목표 지점에 도달할 수 없는 경우 -1 반환
        return -1;
    }
}
