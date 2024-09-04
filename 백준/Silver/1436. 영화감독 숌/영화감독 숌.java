import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 1;
		int number = 666;
		while (count != N) {
			number += 1;
			if (String.valueOf(number).contains("666")) {
				count += 1;
			}
		}
		System.out.println(number);
	}

}