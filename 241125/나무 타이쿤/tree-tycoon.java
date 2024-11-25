import java.util.*;
import java.io.*;

public class Main {
    static int[][] dir = {
        {0, 1},    // → (1)
        {-1, 1},   // ↗ (2)
        {-1, 0},   // ↑ (3)
        {-1, -1},  // ↖ (4)
        {0, -1},   // ← (5)
        {1, -1},   // ↙ (6)
        {1, 0},    // ↓ (7)
        {1, 1}     // ↘ (8)
    };
    static int[][] growList = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static int N, M;
    static int[][] map;
    static int[][] planted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        planted = new int[N][N];

        // 초기 특수 영양제 위치 설정
        planted[N - 1][0] = 1;
        planted[N - 1][1] = 1;
        planted[N - 2][0] = 1;
        planted[N - 2][1] = 1;

        // 리브로수 높이 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동 규칙 입력
        int[][] moves = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            moves[i][0] = Integer.parseInt(st.nextToken()) - 1;
            moves[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시뮬레이션 시작
        for (int t = 0; t < M; t++) {
            int d = moves[t][0];
            int p = moves[t][1];

            // 1. 이동
            int[][] nextPlanted = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (planted[i][j] == 1) {
                        int nextRow = (i + dir[d][0] * p % N + N) % N;
                        int nextCol = (j + dir[d][1] * p % N + N) % N;
                        nextPlanted[nextRow][nextCol] = 1;
                    }
                }
            }
            planted = nextPlanted;

            // 2. 영양제 투입 및 성장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (planted[i][j] == 1) {
                        map[i][j] += 1;
                    }
                }
            }

            // 3. 대각선 성장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (planted[i][j] == 1) {
                        int cnt = 0;
                        for (int[] near : growList) {
                            int nextRow = i + near[0];
                            int nextCol = j + near[1];
                            if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
                                if (map[nextRow][nextCol] > 0) {
                                    cnt++;
                                }
                            }
                        }
                        map[i][j] += cnt;
                    }
                }
            }

            // 4. 새로운 영양제 생성 및 기존 영양제 제거
            int[][] newPlanted = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (planted[i][j] == 1) {
                        planted[i][j] = 0; // 기존 영양제 제거
                    } else if (map[i][j] >= 2) {
                        map[i][j] -= 2;
                        newPlanted[i][j] = 1; // 새로운 영양제 생성
                    }
                }
            }
            planted = newPlanted;
        }

        // 리브로수 높이의 합 계산
        int answer = 0;
        for (int[] row : map) {
            for (int h : row) {
                answer += h;
            }
        }
        System.out.println(answer);
    }
}
