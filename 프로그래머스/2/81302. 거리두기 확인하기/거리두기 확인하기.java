import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        int idx = 0;
        for (String[] place : places) {
            map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                map[i] = place[i].toCharArray();
            }
            
            for (int i = 0; i < 5; i++) {
                boolean flag = false;
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == 'P') {
                        if (!BFS(i, j)) {
                            answer[idx] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) break;
            }
            idx += 1;
        }
        
        return answer;
    }
    
    boolean BFS(int startRow, int startCol) {
        boolean[][] isVisited = new boolean[5][5];
        isVisited[startRow][startCol] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = dx[i] + current[0];
                int nextCol = dy[i] + current[1];
                if (0 <= nextRow && nextRow < 5 && 0 <= nextCol && nextCol < 5 && !isVisited[nextRow][nextCol]) {
                    int d = Math.abs(nextRow - startRow) + Math.abs(nextCol - startCol);
                    if (map[nextRow][nextCol] == 'O' && d < 2) {
                        isVisited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    } else if (map[nextRow][nextCol] == 'P' && d <= 2) {
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
    
    boolean calcDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2) > 2 ? true : false;
    }
}