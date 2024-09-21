import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
			arr[i - 1] = Integer.parseInt(st.nextToken());
		}

		int[] inc = new int[N];
		Arrays.fill(inc, 1);

		int[] dec = new int[N];
		Arrays.fill(dec, 1);

		for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

		for (int i = N - 2; i >= 0; i--) { // 뒤에서 앞으로
			for (int j = N - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					dec[i] = Math.max(dec[i], dec[j] + 1);
				}
			}
		}
		
		int maxLength = 0;
		for (int i = 0; i < N; i++){
			maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
		}

		System.out.println(maxLength);

	}

}
