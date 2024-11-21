import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long M = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
            M += numbers[i];
        }

        HashSet<Long> sumSet = new HashSet<>();

        int totalSubsets = 1 << N; // 2^N subsets
        for (int mask = 1; mask < totalSubsets; mask++) {
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += numbers[i];
                }
            }
            sumSet.add(sum);
        }

        long count = 0;
        for (long sum : sumSet) {
            if (sum >= 1 && sum <= M) {
                count++;
            }
        }

        System.out.println(M - count);
    }
}
