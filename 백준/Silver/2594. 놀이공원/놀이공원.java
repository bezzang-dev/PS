import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<int[]> timeTable = new ArrayList<>();
        final int jobStartTime = 60 * 10;
        final int jobEndTime = 60 * 22;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();

            int startMinute = convertMinute(start);
            int endMinute = convertMinute(end);
            timeTable.add(new int[] { startMinute - 10, endMinute + 10 });
        }
        timeTable.sort((o1, o2) -> {
            return o1[0] - o2[0];
        });

        ArrayList<int[]> mergedTimeTable = new ArrayList<>();
        mergedTimeTable.add(timeTable.get(0));

        for (int i = 1; i < timeTable.size(); i++) {
            int[] lastMerged = mergedTimeTable.get(mergedTimeTable.size() - 1);
            int[] current = timeTable.get(i);

            if (lastMerged[1] >= current[0]) {
                lastMerged[1] = Math.max(current[1], lastMerged[1]);
            } else {
                mergedTimeTable.add(current);
            }
        }

        // 10:30 ~ 13:00
        // 12:30 ~ 16:50
        // 19:00 ~ 21:10
        int restTime = 0;
        restTime = Math.max(mergedTimeTable.get(0)[0] - jobStartTime, restTime);
        
        for (int i = 1; i < mergedTimeTable.size(); i++) {
            int[] prev = mergedTimeTable.get(i - 1);
            int[] current = mergedTimeTable.get(i);
            restTime = Math.max(restTime, current[0] - prev[1]);
        }

        int[] last = mergedTimeTable.get(mergedTimeTable.size() - 1);
        restTime = Math.max(restTime, jobEndTime - last[1]);

        System.out.println(restTime);
    }

    static int convertMinute(String time) {
        String hour = time.substring(0, 2);
        String minute = time.substring(2, 4);
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
}