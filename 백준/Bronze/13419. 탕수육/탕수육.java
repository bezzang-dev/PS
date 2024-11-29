import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < T; i++) {
            String sentence = br.readLine();
            if (sentence.length() % 2 == 1) {
                sentence += sentence;
            }
            String a = "";
            String b = "";
            for (int j = 0; j < sentence.length(); j++) {
                if (j % 2 == 1) {
                    a += sentence.charAt(j);
                } else {
                    b += sentence.charAt(j);
                }
            }

            sb.append(b).append("\n");
            sb.append(a).append("\n");
        }
        System.out.println(sb);

    }
}