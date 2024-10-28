import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(s.nextToken());
        int K = Integer.parseInt(s.nextToken());

        int max = 100001;
        int[] time = new int[max];  // 각 노드에 도달하는 최소 시간을 저장
        int[] ways = new int[max];  // 최소 시간에 각 노드에 도달하는 방법의 수를 저장
        Arrays.fill(time, -1);      // 방문하지 않은 상태를 -1로 초기화
        time[N] = 0;                // 시작 지점의 시간은 0
        ways[N] = 1;                // 시작 지점에 도달하는 방법은 1가지

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int[] nextPoints = {current - 1, current + 1, current * 2};
            for (int next : nextPoints) {
                if (next >= 0 && next < max) {
                    // 노드가 방문되지 않았을 때
                    if (time[next] == -1) {
                        time[next] = time[current] + 1;
                        ways[next] = ways[current];
                        queue.offer(next);
                    }
                    // 최소 시간에 노드에 도달할 수 있을 때
                    else if (time[next] == time[current] + 1) {
                        ways[next] += ways[current];
                    }
                }
            }
        }

        System.out.println(time[K]);
        System.out.println(ways[K]);
    }
}
