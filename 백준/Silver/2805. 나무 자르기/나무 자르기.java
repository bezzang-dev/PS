import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfTrees = Integer.parseInt(st.nextToken());
        int[] trees = new int[numOfTrees];
        int targetLength = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfTrees; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        // search
        long start = 0;
        long end = Long.MAX_VALUE;
        long answer = 0;
        while (start <= end) {
            long currentLength = 0;
            long height = (start + end) / 2;
            for (int tree : trees) {
                if (height < tree) {
                    currentLength += (tree - height);
                }
            }
            if (currentLength >= targetLength) {
                answer = height;
                start = height + 1;
            } else if (currentLength < targetLength) {
                end = height - 1;
            }
        }
        System.out.println(answer);

    }
}
