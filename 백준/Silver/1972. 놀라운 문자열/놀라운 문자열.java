import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String st = br.readLine();
            if (st.equals("*")) {
                break;
            }
            
            boolean isSurprising = true;
            int length = st.length();

            for (int d = 1; d < length; d++) {
                HashSet<String> seen = new HashSet<>();
                for (int i = 0; i + d < length; i++) {
                    String pair = "" + st.charAt(i) + st.charAt(i + d);
                    if (seen.contains(pair)) {
                        isSurprising = false;
                        break;
                    }
                    seen.add(pair);
                }
                if (!isSurprising) {
                    break;
                }
            }

            if (isSurprising) {
                sb.append(st).append(" is surprising.\n");
            } else {
                sb.append(st).append(" is NOT surprising.\n");
            }
        }

        System.out.print(sb);
    }
}