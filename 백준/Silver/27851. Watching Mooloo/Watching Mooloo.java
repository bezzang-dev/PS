import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        if (N == 0) {
            System.out.println(0);
            return;
        }

        long totalCost = 1 + K;
        for (int i = 1; i < N; i++) {
            long gapCost = arr[i] - arr[i-1];
            long newSubCost = 1 + K;

            totalCost += Math.min(gapCost, newSubCost);
        }
        
        System.out.println(totalCost);
    }
}