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
			input - �Է¹��� ���� ���� �迭
			sort - �Է¹��� ���� �����ؼ� ���� �迭
			checked - �ش� ���ڰ� �迭�� ������ üũ���ִ� �迭
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
		// �迭�� ��� ä��������
		if(depth == N) {
			int sum = 0;
			for(int i = 0 ; i < N-1 ; i++) {
				sum += Math.abs(sort[i] - sort[i+1]);
				result = Math.max(sum, result);
			}
		}
		// �迭�� ä������ �ʾ����� 
		for(int i = 0 ; i < N ; i++) {
			// �迭�� ������ üũ �� ��͸� ���� Ž��
			if(!checked[i]) {
				checked[i] = true;
				sort[depth] = input[i];
				dfs(depth + 1);
				checked[i] = false;
			}
		}
		
	}
}
