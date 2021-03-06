package main.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_5_1157 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//받아온 문자를 대문자로 변경
		String str = br.readLine().toUpperCase();
		//알파벳 나온 개수를 담을 배열
		int[] alpha = new int[26];
		//알파벳 최대 개수
		int max = 0;
		//최대 개수를 가진 알파벳 중복여부
		int maxCount = 0;
		//알파벳 대문자 출력을 위한 변수
		int alphabet = 0;
		
		//배열에 알파벳 개수를 담음
		for(int i = 0 ; i < str.length() ; i++) {
			int n = str.charAt(i) - 'A';
			alpha[n]++;
		}
		
		//알파벳 최대개수와 알파벳 대문자를 구함
		for(int j = 0 ; j < alpha.length ; j++) {
			if(alpha[j] > max) {
				max = alpha[j];
				alphabet = j;
			}
		}
		//알파벳 최대개수가 겹치는지 확인
		for(int k = 0 ; k < alpha.length ; k++) {
			if(max == alpha[k]) {
				maxCount++;
			}
		}
		//출력
		if(maxCount > 1) {
			System.out.println("?");
		} else if(maxCount == 1){
			System.out.println((char)(alphabet + 'A'));
		}
	}
}
/*
	코드 더 줄여보기
*/