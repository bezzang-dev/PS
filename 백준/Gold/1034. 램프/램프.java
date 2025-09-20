import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static char[][] map;
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

        int k = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int zeroCnt = countZero(i);
            if (k < zeroCnt) {
                continue;
            } else if ((k - zeroCnt) % 2 != 0) {
                continue;
            }

            String tmp = "";
            for (int j = 0; j < M; j++) {
                tmp += map[i][j];
            }

            answer = Math.max(answer, checkSame(tmp));
        }
        System.out.println(answer);

    }

    public static int checkSame(String sentence) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String tmp = "";
            for (int j = 0; j < M; j++) {
                tmp += map[i][j];
            }
            if (sentence.equals(tmp)) cnt++;
        }
        return cnt;
    }

    public static int countZero(int row) {
        int cnt = 0;
        char[] array = map[row];
        for (char c : array) {
            if (c == '0') {
                cnt++;
            }
        }
        
        return cnt;
    }
}