import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		sb.append((int) Math.pow(2, n) - 1).append("\n");

		hanoi(n, 1, 2, 3);

		System.out.println(sb);

	}

	static void hanoi(int n, int start, int mid, int end) {
		if (n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}

		hanoi(n - 1, start, end, mid);
		sb.append(start).append(" ").append(end).append("\n");
		hanoi(n - 1, mid, start, end);
	}
}