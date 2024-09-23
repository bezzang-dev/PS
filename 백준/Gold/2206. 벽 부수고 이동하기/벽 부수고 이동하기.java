import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int N, M;
    static int[] rowDir = {1, -1, 0, 0};
    static int[] colDir = {0, 0, 1, -1};

    static class Point {
        int row, col, dist, wallBroken;

        Point(int row, int col, int dist, int wallBroken) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.wallBroken = wallBroken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        // 3차원 배열: [row][col][벽을 부쉈는지 여부]
        boolean[][][] visited = new boolean[N][M][2];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0)); // 시작점 (0, 0), 거리 1, 벽을 부순 상태 0
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // (N-1, M-1)에 도달했을 때 최단 거리 반환
            if (current.row == N - 1 && current.col == M - 1) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + rowDir[i];
                int nextCol = current.col + colDir[i];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    // 벽이 없을 때
                    if (map[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][current.wallBroken]) {
                        visited[nextRow][nextCol][current.wallBroken] = true;
                        queue.offer(new Point(nextRow, nextCol, current.dist + 1, current.wallBroken));
                    }
                    // 벽이 있고, 벽을 부수지 않은 상태일 때 벽을 부순다
                    if (map[nextRow][nextCol] == 1 && current.wallBroken == 0 && !visited[nextRow][nextCol][1]) {
                        visited[nextRow][nextCol][1] = true;
                        queue.offer(new Point(nextRow, nextCol, current.dist + 1, 1));
                    }
                }
            }
        }

        // 도달할 수 없을 때
        return -1;
    }
}
