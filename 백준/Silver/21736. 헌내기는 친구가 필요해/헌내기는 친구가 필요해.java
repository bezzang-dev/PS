import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visited; // 방문 여부를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M]; // visited 배열 초기화

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    startRow = i; 
                    startCol = j;
                }
            }
        }

        int answer = 0;
        int[] dirX = {1, -1, 0, 0}; // 상하좌우 이동을 위한 델타 값
        int[] dirY = {0, 0, 1, -1};
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        // 도연이의 시작 위치를 큐에 넣고 방문 처리
        deque.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true; 

        while (!deque.isEmpty()) {
            int[] current = deque.pop();
            int curRow = current[0];
            int curCol = current[1];

            // 현재 위치가 'P'라면 사람 수 증가
            if (map[curRow][curCol] == 'P') {
                answer += 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = dirX[i] + curRow;
                int nextCol = dirY[i] + curCol;
                
                // 다음 위치가 캠퍼스 범위 내에 있고, 벽이 아니며, 아직 방문하지 않았다면
                if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M && !visited[nextRow][nextCol]) {
                    if (map[nextRow][nextCol] != 'X') { // 벽이 아니면 이동 가능
                        deque.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true; // 방문 처리
                    }
                }
            }
        }
        
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }
}