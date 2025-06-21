import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N <= 2) {
            System.out.println(N);
            return;
        }

        int left = 0;
        int maxLength = 0;
        int[] cnt = new int[10];
        int distinct = 0;
        for (int right = 0; right < N; right++) {
            int current = arr[right];
            if (cnt[current] < 1) {
                distinct += 1;
            }
            cnt[current]++;

            while (distinct > 2) {
                int leftFruit = arr[left];
                cnt[leftFruit]--;
                if (cnt[leftFruit] < 1) {
                    distinct--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    
    }
}