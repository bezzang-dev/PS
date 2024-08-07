import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] paper;
    static int[] counts = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPapers(0, 0, N);

        System.out.println(counts[0]);
        System.out.println(counts[1]);
        System.out.println(counts[2]);

    }

    static void countPapers(int startRow, int startCol, int size) {
        if (check(startRow, startCol, size)) {
            counts[paper[startRow][startCol] + 1] += 1;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPapers(startRow + i * newSize, startCol + j * newSize, newSize);
            }
        }
    }

    static boolean check(int startRow, int startCol, int N) {
        int startValue = paper[startRow][startCol];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i + startRow][j + startCol] != startValue) {
                    return false;
                }
            }
        }
        return true;
    }
}
