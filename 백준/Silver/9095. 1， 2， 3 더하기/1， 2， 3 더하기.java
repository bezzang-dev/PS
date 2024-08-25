import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int target = Integer.parseInt(br.readLine());
			int answer = 0;
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(1);
			q.offer(2);
			q.offer(3);
			while (!q.isEmpty()) {
				int current = q.poll();
				if (current == target) {
					answer += 1;
					continue;
				}
				if (current + 1 <= target) {
					if (current + 1 == target) {
						answer += 1;
						continue;
					} else {
						q.offer(current + 1);
					}
				} if (current + 2 <= target) {
					if (current + 2 == target) {
						answer += 1;
						continue;
					} else {
						q.offer(current + 2);
					}
				} if (current + 3 <= target) {
					if (current + 3 == target) {
						answer += 1;
						continue;
					} else {
						q.offer(current + 3);
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}

}
