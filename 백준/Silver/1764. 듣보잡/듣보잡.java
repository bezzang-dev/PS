import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unheard.add(sc.nextLine());
        }

        Set<String> unseen = new HashSet<>();
        for (int i = 0; i < m; i++) {
            unseen.add(sc.nextLine());
        }

        // 듣도 보도 못한 사람의 교집합 구하기
        List<String> unheardUnseen = new ArrayList<>();
        for (String name : unseen) {
            if (unheard.contains(name)) {
                unheardUnseen.add(name);
            }
        }

        // 사전순으로 정렬
        Collections.sort(unheardUnseen);

        // 결과 출력
        System.out.println(unheardUnseen.size());
        for (String name : unheardUnseen) {
            System.out.println(name);
        }
    }
}