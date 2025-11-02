import java.util.*;

class Solution {
    static boolean[][] isVisited;
    static char[][] map;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static int width;
    static int height;
    static int answer;
    public int solution(String[] storage, String[] requests) {
        
        map = new char[storage.length][];
        for (int i = 0; i < map.length; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        height = storage.length;
        width = storage[0].length();
        
        answer = height * width;
        
        for (String req : requests) {
            int strlen = req.length();
            if (strlen == 2) {
                useCrane(req.charAt(0));
            } else {
                useJige(req.charAt(0));
            }
        }
        return answer;
    }
    
    public void useCrane(char target) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '-';
                    answer--;
                }
            }
        }
    }
    
    public void useJige(char target) {
        isVisited = new boolean[height][width];
        for (int i = 0; i < height; i++) { // |         |
            if (!isVisited[i][0]) { // 맨 왼쪽 세로
                BFS(i, 0, target);
            }
            if (!isVisited[i][width - 1]) {  // 맨 오른쪽 세로
                BFS(i, width - 1, target);
            }
        }
        
        for (int i = 0; i < width; i++) {
            if (!isVisited[0][i]) { // 맨 위 가로
                BFS(0, i, target);
            }
            if (!isVisited[height - 1][i]) { // 맨 아래 가로
                BFS(height - 1, i, target);
            }
        }
    }
    
    public void BFS(int startRow, int startCol, char target) {
        char startChar = map[startRow][startCol];
        if (startChar != target && startChar != '-') {
            return;
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startRow, startCol});
        isVisited[startRow][startCol] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            if (map[curRow][curCol] == target) {
                map[curRow][curCol] = '-';
                answer--;
                continue; // 지우면 끝
            }
           if (map[curRow][curCol] == '-') {
               for (int i = 0; i < 4; i++) {
                    int nextRow = curRow + dirX[i];    
                    int nextCol = curCol + dirY[i];    
                   if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width) {
                       if (!isVisited[nextRow][nextCol]) {
                        char nextChar = map[nextRow][nextCol];
                        if (nextChar == target || nextChar == '-') {
                            q.offer(new int[]{nextRow, nextCol});
                            isVisited[nextRow][nextCol] = true; 
                        }
                       }
                   }
               }
               
               
           } 
        }
    }
}