class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int[] arr = new int[10000];
        arr[0] = k;
        int idx = 1;
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = (k * 3) + 1;
            }   
            arr[idx] = k;
            idx += 1;
        }
        
        int maxRange = idx;
        int answerIdx = 0;
        for (int[] range : ranges) {
            int open = range[0];
            int close = range[1];
            double answ = 0;
            if (open == 0 && close == 0) {
                for (int i = 1; i < maxRange; i++) {
                    answ += calcSquare(i - 1, i, arr[i - 1]) + calcTriangle(i - 1, arr[i - 1], i, arr[i]);
                }
            }
            else {
                close = maxRange + close;
                if (open >= close) {
                    answ = -1;
                } else {
                for (int i = open + 1; i < close; i++) {
                    answ += calcSquare(i - 1, i, arr[i - 1]) + calcTriangle(i - 1, arr[i - 1], i, arr[i]);
                    }  
                }
   
            }
            answer[answerIdx] = answ;
            answerIdx += 1;
        }
        
        return answer;
    }
    
    double calcSquare(int x1, int x2, int y1) {
        double width = x2 - x1;
        double height = y1;
        return width * height;
    }
    
    double calcTriangle(int x1, int y1, int x2, int y2) {
        double width = x2 - x1;
        double height = y2 - y1;
        return width * height / 2;
    }
}