import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static char[][] map;
    static boolean[][] visited; // 방문 여부를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = -1;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        long cutNum = Math.round(N * 0.15);
        while (cutNum > 0) {
            list.removeFirst();
            list.removeLast();
            cutNum--;
        }

        int avg = 0;
        for (int val : list) {
            avg += val;
        }

        long answer = Math.round((float) avg / list.size());

        System.out.println(answer);

    }
}