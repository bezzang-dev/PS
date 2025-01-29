import java.util.*;

class Solution {
    static boolean[][] isVisited;
    static char[][] map;
    static int[] xDir = {1, -1, 0, 0};
    static int[] yDir = {0, 0, 1, -1};
    static int rowMax, colMax;
    public int[] solution(String[] maps) {
        map = new char[maps.length][];
        rowMax = maps.length;
        int idx = 0;
        for (String row : maps) {
            map[idx++] = row.toCharArray();
        }
        ArrayList<Integer> list = new ArrayList<>();
        isVisited = new boolean[map.length][map[0].length];
        colMax = map[0].length;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X' && !isVisited[i][j]) {
                    list.add(BFS(i, j));
                }
            }
        }
        if (list.isEmpty()) list.add(-1);
        else {
            Collections.sort(list);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int BFS(int startRow, int startCol) {
        int sum = map[startRow][startCol] - '0';
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        isVisited[startRow][startCol] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            for (int i = 0; i < 4;i++) {
                int nextRow = curRow + xDir[i];
                int nextCol = curCol + yDir[i];
                if (0 <= nextRow && nextRow < rowMax && 0 <= nextCol && nextCol < colMax) {
                    if (!isVisited[nextRow][nextCol] && map[nextRow][nextCol] != 'X') {
                        queue.offer(new int[]{nextRow, nextCol});
                        isVisited[nextRow][nextCol] = true;
                        sum += map[nextRow][nextCol] - '0';                         
                    }
                }
            }
        }
        
        return sum;
    }
}