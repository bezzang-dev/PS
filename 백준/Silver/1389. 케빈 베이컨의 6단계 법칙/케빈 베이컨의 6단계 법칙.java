import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] arrayList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arrayList[A].add(B);
            arrayList[B].add(A);
        }

        int minKevinBacon = Integer.MAX_VALUE;
        int answer = -1;
        
        for (int i = 1; i <= N; i++) {            
            int[] distances = new int[N + 1];
            Arrays.fill(distances, -1);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            distances[i] = 0;

            int cnt = 0;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int friend : arrayList[current]) {
                    if (distances[friend] == -1) {
                        distances[friend] = distances[current] + 1;
                        queue.offer(friend);
                    }
                }
            }

            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += distances[j];
            }
            if (total < minKevinBacon) {
                minKevinBacon = total;
                answer = i;
            } else if (total == minKevinBacon) {
                answer = Math.min(answer, i);
            }
        }

        System.out.println(answer);
    
    }
}