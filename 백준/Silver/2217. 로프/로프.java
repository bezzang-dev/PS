import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);

        int cnt = 1;
        int maxWeight = ropes[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            int current = ropes[i];
            int newWeight = current * (cnt + 1);
            if (newWeight > maxWeight) { // 하나 늘렸을 때 더 들 수 있으면
                maxWeight = newWeight;
                
            }
            cnt += 1;
        }

        System.out.println(maxWeight);


    }
}

/**
 * 18 19 20
 * 54
 *
 * 1 10 30
 * 30
 */