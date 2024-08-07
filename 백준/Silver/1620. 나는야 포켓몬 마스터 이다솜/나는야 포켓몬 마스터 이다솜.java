import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] paper;
    static int[] counts = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(i, name);
            map2.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            try {
                int num = Integer.parseInt(question);
                System.out.println(map.get(num));
            } catch(Exception e) {
                System.out.println(map2.get(question));
            }
        }
    }}

    