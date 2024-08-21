import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int n;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;

			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			List<Integer> comb = new ArrayList<>();

			backTracking(comb, 0, 6);

			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void backTracking(List<Integer> comb, int start, int count) {
		if (count == 0) {
			for (int value : comb) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n - count; i++) {
			comb.add(arr[i]);
			backTracking(comb, i + 1, count - 1);
			comb.remove(comb.size() - 1);
		}
	}

}
