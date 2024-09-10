import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N + 1];
		int numOfGood = Integer.parseInt(st.nextToken());

		//  먼저풀어야함 나중에 풀어야함
		List<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < numOfGood; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			arr[first].add(after);
			indegree[after] += 1;
		}

		//  진입 차수 (indegree) == 0인 애들 부터 삽입
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int current = pq.poll();
			sb.append(current).append(" ");
			for (int after : arr[current]) {
				indegree[after] -= 1;
				if (indegree[after] == 0) {
					pq.offer(after);
				}
			}
		}
		System.out.println(sb);
	}

}
