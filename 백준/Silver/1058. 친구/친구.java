import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int mostFriends = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //   1    <->   2  <->    3     <->   4    <-> 5

        int n = Integer.parseInt(st.nextToken());

        boolean[][] friends = new boolean[n][n];
        for (int i = 0 ; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == 'Y') {
                    friends[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (friends[i][j] == true) {
                    tmp++;
                } else {
                    for (int k = 0; k < n; k++) {
                        if (friends[i][k] && friends[k][j]) {
                            tmp++;
                            break;
                        }
                    }
                }
            }
            mostFriends = Math.max(mostFriends, tmp);
        }
        System.out.println(mostFriends);
    }
}