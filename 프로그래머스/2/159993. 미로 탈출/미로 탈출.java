import java.util.*;

class Solution {
    
    static char[][] map;
    static int[] startPoint = new int[2];
    static int[] LPoint = new int[2];
    static int[] destPoint = new int[2];
    static int[] rowDir = {1, -1, 0, 0};
    static int[] colDir = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) { // 수정된 부분
                if (map[i][j] == 'S') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                } else if (map[i][j] == 'L') {
                    LPoint[0] = i;
                    LPoint[1] = j;
                } else if (map[i][j] == 'E') {
                    destPoint[0] = i;
                    destPoint[1] = j;
                }
            }
        }
        
        // 시작점에서 레버로 이동하는 BFS
        int LCnt = bfs(startPoint[0], startPoint[1], 'L');
        if (LCnt == -1) return -1;
        
        // 레버에서 출구로 이동하는 BFS
        int ECnt = bfs(LPoint[0], LPoint[1], 'E');
        if (ECnt == -1) return -1;
        
        answer = LCnt + ECnt;
        return answer;
    }
    
    private int bfs(int startRow, int startCol, char target) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol, 0});
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        isVisited[startRow][startCol] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (map[current[0]][current[1]] == target) {
                return current[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nextRow = current[0] + rowDir[i];
                int nextCol = current[1] + colDir[i];
                
                if (0 <= nextRow && nextRow < map.length && 0 <= nextCol && nextCol < map[0].length) {
                    if (!isVisited[nextRow][nextCol] && map[nextRow][nextCol] != 'X') {
                        isVisited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol, current[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}
