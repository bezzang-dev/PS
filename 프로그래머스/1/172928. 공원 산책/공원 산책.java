class Solution {
    public int[] solution(String[] park, String[] routes) {
        int width = park[0].length();
        int height = park.length;
        char[][] map = new char[height][width];
        int startRowIdx = 0;
        int startColIdx = 0;
        for (int i = 0; i < height; i++) {
            map[i] = park[i].toCharArray();
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 'S') {
                    startRowIdx = i;
                    startColIdx = j;
                }
            }
        }
        for (String route : routes) {
            String[] splited = route.split(" ");
            String dir = splited[0];
            int distance = Integer.parseInt(splited[1]);
            boolean isBlocked = false;
            int backupRow = startRowIdx;
            int backupCol = startColIdx;
            switch (dir) {
                case "E":
                    while (distance > 0) {
                        if (startColIdx >= width - 1 || map[startRowIdx][startColIdx + 1] == 'X') {
                            isBlocked = true;
                            break;
                        }
                        distance -= 1;
                        startColIdx += 1;
                    }
                    break;
                case "N":
                    while (distance > 0) {
                        if (startRowIdx <= 0 || map[startRowIdx - 1][startColIdx] == 'X') {
                            isBlocked = true;
                            break;
                        }
                        distance -= 1;
                        startRowIdx -= 1;
                    }
                    break;
                case "W":
                    while (distance > 0) {
                        if (startColIdx <= 0 || map[startRowIdx][startColIdx - 1] == 'X') {
                            isBlocked = true;
                            break;
                        }
                        distance -= 1;
                        startColIdx -= 1;
                    }
                    break;
                case "S":
                    while (distance > 0) {
                        if (startRowIdx >= height - 1 || map[startRowIdx + 1][startColIdx] == 'X') {
                            isBlocked = true;
                            break;
                        }
                        distance -= 1;
                        startRowIdx += 1;
                    }
                    break;

            }
            if (isBlocked) {
                startRowIdx = backupRow;
                startColIdx = backupCol;
            }
        }
        return new int[]{startRowIdx, startColIdx};
    }
}