import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] papers = {0, 5, 5, 5, 5, 5};

	static int[][] map = new int[10][10];

	static int answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());			
			}
		}

		backTracking(0, 0, 0);

		if (answer == Integer.MAX_VALUE) 
			System.out.println(-1);	
		else
			System.out.println(answer);

	}

	static void backTracking(int row, int col, int cnt) {
		if (row >= 9 && col > 9) {
			answer = Math.min(cnt, answer);
			return;
		}
		if (cnt >= answer) {
			return;
		}
		if (col > 9) {
			backTracking(row + 1, 0, cnt);
			return;
		}

		if (map[row][col] == 1) {
			for (int size = 5; size >= 1; size--) {
				if (papers[size] > 0 && isAttach(row, col, size)) {
					attach(row, col, size, 0);
					papers[size] -= 1;
					backTracking(row, col + 1, cnt + 1);
					attach(row, col, size, 1);
					papers[size] += 1;
					
				}
			}
		} else {
			backTracking(row, col + 1, cnt);
		}
	}

	static boolean isAttach(int row, int col, int size) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10)
					return false;
				if (map[i][j] != 1)
					return false;
			}
		}
		return true;
	}

	static void attach(int row, int col, int size, int state) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				map[i][j] = state;
			}
		}
	}

}