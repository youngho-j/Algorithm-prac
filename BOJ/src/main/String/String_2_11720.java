package main.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_2_11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int cnt = Integer.parseInt(br.readLine());
		String nb = br.readLine();
		for (int i = 0; i < cnt; i++) {
			sum += nb.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
/*
	참고사항 : charAt(i) -'0' or charAt(i) - 48 -> int형으로 출력됨!
*/