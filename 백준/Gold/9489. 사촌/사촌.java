import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0)
                break;

            int[] arr = new int[n];
            int[] parent = new int[n];
            int targetIdx = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == k) {
                    targetIdx = i;
                }
            }

            parent[0] = -1;
            int parentIdx = -1;
            for (int i = 1; i < n; i++) {
                if (arr[i] != arr[i - 1] + 1) {
                    parentIdx++;
                }
                parent[i] = parentIdx;
            }

            int answer = 0;
            if (parent[targetIdx] != -1) { // 루트가 아니고
                int targetParent = parent[targetIdx];
                if (parent[targetParent] != -1) { // 부모의 부모가 있고
                    int targetGrandParent = parent[targetParent];
                    for (int i = 1; i < n; i++) {
                        int currentParent = parent[i];

                        // 부모가 다르며, 부모의 부모가 같다면
                        if (currentParent != targetParent && parent[currentParent] == targetGrandParent) {
                            answer++;
                        }
                    }
                }
            }
            System.out.println(answer);
        }

    }
}