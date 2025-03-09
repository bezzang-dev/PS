import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Seat implements Comparable<Seat> {

        int row, col, numOfFriends, numOfEmpty;

        public Seat(int row, int col, int numOfFriends, int numOfEmpty) {
            this.row = row;
            this.col = col;
            this.numOfFriends = numOfFriends;
            this.numOfEmpty = numOfEmpty;
        }

        @Override
        public int compareTo(Seat o) {
            if (this.numOfFriends != o.numOfFriends) { // 좋아하는 학생 수
                return -(this.numOfFriends - o.numOfFriends); // 음수 리턴이면 현재 객체가 더 작고, 양수 리턴이면 다른 객체가 더 큼
            }

            if (this.numOfEmpty != o.numOfEmpty) { // 비어있는 자리가 더 많은 경우
                return -(this.numOfEmpty - o.numOfEmpty);
            }

            if (this.row != o.row) {
                return this.row - o.row; // 더 작은 경우를 리턴해야 하므로
            }

            return this.col - o.col;

        }
    }

    static int[][] map;

    static int[] dirX = {1, -1, 0, 0};

    static int[] dirY = {0, 0, 1, -1};

    static int[] students;

    static Map<Integer, Set<Integer>> preferences;

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        students = new int[N * N];
        map = new int[N][N];
        preferences = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            preferences.putIfAbsent(studentNum, new HashSet<>());
            students[i] = studentNum;
            for (int j = 0; j < 4; j++) {
                int value = Integer.parseInt(st.nextToken());
                preferences.get(studentNum).add(value);
            }
        }

        for (int i = 0; i < N * N; i++) {
            Seat seat = findSeat(students[i]);
            map[seat.row][seat.col] = students[i];
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = findNumOfFriend(map[i][j], i, j);
                if (count > 0) {
                    answer += (int) Math.pow(10, count - 1);
                }
            }
        }

        System.out.println(answer);

    }

    static boolean isOver(int x, int y) {
        return x < 0 || map.length <= x || y < 0 || map.length <= y;
    }

    static int findNumOfFriend(int student, int row, int col) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextRow = dirX[i] + row;
            int nextCol = dirY[i] + col;

            if (!isOver(nextRow, nextCol)) {
                if (preferences.get(student).contains(map[nextRow][nextCol])) {
                    count++;
                }
            }
        }
        return count;
    }

    static int findNumOfEmpty(int row, int col) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextRow = dirX[i] + row;
            int nextCol = dirY[i] + col;

            if (!isOver(nextRow, nextCol)) {
                if (map[nextRow][nextCol] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static Seat findSeat(int student) { // 현재 위치에서 빈 자리를 찾는다.

        Seat seat = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) continue;

                Seat cur = new Seat(i, j, findNumOfFriend(student, i, j), findNumOfEmpty(i, j));

                if (seat == null) {
                    seat = cur;
                    continue;
                }
                if (seat.compareTo(cur) > 0) {
                    seat = cur;
                }
            }
        }
        return seat;
    }
}