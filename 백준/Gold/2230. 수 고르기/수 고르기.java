import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int start = 0; int end = 0;
		int min = Integer.MAX_VALUE;

		// 1 5 3
		while (end < N) {
			int a = arr[start];
			int b = arr[end];
			int result = Math.abs(a - b);
			if (result < min && result >= M) {
				if (result == M) {
					System.out.println(M);
					return;
				}
				min = result;
				start += 1;
			} 
			else if (result < M) {
				end += 1;
			} else {
				start += 1;
			}
		}
		System.out.println(min);
	}

}
