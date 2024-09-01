import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		String bomb = br.readLine();
		int bombSize = bomb.length();
		StringBuilder sb = new StringBuilder();

		for (char c : sentence.toCharArray()) {
			sb.append(c);
			if (sb.length() >= bombSize) {
				boolean isBomb = true;
				for (int i = 0; i < bombSize; i++) {
					if (sb.charAt(sb.length() - bombSize + i) != bomb.charAt(i)) {
						isBomb = false;
					}
				}
				if (isBomb) {
					sb.delete(sb.length() - bombSize, sb.length());
				}
			}
		}

		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}

	}

}
