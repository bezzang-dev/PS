import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];
        arr = new int[M];

        backTracking(1, 0);

        System.out.println(sb);
    }

    static void backTracking(int num, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = num; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[cnt] = i;
                backTracking(i + 1, cnt + 1);
                isVisited[i] = false;
            }
        }
    }
}
