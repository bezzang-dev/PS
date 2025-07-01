import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    static int answerHeight;
    static int answerCnt;
    static int minTime = Integer.MAX_VALUE;
    static int maxHeight = -1; // 최소 시간일 때의 땅 높이 (초기값: 불가능한 값)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int blocks = Integer.parseInt(st.nextToken());

        int minMapHeight = 257; // 맵의 최소 높이
        int maxMapHeight = -1;  // 맵의 최대 높이

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if (minMapHeight > val) {
                    minMapHeight = val;
                } else if (maxMapHeight < val) {
                    maxMapHeight = val;
                }
            }
        }

        for (int targetHeight = maxMapHeight; targetHeight >= minMapHeight; targetHeight--) {
            int currentBlock = blocks;
            int time = 0;

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    int diff = map[r][c] - targetHeight;
                    if (diff > 0) { // 블록 제거
                        time += diff * 2;
                        currentBlock += diff;
                    } else if (diff < 0) {
                        time += Math.abs(diff);
                        currentBlock -= Math.abs(diff);
                    }
                }
            }

            if (currentBlock >= 0) {
                if (time < minTime) {
                    minTime = time;
                    maxHeight = targetHeight;
                }
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }
}