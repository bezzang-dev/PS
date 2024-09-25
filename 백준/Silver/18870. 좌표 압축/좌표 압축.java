import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] arr;

	static int N;

    public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] original = new int[N];
			int[] sorted = new int[N];
			
			for (int i = 0; i < N; i++) {
				original[i] = Integer.parseInt(st.nextToken());
				sorted[i] = original[i];
			}
			
			Arrays.sort(sorted);
			
			Map<Integer, Integer> compressionMap = new HashMap<>();
			
			int rank = 0;
			for (int i = 0; i < N; i++) {
				if (!compressionMap.containsKey(sorted[i])) {
					compressionMap.put(sorted[i], rank++);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(compressionMap.get(original[i])).append(" ");
			}
			
			System.out.println(sb);
		}
		
	static int binarySearch(int value) {
		int start = 0;
		int end = N - 1;
		int count = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (value > arr[mid]) {
				start = mid + 1;
			} else if (value < arr[mid]){
				end = mid - 1;
			}
			else {
				return mid;
			}
		}
		return count;
	}
}