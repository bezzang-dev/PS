import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numOfPeople = Integer.parseInt(st.nextToken()); 
		int numOfParty = Integer.parseInt(st.nextToken());

		parent = new int[numOfPeople + 1];
		for (int i = 1; i <= numOfPeople; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		HashSet<Integer> truthSet = new HashSet<>();
		int numOfKnow = Integer.parseInt(st.nextToken());
		for (int i = 0; i < numOfKnow; i++) {
			int num = Integer.parseInt(st.nextToken());
			truthSet.add(num);
		}

		List<int[]> parties = new ArrayList<>();
		for (int i = 0; i < numOfParty; i++) {
			st = new StringTokenizer(br.readLine());
			int comePeople = Integer.parseInt(st.nextToken());
			int[] participants = new int[comePeople];
			for (int j = 0; j < comePeople; j++) {
				participants[j] = Integer.parseInt(st.nextToken());
			}
			parties.add(participants);

			for (int j = 1; j < comePeople; j++) {
				union(participants[0], participants[j]);
			}
		}
		// 진실을 아는 사람들과 같은 그룹으로 연결된 사람들을 찾음
		boolean[] truthConnected = new boolean[numOfPeople + 1];
		for (int person : truthSet) {
			truthConnected[find(person)] = true;
		}
		
		int answer = 0;
		for (int[] party : parties) {
			boolean canLie = true;
			for (int people : party) {
				if (truthConnected[find(people)]) {
					canLie = false;
					break;
				}
			}
			if (canLie) {
				answer++;
			}
		}

		System.out.println(answer);

	}

	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)
			parent[x] = y;
	}

}
