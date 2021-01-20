package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_10_1316 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int wordCount = Integer.parseInt(br.readLine());
		int result = 0;

		for(int i = 0 ; i < wordCount ; i++) {
			if(wordCheck(br.readLine())) {
				result++;
			}
		}
		System.out.println(result);
	}
	// 단어를 받아서 그룹단어인지 체크하는 함수
	public static boolean wordCheck(String word) {
		// 알파벳 중복 여부 체크 배열, 기본값 false
		boolean[] bl = new boolean[26];
		// 이전 알파벳 값을 담을 변수
		int pre = 0;
		//단어 길이만큼 돌면서 이전과 현재 알파벳 체크
		for(int i = 0 ; i < word.length() ; i++) {
			// 현재 알파벳 값을 담을 변수
			int now = word.charAt(i);
			// 현재 알파벳 값과 이전 알파벳이 같지 않을 경우 or for문 처음 시작하는 경우
			if(now != pre) {
				// 처음 나온 경우 해당 알파벳에 해당하는 배열의 값을 true로 변경하고 현재 값을 pre에 담아줌
				if(bl[now-'a'] == false) {
					bl[now-'a'] = true;
					pre = now;
				// 이미 나온 경우
				} else {
					return false;
				}
			}
		}
		// for문을 전부 돌았을경우 그룹함수이므로 
		return true;
	}
}

/*
 * 원인 : 처음 문제 풀때는 int 배열에 중복횟수를 담아 비교하려고 했으나, 제출시 틀렸음.. 예외처리가 안된 듯..
 * boolean 배열을 통해 알파벳의 중복 여부 구분으로 변경하여 다시 풀었음.
 * 
 * 참고 : 그룹함수란 알파벳 순서와 상관없이 해당알파벳이 연속적으로 나오게 되는 경우 단, 이전에 나온 알파벳이 뒤에 다시 나올 경우는 그룹함수 아님.
 * Ex) aaaavvvvs, sevrt -> 그룹함수 / sssvregs -> 그룹함수 X 
 */
