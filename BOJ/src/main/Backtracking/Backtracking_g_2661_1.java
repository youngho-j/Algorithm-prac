package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backtracking_g_2661_1 {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 - 숫자 N 하나로 이루어짐, 범위는 1 <= N <= 80
		N = Integer.parseInt(br.readLine());
		// 좋은 수열 중에서 작은수를 찾아야 하므로, 1로 시작할때 좋은 수열중 작은 수가 될 수 있음
		find("1");
	}
	
	static void find(String str) {
		// 1로 시작을 하여 좋은 수열을 찾으므로, 가장 처음에 나온 수가 작은 수임
		// 따라서, 해당 좋은 수열을 출력수 종료
		if(str.length() == N) {
			System.out.println(str);
			System.exit(0);
		} else {
			// 좋은 수열을 찾을때 for문을 통해 다음자리수에 작은 수부터 넣어 검사할 수 있도록 함
			for(int i = 1 ; i <= 3 ; i++) {
				// 인접한 길이가 동일한지 검사 후 동일하지 않을 경우 다음 자리수를 구하기 위해 재귀
				if(check(str + i)) {
					find(str + i);
				}
			}
		}
	}
	
	static boolean check(String str) {
		int len = str.length();
		String front = "";
		String back = "";
		
		for(int i = 1 ; i <= len/2 ; i++) {
			front = str.substring(len - i * 2, len - i);
			back = str.substring(len - i, len);
			// 한번이라도 겹치면 안되므로 for문을 돌면서 각 자리수별로 같은지를 비교할 수 있도록함
			if(front.equals(back)) {
				return false;
			}
		}
		return true;
	}
}
