import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 100) { // 1부터 99까지는 모든 수가 한수
            System.out.println(N);
            return;
        }

        int hansuCount = 99;

        for (int i = 100; i <= N; i++) {
            if (i == 1000) { // 1000은 한수가 아니므로 스킵
                continue;
            }

            int hundreds = i / 100;
            int tens = (i / 10) % 10;
            int units = i % 10;

            if ((tens - hundreds) == (units - tens)) {
                hansuCount++;
            }
        }

        System.out.println(hansuCount);
    }
}