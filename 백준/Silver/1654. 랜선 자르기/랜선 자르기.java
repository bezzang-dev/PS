import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = Integer.MAX_VALUE;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            long count = 0;
            for (int value : arr) {
                count += (value / mid);
            }
            if (count < N) { // 더 잘라야 하면
                end = mid - 1;
            } else { // 더 크게 자를 수 있다
                start = mid + 1;
                answer = mid;
            }

        }

        System.out.println(answer);

    }
}
