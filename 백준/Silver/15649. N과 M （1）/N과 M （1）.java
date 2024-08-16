import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N];
		arr = new int[M];
		backTracking(0);
		System.out.println(sb);
    }

	public static void backTracking(int length) {
		if (length == M) {
			for (int value : arr) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}
	
		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				arr[length] = i + 1;
				backTracking(length + 1);
				isVisited[i] = false;
			}
		}
	}
}
