class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = n / w;
        if (n % w != 0) height++;
        
        int[][] arr = new int[height][w];
        
        boolean goRight = true;
        int counter = 1;
        for (int h = height - 1; h >= 0; h--) {
            if (goRight) {
                for (int i = 0; i < w; i++) {
                    if (counter > n) break;
                    arr[h][i] = counter++;
                }
                goRight = false;
            } else {
                for (int i = w - 1; i >= 0; i--) {
                    if (counter > n) break;
                    arr[h][i] = counter++;
                }
                goRight = true;
            }
        }
        
        int targetH = 0;
        int targetW = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == num) {
                    targetH = i;
                    targetW = j;
                    break;
                }
            }
        }
        
        for (int i = 0; i <= targetH; i++) {
            if (arr[i][targetW] != 0) {
                answer++;
            }
        }
        
        
        return answer;
    }
}