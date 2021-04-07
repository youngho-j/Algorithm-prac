package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_10819 {
	static int N;
	
	static int result;
	
	static int[] arr;
	static int[] arr2;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result = 0;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr2 = new int[N];
		check = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(result);
	}
	
	public static void dfs(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0 ; i < N-1 ; i++) {
				sum += Math.abs(arr2[i] - arr2[i+1]);
				result = Math.max(sum, result);
			}
		}
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) {
				check[i] = true;
				arr2[depth] = arr[i];
				dfs(depth + 1);
				check[i] = false;
			}
		}
	}
}
