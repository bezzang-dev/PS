import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Point> houses = new ArrayList<>();
    static List<Point> chickenShops = new ArrayList<>();
    static Point[] selected; // 선택된 M개의 치킨집을 담을 배열
    static int minCityChickenDistance = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 집과 치킨집의 좌표를 각각 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    houses.add(new Point(i, j));
                } else if (type == 2) {
                    chickenShops.add(new Point(i, j));
                }
            }
        }

        selected = new Point[M];
        // 백트래킹을 이용해 M개의 치킨집 조합 찾기 시작
        findCombinations(0, 0);

        System.out.println(minCityChickenDistance);

    }

    public static void findCombinations(int start, int depth) {
        if (depth == M) {
            calculateCityDistance();
            return;
        }
        for (int i = start; i < chickenShops.size(); i++) {
            selected[depth] = chickenShops.get(i);
            findCombinations(i + 1, depth + 1);

        }
    }

    public static void calculateCityDistance() {
        int currentCityDistance = 0;
        for (Point house : houses) {
            int minHouseChickenDistance = Integer.MAX_VALUE;
            for (Point chicken : selected) {
                int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                minHouseChickenDistance = Math.min(minHouseChickenDistance, distance);
            }
            currentCityDistance += minHouseChickenDistance;
        }
        // 전체 최솟값 업데이트
        minCityChickenDistance = Math.min(minCityChickenDistance, currentCityDistance);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}