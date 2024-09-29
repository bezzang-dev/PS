import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	static int[] rowDir = {1, -1, 0, 0};
	static int[] colDir = {0, 0, 1, -1};
	static int[][] map;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxRow = Integer.parseInt(st.nextToken());
		int maxCol = Integer.parseInt(st.nextToken());

		map = new int[maxRow][maxCol];
		int[][] distance = new int[maxRow][maxCol];
		Queue<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < maxRow; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < maxCol; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					dq.offer(new int[]{i, j, 0});
				}
			}
		}

		while(!dq.isEmpty()) {
			int[] current = dq.poll();
			int currentDistance = current[2];
			distance[current[0]][current[1]] = currentDistance;
			for (int i = 0; i < 4; i++) {
				int nextRow = current[0] + rowDir[i];
				int nextCol = current[1] + colDir[i];
				if (0 <= nextRow && nextRow < maxRow && 0 <= nextCol && nextCol < maxCol) {
					if (map[nextRow][nextCol] == 1 && distance[nextRow][nextCol] == 0) {
						map[nextRow][nextCol] = -1; // 방문 표시
						dq.offer(new int[]{nextRow, nextCol, currentDistance + 1});
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				if (map[i][j] == 1) { // 도달할 수 없을 때
					sb.append(-1).append(" ");
				} else {

					sb.append(distance[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
