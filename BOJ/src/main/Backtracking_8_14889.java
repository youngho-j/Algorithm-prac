package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_8_14889 {
	
	public static int[][] stats;
	
	public static int people;
	
	public static boolean[] select;
	
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		people = Integer.parseInt(br.readLine());
		
		stats = new int[people][people];
		
		select = new boolean[people];
		
//		�ɷ�ġ �Է�
		for(int i = 0 ; i < people ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < people ; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(min);
	}
//	idx�� select �迭�� �ε���, depth�� ��� ����
	public static void dfs(int idx, int depth) {
		if(depth == people/2) {
			diffStats();
			return;
		}
		for(int i = idx ; i < select.length ; i++) {
			if(!select[i]) {
				select[i] = true;
				dfs(i + 1, depth + 1);
				select[i] = false;				
			}
		}
	}
	
	public static void diffStats() {
		int start = 0;
		int link = 0;
//		true�� start��, false�� link������ ���, �ɷ�ġ�� ��Ī�� �̷�Ƿ� �� ���մ� 2�� ����
		for(int i = 0 ; i < people - 1 ; i++) {
			for(int j = i + 1 ; j < people ; j++) {
				if(select[i] == true && select[j] == true) {
					start += stats[i][j];
					start += stats[j][i];
				} else if (select[i] == false && select[j] == false) {
					link += stats[i][j];
					link += stats[j][i];
					
				}
			}
		}
		int diff = Math.abs(start - link);
//		0���� ���� ���� ���� �� �����Ƿ� ���� 0�ϰ�� ���� ����!
		if(diff == 0) {
			System.out.println(diff);
			System.exit(0);
		}
		min = Math.min(diff, min);
	}
}
