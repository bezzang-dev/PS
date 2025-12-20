import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;

    static int[] dirX = new int[]{-1, 1, 0, 0};
    static int[] dirY = new int[]{0, 0, 1, -1};

    static int N;
    static int M;

    static int maxDistance = -1;
    static int maxPassword = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    BFS(i, j);
                }
            }
        }

        System.out.println(maxPassword);
    }

    static int BFS(int startRow, int startCol) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, startRow, startCol}); // distance, row, col
        boolean[][] isVisited = new boolean[N][M];
        isVisited[startRow][startCol] = true;
        
        int password = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentDistance = current[0];
            int currentRow = current[1];
            int currentCol = current[2];

            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                maxPassword = map[startRow][startCol] + map[currentRow][currentCol];
            } else if (currentDistance == maxDistance) {
                maxPassword = Math.max(maxPassword, map[startRow][startCol] + map[currentRow][currentCol]);
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + dirX[i];
                int nextCol = currentCol + dirY[i];
                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if (map[nextRow][nextCol] != 0 && !isVisited[nextRow][nextCol]) {
                        isVisited[nextRow][nextCol] = true;
                        queue.offer(new int[]{currentDistance + 1, nextRow, nextCol});
                    }
                }
            }
        }

        return password;
    }
}