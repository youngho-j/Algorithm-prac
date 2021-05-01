package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_14888 {
	
	static int N;
	static int[] number;
	static int[] calc;
	static int maxVal = Integer.MIN_VALUE;
	static int minVal = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		number = new int[N];
		calc = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < N ; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < 4 ; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		
		find(number[0], 1);
		
		sb.append(maxVal).append("\n").append(minVal);
		System.out.println(sb);
	}
	
	static void find(int num, int idx) {
		// 연산자를 모두 넣었을 경우
		if(idx == N) {
			maxVal = Math.max(num, maxVal);
			minVal = Math.min(num, minVal);
			return;
		}
		// 연산자의 개수가 1개 이상있을 경우 
		for(int i = 0 ; i < 4 ; i++) {
			if(calc[i] > 0) {
				calc[i]--;
				switch (i) {
				case 0:
					find(num + number[idx], idx + 1);
					break;
				case 1:
					find(num - number[idx], idx + 1);
					break;
				case 2:
					find(num * number[idx], idx + 1);
					break;
				case 3:
					find(num / number[idx], idx + 1);
					break;
				}
				// 재귀가 끝나면 다시 사용할 수 있도록 연산자 개수 복구
				calc[i]++;
			}
		}
	}
}
