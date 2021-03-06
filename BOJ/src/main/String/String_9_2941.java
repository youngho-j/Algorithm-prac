package main.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_9_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int len = str.length();
		int count = 0;

		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'c' && i < len - 1) {
				if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
					i++;
				}
			} else if (str.charAt(i) == 'd' && i < len - 1) {
				if (str.charAt(i + 1) == '-') {
					i++;
				} else if (str.charAt(i + 1) == 'z' && i < len - 2) {
					if (str.charAt(i + 2) == '=') {
						i += 2;
					}
				}
			} else if ((str.charAt(i) == 'l' || str.charAt(i) == 'n') && i < len - 1) {
				if (str.charAt(i + 1) == 'j') {
					i++;
				}
			} else if ((str.charAt(i) == 's' || str.charAt(i) == 'z') && i < len - 1) {
				if (str.charAt(i + 1) == '=') {
					i++;
				}
			}
			count++;
		}
		System.out.println(count);
	}
}

/*
 * 원인 : StringIndexOutBounds - 문자열의 사이즈보다 큰 경우 발생
 * 그 후 코드라인 줄이다가 오타로 인한('-' 구분하는 조건이 '=' 조건 두개였음... ㅠ) 실패
 * 예제소스 디버깅했는데도 안나왔는데.. 오탈자 꼭 점검!
 *
 *
 */
