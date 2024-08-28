import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static boolean[] isVisited;
	static int[][] board;
	static int n;
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		isVisited = new boolean[n];
		for (int i = 0 ; i < n; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backTracking(0, 0);
		System.out.println(min);

	}

	static void backTracking(int idx, int count) {
		if (count == n / 2) {
			calculate();
			return;
		}
		for (int i = idx; i < n; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				backTracking(i + 1, count + 1);
				isVisited[i] = false;
			}
		}
	}

	static void calculate() {
		int teamStart = 0;
		int teamLink = 0;
		for (int i = 0 ; i < n; i++) {
			for (int j = 0 ; j < n; j++) {
				if (isVisited[i] && isVisited[j]) {
					teamStart += board[i][j];
				}
				if (!isVisited[i] && !isVisited[j]) {
					teamLink += board[i][j];
				}
				
			}
		}	
		int diff = Math.abs(teamStart - teamLink);
		min = Math.min(diff, min);	
	}
}