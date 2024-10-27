import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] dp = new long[100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int j = 3; j < 100; j++) {
            dp[j] = dp[j - 3] + dp[j - 2];
        }

        for (int i = 0; i < num; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N < 4) {
                System.out.println(dp[N - 1]);
            } else {
                System.out.println(dp[N - 1]);
            }
            
        }

    }

}
