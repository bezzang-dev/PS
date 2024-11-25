import java.util.*;
import java.io.*;

public class Main {
    static int[][] dir = {{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
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

        // 초기 특수 영양제 위치
        planted[N - 2][0] = 1;
        planted[N - 1][0] = 1;
        planted[N - 2][1] = 1;
        planted[N - 1][1] = 1;

        // 리브로수 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동 규칙 입력
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            deque.offer(new int[]{d, p});
        }

        // m년 동안 반복
        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int[][] nextPlanted = new int[N][N];

            // 1. 이동
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (planted[i][j] == 1) {
                        int nextRow = ((i + dir[current[0] - 1][0] * current[1]) + N * current[1]) % N;
                        int nextCol = ((j + dir[current[0] - 1][1] * current[1]) + N * current[1]) % N;
                        nextPlanted[nextRow][nextCol] = 1;
                    }
                }
            }
            planted = nextPlanted;

            // 2. 성장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (planted[i][j] == 1) {
                        for (int[] near : growList) {
                            int nextRow = i + near[0];
                            int nextCol = j + near[1];
                            if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] > 0) {
                                map[i][j]++;
                            }
                        }
                        map[i][j]++;
                    }
                }
            }

            // 3. 베어서 영양제 생성
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] >= 2 && planted[i][j] == 0) { // 영양제를 투입하지 않은 칸만
                        map[i][j] -= 2;
                        planted[i][j] = 1;
                    } else {
                        planted[i][j] = 0; // 기존 영양제 초기화
                    }
                }
            }
        }

        // 리브로수 높이 합 계산
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
}
