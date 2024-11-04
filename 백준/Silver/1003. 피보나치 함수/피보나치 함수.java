import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[41][2]; // 40까지 포함하므로 크기를 41로 설정합니다.
        
        // 초기화
        dp[0] = new long[]{1, 0}; // 0이 1번 출력되고, 1이 0번 출력됩니다.
        dp[1] = new long[]{0, 1}; // 0이 0번 출력되고, 1이 1번 출력됩니다.
        
        // dp 배열 계산
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        
        // 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num][0] + " " + dp[num][1]);
        }
    }
}