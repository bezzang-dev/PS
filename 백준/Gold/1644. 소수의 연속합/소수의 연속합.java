import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i<= n; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= n ; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < n + 1; i++) {
			if (isPrime[i])
				primeList.add(i);
		}

		int start = 0;
		int end = 0;
		int current = 0;
		int answer = 0;
		while (true) {
		
			if (current >= n) {
				current -= primeList.get(start);
				start += 1;
			} else if (end == primeList.size()) {
				break;
			} else {
				current += primeList.get(end);
				end += 1;
			} 

			if (current == n) {
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}
