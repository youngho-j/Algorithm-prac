package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_2_15650 {
	public static int N;
	public static int M;
	
	public static int[] arr;
	
	public static StringBuilder sb = new StringBuilder();
//	현재 위치 변수 추가
	public static void dfs(int cur, int depth) {
		if(depth == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		} 
		for(int i = cur ; i <= N ; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		dfs(1, 0);
		System.out.println(sb);
	}
}
