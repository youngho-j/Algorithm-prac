package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_5_retry {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		문자열과 카운팅 배열 선언 - 카운팅 배열은 각 자리수에 들어갈 수 있는 수는 0 ~ 9이므로 10으로 선언
		String str = br.readLine();
		int[] check = new int[10];
//		각 자리숫자에 해당하는 배열 인덱스에 카운팅
		for(int i = 0 ; i < str.length() ; i++) {
			check[str.charAt(i) - '0']++;
		}
//		내림차순 정렬이므로 배열의 최대길이 -1에서 0일때까지 감소하면서 stringbuilder에 추가
		for(int i = check.length-1 ; i >= 0 ; i--) {
//			배열의 카운팅 숫자가 0일때까지 해당 인덱스번호를 추가
			while(check[i] > 0) {
				sb.append(i);
				check[i]--;
			}
		}
		System.out.println(sb);
	}
}
