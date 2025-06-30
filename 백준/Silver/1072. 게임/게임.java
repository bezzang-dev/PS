import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = (Y * 100) / X;
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = 2_000_000_000L;
        long answer = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long _X = X + mid;
            long _Y = Y + mid;
            long _Z = (_Y * 100) / _X;
            if (_Z > Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);

    }
}