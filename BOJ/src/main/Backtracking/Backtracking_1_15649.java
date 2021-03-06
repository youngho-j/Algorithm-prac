package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_1_15649 {
	public static int N;
	public static int M;
//	�˻�
	public static boolean[] check;
//	��
	public static int[] arr;
//	���
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		check = new boolean[N];
		dfs(0);
		System.out.println(sb);
	}
	public static void dfs(int depth) {
//		������ ���� ������ �� StringBuilder�� ��Ƽ� ������ 
		if(depth == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) {
				check[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				check[i] = false;
			}
		}
		return;
	}
}
