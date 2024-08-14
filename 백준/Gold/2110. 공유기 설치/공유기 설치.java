import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int numOfHouses;
	static int numOfDevices;
	static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		numOfHouses = Integer.parseInt(st.nextToken());
		numOfDevices = Integer.parseInt(st.nextToken());
		map = new int[numOfHouses];
		for (int i = 0; i < numOfHouses; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(map);

		int left = 1;
		int right = map[numOfHouses - 1] - map[0];
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(mid)) {
				left = mid + 1;
				answer = mid;
			} else {
				right = mid - 1;
			}			
		}
		System.out.println(answer);
    }

	public static boolean check(int mid) {
		int cnt = 1;
		int last = map[0];
		for (int i = 1; i < numOfHouses; i++) {
			if (map[i] - last >= mid) {
				cnt+=1;
				last = map[i];
			}
		}
		return cnt >= numOfDevices;
	}

}

// 1 2 4 8 9