import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 13 2

        // 2 2 2 2 2 2 1 +1 1101
        // 2 2 2 2 2 2 2 1110
        // 4 4   4 2 + 2.  10000
        // 4 4 4 4
        // 8 8
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int bits = Integer.bitCount(N);
        if (bits <= K) {
            System.out.println(0);
            return;
        }

        while (Integer.bitCount(N) > K) {
            cnt++;
            N++;
        }

        System.out.println(cnt);


    }
}