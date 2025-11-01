import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] childNode;

        boolean isEnd;

        TrieNode() {
            this.childNode = new TrieNode[10];
            this.isEnd = false;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        boolean insertAndCheck(String phone) {
            TrieNode current = root;

            for (int i = 0; i < phone.length(); i++) {
                char c = phone.charAt(i);
                int idx = c - '0';
                if (current.childNode[idx] == null) {
                    current.childNode[idx] = new TrieNode();
                }

                if (current.childNode[idx].isEnd) {
                    return false;
                }
                current = current.childNode[idx];
            }

            for (int i = 0; i < 10; i++) {
                if (current.childNode[i] != null) {
                    return false;
                }
            }

            current.isEnd = true;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Trie root = new Trie();

            boolean isConsistent = true;
            for (int j = 0; j < n; j++) {
                String phone = br.readLine();
                if (!isConsistent)
                    continue;
                isConsistent = root.insertAndCheck(phone);
            }

            if (!isConsistent) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);

    }
}