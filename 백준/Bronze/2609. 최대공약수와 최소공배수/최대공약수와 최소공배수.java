import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b); // 최대공약수

        // 최소공배수 계산
        int lcm = (a * b) / gcd;

        // 결과 출력
        System.out.println(gcd);
        System.out.println(lcm);

    }

        // 유클리드 호제법을 이용한 최대공약수 함수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
