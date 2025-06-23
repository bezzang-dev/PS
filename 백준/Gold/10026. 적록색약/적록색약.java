import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] isVisited;
    static char[][] arr1; // 색맹
    static char[][] arr2; // 정상인

    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    static int N;

    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N][N];
        arr1 = new char[N][N];
        arr2 = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                arr2[i][j] = c;
                if (c == 'R') {
                    arr1[i][j] = 'G'; // 적록색약은 R을 G로 본다
                } else {
                    arr1[i][j] = c;
                }
            }
        }
        int cnt1 = 0;
        grid = arr1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    DFS(arr1[i][j], i, j);
                    cnt1++;
                }
            }
        }

        int cnt2 = 0; // 일반인
        isVisited = new boolean[N][N];
        grid = arr2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    DFS(arr2[i][j], i, j);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt2 + " " + cnt1);
    }

    public static void DFS(char c, int row, int col) {
        isVisited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirX[i];
            int nextCol = col + dirY[i];
            if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
                if (!isVisited[nextRow][nextCol]) {
                    if (grid[nextRow][nextCol] == c) {
                        DFS(c, nextRow, nextCol);
                    }
                }
            }
        }
    }
}