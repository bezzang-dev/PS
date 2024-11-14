import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int curRow;
    static int curCol;
    static int curDir;
    static int[] rowDir = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] colDir = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        curRow = Integer.parseInt(st.nextToken());
        curCol = Integer.parseInt(st.nextToken());
        curDir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            // Step 1: 현재 위치 청소
            if (!visited[curRow][curCol]) { // 방문하지 않은 경우만 청소
                visited[curRow][curCol] = true;
                answer++;
            }

            boolean moved = false;

            // Step 2: 주변 4칸을 확인
            for (int i = 0; i < 4; i++) {
                curDir = (curDir + 3) % 4; // 반시계 방향으로 회전
                int nextRow = curRow + rowDir[curDir];
                int nextCol = curCol + colDir[curDir];

                // 청소되지 않은 빈 칸이 있다면 이동
                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if (map[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                        curRow = nextRow;
                        curCol = nextCol;
                        moved = true;
                        break;
                    }
                }
            }

            // 이동하지 못했다면
            if (!moved) {
                // Step 3: 후진
                int backDir = (curDir + 2) % 4;
                int backRow = curRow + rowDir[backDir];
                int backCol = curCol + colDir[backDir];

                // 후진할 수 있으면 후진
                if (backRow >= 0 && backRow < N && backCol >= 0 && backCol < M && map[backRow][backCol] == 0) {
                    curRow = backRow;
                    curCol = backCol;
                } else {
                    // 후진할 수 없으면 작동 멈춤
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
