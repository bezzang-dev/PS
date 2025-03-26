import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < K; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        for (int i = K; i < N; i++) {
            currentSum += arr[i] - arr[i - K];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);

        // 10 2
        // 3 -2 -4 -9 0 3 7 13 8 -3

    }
}