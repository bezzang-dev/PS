import java.util.*;
import java.io.*;

public class Main {

    static class Candies {
        int[] redCandy, blueCandy;
        int count;

        public Candies(int[] redCandy, int[] blueCandy, int count) {
            this.redCandy = redCandy;
            this.blueCandy = blueCandy;
            this.count = count;
        }
    }

    static int[] rowDir = {1, -1, 0, 0};
    static int[] colDir = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][][][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][M][N][M];

        int[] red = new int[2];
        int[] blue = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                    map[i][j] = '.';
                }
            }
        }

        Queue<Candies> queue = new ArrayDeque<>();
        queue.offer(new Candies(red, blue, 0));
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while (!queue.isEmpty()) {
            Candies curCandies = queue.poll();

            if (curCandies.count >= 10) {
                System.out.println(-1);
                return;
            }

            int[] curRed = curCandies.redCandy;
            int[] curBlue = curCandies.blueCandy;

            for (int i = 0; i < 4; i++) {
                int nextRedRow = curRed[0], nextRedCol = curRed[1];
                boolean isRedHole = false;
                while (map[nextRedRow + rowDir[i]][nextRedCol + colDir[i]] != '#') {
                    nextRedRow += rowDir[i];
                    nextRedCol += colDir[i];
                    if (map[nextRedRow][nextRedCol] == 'O') {
                        isRedHole = true;
                        break;
                    }
                }

                int nextBlueRow = curBlue[0], nextBlueCol = curBlue[1];
                boolean isBlueHole = false;
                while (map[nextBlueRow + rowDir[i]][nextBlueCol + colDir[i]] != '#') {
                    nextBlueRow += rowDir[i];
                    nextBlueCol += colDir[i];
                    if (map[nextBlueRow][nextBlueCol] == 'O') {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) continue;
                if (isRedHole) {
                    System.out.println(curCandies.count + 1);
                    return;
                }

                if (nextRedRow == nextBlueRow && nextRedCol == nextBlueCol) {
                    // 1, -1, ,1, -1
                    if (i == 0) { // 아래로 이동
                        if (curRed[0] < curBlue[0]) nextRedRow -= 1;
                        else nextBlueRow -= 1;
                    } else if (i == 1) { // 위로 이동
                        if (curRed[0] < curBlue[0]) nextBlueRow += 1;
                        else nextRedRow += 1;
                    } else if (i == 2) { // 오른쪽
                        if (curRed[1] < curBlue[1]) nextRedCol -= 1;
                        else nextBlueCol -= 1;
                    } else if (i == 3) { // 왼쪽
                        if (curRed[1] < curBlue[1]) nextBlueCol += 1;
                        else nextRedCol += 1;
                    }
                }

                if (!visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol]) {
                    visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol] = true;
                    queue.offer(new Candies(new int[]{nextRedRow, nextRedCol}, new int[]{nextBlueRow, nextBlueCol}, curCandies.count + 1));
                }
            }
        }

        System.out.println(-1);
    }
}
