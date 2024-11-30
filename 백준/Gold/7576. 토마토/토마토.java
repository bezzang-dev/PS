import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());   
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    queue.offer(new int[]{i, j, 0});
                    map[i][j] = 1;   
                }
                map[i][j] = value;
            }
        }

        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // BFS
        int maxCnt = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            int curCnt = current[2];
            
            maxCnt = Math.max(maxCnt, curCnt);

            for (int k = 0; k < 4; k++) {
                int nextRow = curRow + dx[k];
                int nextCol = curCol + dy[k];
                if (0 <= nextRow && nextRow < M && 0 <= nextCol && nextCol < N) {
                    if (map[nextRow][nextCol] == 0) {
                        map[nextRow][nextCol] = 1;
                        queue.offer(new int[]{nextRow, nextCol, curCnt + 1});
                    }
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                
            }
        }
        System.out.println(maxCnt);
    }
}