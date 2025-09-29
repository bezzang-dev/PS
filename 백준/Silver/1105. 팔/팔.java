import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();
        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        for (int i = 0; i < L.length(); i++) {
            int Lval = L.charAt(i) - '0';
            int Rval = R.charAt(i) - '0';
            if (Lval == Rval && Lval == 8) {
                cnt++;
            } else if (Lval != Rval) {
                break;
            }
        }
        System.out.println(cnt);
    }
}