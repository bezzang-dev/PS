import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fjSong = new int[N];
        for (int i = 0; i < N; i++) {
            fjSong[i] = Integer.parseInt(br.readLine());
        }

        int C = Integer.parseInt(br.readLine());
        int[] cNotes = new int[C];
        for (int i = 0; i < C; i++) {
            cNotes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cNotes);
        int cTmp = cNotes[0];
        for (int i = 0; i < C; i++) {
            cNotes[i] -= cTmp;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i <= N - C; i++) {
            ArrayList<Integer> fjList = new ArrayList<>();
            for (int j = 0; j < C; j++) {
                fjList.add(fjSong[i + j]);
            } 
            Collections.sort(fjList);

            int fTmp = fjList.get(0);
            for (int j = 0; j < C; j++) {
                fjList.set(j, fjList.get(j) - fTmp);
            }

            boolean isMatch = true;
            for (int j =0; j < C; j++) {
                if (cNotes[j] != fjList.get(j)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                result.add(i+1);
            }
        }
        System.out.println(result.size());
        for (int value : result) {
            System.out.println(value);
        }
    }
}