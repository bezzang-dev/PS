import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nextMin = new int[3];
		int[] nextMax = new int[3];
		int[] currentMin = new int[3];
		int[] currentMax = new int[3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			currentMax[i] = Integer.parseInt(st.nextToken());
			currentMin[i] = currentMax[i];
		}

		for (int i = 1; i < n; i++) {
			int[] points = new int[3];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				points[j] = Integer.parseInt(st.nextToken());
			}
			nextMin[0] = points[0] + Math.min(currentMin[0], currentMin[1]);
			nextMin[1] = points[1] + Math.min(Math.min(currentMin[0], currentMin[1]), currentMin[2]);
			nextMin[2] = points[2] + Math.min(currentMin[1], currentMin[2]);

			nextMax[0] = points[0] + Math.max(currentMax[0], currentMax[1]);
			nextMax[1] = points[1] + Math.max(Math.max(currentMax[0], currentMax[1]), currentMax[2]);
			nextMax[2] = points[2] + Math.max(currentMax[1], currentMax[2]);

			System.arraycopy(nextMax, 0, currentMax, 0, 3);
            System.arraycopy(nextMin, 0, currentMin, 0, 3);

		}
		
		int maxScore = Math.max(Math.max(currentMax[0], currentMax[1]), currentMax[2]);
        int minScore = Math.min(Math.min(currentMin[0], currentMin[1]), currentMin[2]);

        System.out.println(maxScore + " " + minScore);

	}
}
