import java.util.*;

class Solution {
    static String be;
    static String tar;
    static String[] wordList;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        be = begin;
        tar = target;
        wordList = words;
        boolean[] isVisited = new boolean[words.length];
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        DFS(begin, isVisited, 0);
        
        return answer;
    }
    
    void DFS(String current, boolean[] isVisited, int cnt) {
        if (current.equals(tar)) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < wordList.length; i++) {
            if (!isVisited[i]) {
                if (checkIsTranslate(current, wordList[i])) {
                    isVisited[i] = true;
                    DFS(wordList[i], isVisited, cnt + 1);
                    isVisited[i] = false; 
                }
            }
        }
    }

    boolean checkIsTranslate(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt += 1;
            }
        }
        return cnt == 1;
    }

}