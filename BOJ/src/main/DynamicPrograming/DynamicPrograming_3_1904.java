package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_3_1904 {
	//입력 가능 범위 
	static int[] memo = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 타일 조합으로 만들 수 있는 경우의 수 memo에 추가
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		// 0과 구분하기 위해 조합을 모르는 수는 -1로 초기화
		for(int i = 3 ; i < memo.length ; i++) {
			memo[i] = -1;
		}
		System.out.println(count(N));
	}
	
	public static int count(int N) {
		// 조합수를 모를 경우 점화식으로 구하고 메모이제이션
		if(memo[N] == -1) {
			memo[N] = (count(N-1) + count(N-2)) % 15746;
		}
		// 조합수를 아는 경우 배열에서 가져옴
		return memo[N];
	}
}
