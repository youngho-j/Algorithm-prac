package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Backtracking_g_10819_retry {
	static int N;
	static int result;
	static int[] input;
	static int[] sort;
	static boolean[] checked;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		/*
			input - 입력받을 값을 넣을 배열
			sort - 입력받은 값을 정렬해서 넣을 배열
			checked - 해당 숫자가 배열에 들어갔는지 체크해주는 배열
		*/
		input = new int[N];
		sort = new int[N];
		checked = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(result);
	}
	
	public static void dfs(int depth) {
		// 배열이 모두 채워졌을때
		if(depth == N) {
			int sum = 0;
			for(int i = 0 ; i < N-1 ; i++) {
				sum += Math.abs(sort[i] - sort[i+1]);
				result = Math.max(sum, result);
			}
		}
		// 배열이 채워지지 않았을때 
		for(int i = 0 ; i < N ; i++) {
			// 배열에 들어갔는지 체크 후 재귀를 통해 탐색
			if(!checked[i]) {
				checked[i] = true;
				sort[depth] = input[i];
				dfs(depth + 1);
				checked[i] = false;
			}
		}
		
	}
}
