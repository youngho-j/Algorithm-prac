package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backtracking_g_2661 {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		//최소값을 구해야하므로 1로 시작해야 최소 값이 나올 수 있음
		check("1");
	}
	
	static void check(String str) {
		// 주어진 자리수를 다채웠을 경우 출력
		if(str.length() == N) {
			System.out.println(str);
			System.exit(0);
		// 다음수 1 ~ 3 중 올 수 있는 수를 체크
		} else {
			for(int i = 1 ; i <= 3 ; i++) {
				if(ableCheck(str + i)) {
					check(str + i);
				}
			}
		}
	}
	
	static boolean ableCheck(String str) {
		int len = str.length();
		
		for(int i = 1 ; i <= len/2 ; i++) {
			String front = str.substring(len - i * 2, len - i);
			String back = str.substring(len - i, len);
			
			if(front.equals(back)) {
				return false;
			}
		}
		return true;
	}
}
