package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_4_15652 {
	public static int N, M;
	
	public static int[] arr;
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int cur, int depth) {
		if(depth == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
//		비내림차순 - 깊이는 올라가되, 이전 깊이에 있던 값이 두번째에 와야함
		for(int i = cur ; i <= N ; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
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
