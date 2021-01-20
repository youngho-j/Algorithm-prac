package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_3_10809 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alpha = new int[26];
		StringBuilder sb = new StringBuilder();
		//배열 -1로 초기화(나중에 첫 값을 넣어줄때 검사하기 위해)
		for(int i = 0 ; i < alpha.length ; i++) {
			alpha[i] = -1;
		}
		for(int i = 0 ; i < str.length() ; i++) {
			int n = (str.charAt(i) - 97);
			if(alpha[n] == -1) {
				alpha[n] = i;								
			} 
		}
		for(int j = 0 ; j < alpha.length ; j++) {
			sb.append(alpha[j]).append(" ");
		}
		System.out.println(sb);		
	}
}

/*
 * 원인 : 출력시 빈값을 -1로 초기화를 먼저하지 않고 진행했더니 문자열에서 처음 등장하는 알파벳 위치를 배열에 넣는것이 아닌 나중에 나온 배열값을 넣게됨
 * 참고사항 : String class indexOf 메소드 사용해서 해보기 / 값이 있으면 해당 위치 리턴 없을 경우 -1 리턴
 *  
 */
