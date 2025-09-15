import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            long d = y - x;
            int k = (int)Math.sqrt(d);

            if (d == k * k) {
                sb.append(2 * k - 1).append("\n");
            } else {
                long r = d - k*k;
                if (r <= k) {
                    sb.append(2 * k).append("\n");
                } else {
                    sb.append(2 * k + 1).append("\n");
                } 
            }
        }

        System.out.println(sb.toString());
    }
}