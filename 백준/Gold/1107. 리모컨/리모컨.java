import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] remote = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        if (n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int idx = Integer.parseInt(st.nextToken());
                remote[idx] = -1;
            }
        }

        int minPresses = Math.abs(target - 100);
        for (int channel = 0; channel <= 1000000; channel++) {
            int length = canPress(channel);
            if (length > 0) {
                int presses = length + Math.abs(channel - target);
                if (presses < minPresses) {
                    minPresses = presses;
                }
            }
            
        }

        System.out.println(minPresses);

    }

    static int canPress(int channel) {
        if (channel == 0) {
            return (remote[0] == -1) ? 0 : 1;
        }

        int length = 0;
        while (channel > 0) {
            if (remote[channel % 10] == -1) {
                return 0;
            }
            length += 1;
            channel /= 10;
        }
        return length;
    }

}
