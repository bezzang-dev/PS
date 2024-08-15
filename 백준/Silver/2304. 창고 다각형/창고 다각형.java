import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int start = Integer.MAX_VALUE;
        int last = 0;
        int[] arr = new int[1001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            start = Math.min(start, L);
            last = Math.max(last, L);
        }
        int answer = 0;
        int maxH = 0;
        for (int i = start; i <= last; i++) {
            answer += maxH = Math.max(arr[i], maxH);
        }
        
        maxH = 0;
        for (int i = last; i >= start; i--) {
            answer += maxH = Math.max(arr[i], maxH);
        }
        
        answer -= maxH * (last - start + 1);
        System.out.println(answer);
               
    }
}
