import java.util.*;

public class Solution {
    public int solution(int[][] points, int[][] routes) {
        int n = points.length;
        int x = routes.length;
        Map<String, Integer> positionCount = new HashMap<>();

        // Map to store point number to coordinates mapping
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pointMap.put(i + 1, points[i]);
        }

        // For each robot
        for (int robot = 0; robot < x; robot++) {
            int time = 0;
            int[] currentPos = pointMap.get(routes[robot][0]);

            // For each movement in the route
            for (int i = 1; i < routes[robot].length; i++) {
                int[] nextPos = pointMap.get(routes[robot][i]);

                // Move along r coordinate
                int r1 = currentPos[0];
                int r2 = nextPos[0];
                int c = currentPos[1];

                int rStep = (r1 < r2) ? 1 : -1;
                while (r1 != r2) {
                    String key = time + "-" + r1 + "-" + c;
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                    r1 += rStep;
                    time++;
                }

                // Move along c coordinate
                int c1 = c;
                int c2 = nextPos[1];
                int cStep = (c1 < c2) ? 1 : -1;
                while (c1 != c2) {
                    String key = time + "-" + r1 + "-" + c1;
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                    c1 += cStep;
                    time++;
                }

                currentPos = nextPos;
            }

            // Record the last position
            String key = time + "-" + currentPos[0] + "-" + currentPos[1];
            positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
        }

        int dangerousSituations = 0;
        for (int count : positionCount.values()) {
            if (count >= 2) {
                dangerousSituations++;
            }
        }

        return dangerousSituations;
    }
}
