import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] paper;
    static int[] counts = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int currentSum = 0;
        int left = 0, right = 0;
        while (true) {
            if (currentSum >= target) {
                currentSum -= arr[left++];
            } else if (right == N) {
                break;
            } else {
                currentSum += arr[right++];
            }

            if (currentSum == target) {
                answer++;
            }
        }

        /**
         *     while (right != N) {
            if (currentSum >= target) {
                currentSum -= arr[left++];
            } else {
                currentSum += arr[right++];
            }
            if (currentSum == target) {
                answer++;
            }
        }

        System.out.println(answer);
         */
        System.out.println(answer);
    
    }
}

/**
 * 4 2
    1 1 1 1
 */