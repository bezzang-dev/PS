import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] cross = new long[n + 1];
        long[] left = new long[n];
        long[] right = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cross[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            left[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            right[i] = Long.parseLong(st.nextToken());
        }

        long[] leftSum = new long[n + 1];
        leftSum[1] = 0;
        for (int i = 2; i <= n; i++) {
            leftSum[i] = leftSum[i - 1] + left[i - 1];
        }

        long[] rightSum = new long[n + 2];
        rightSum[n] = 0;
        for (int i = n - 1; i >= 1; i--) {
            rightSum[i] = rightSum[i + 1] + right[i];
        }

        long minDistance = Long.MAX_VALUE;
        int bestCrosswalkIndex = 0;

        for (int i = 1; i <= n; i++) {
            long currentDistance = leftSum[i] + cross[i] + rightSum[i];
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                bestCrosswalkIndex = i;
            }
        }

        System.out.println(bestCrosswalkIndex + " " + minDistance);
    }
}