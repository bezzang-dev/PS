import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int length;
	static int[][] paper;
	static int answer;
	static int numOfBlue = 0;
	static int numOfWhite = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine());
		paper = new int[length][length];
		for (int i = 0; i < length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < length; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cutting(0, 0, length);
	
		System.out.println(numOfWhite);
		System.out.println(numOfBlue);

	}

	static void cutting(int startRow, int startCol, int length) {
		if (check(startRow, startCol, length)) {
			if (paper[startRow][startCol] == 1) {
				numOfBlue += 1;
			} else {
				numOfWhite += 1;
			}
			return;
		}

		int newLength = length / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				cutting(startRow + i * newLength, startCol + j * newLength, newLength);
			}
		}

	}

	static boolean check(int row, int col, int length) {
		int start = paper[row][col];
		for (int i = row; i < row + length; i++) {
			for (int j = col; j < col + length; j++) {
				if (start != paper[i][j])
					return false;
			}
		}
		return true;
	}
}
