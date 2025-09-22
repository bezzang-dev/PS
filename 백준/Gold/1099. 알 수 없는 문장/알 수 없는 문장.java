import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        int N = Integer.parseInt(br.readLine());

        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        int[] dp = new int[sentence.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= sentence.length(); i++) {
            for (int j = 0; j < i; j++) {
                for (String word : strings) {
                    int cost = calcCost(sentence.substring(j, i), word);
                    if (dp[j] != Integer.MAX_VALUE && cost != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[j] + cost);
                }
            }
        }

        if (dp[sentence.length()] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[sentence.length()]);
    }

    private static int calcCost(String sentence, String word) {
        if (sentence.length() != word.length()) {
            return Integer.MAX_VALUE;
        }

        char[] sortedSentenceArr = sentence.toCharArray();
        Arrays.sort(sortedSentenceArr);
        String sortedSentence = new String(sortedSentenceArr);

        char[] sortedWordArr = word.toCharArray();
        Arrays.sort(sortedWordArr);
        String sortedWord = new String(sortedWordArr);

        if (!sortedSentence.equals(sortedWord)) {
            return Integer.MAX_VALUE;
        }

        int cnt = sortedSentenceArr.length;
        for (int i = 0; i < sortedSentenceArr.length; i++) {
            if (sentence.charAt(i) == word.charAt(i)) cnt--;
        }

        return cnt;
    }
}