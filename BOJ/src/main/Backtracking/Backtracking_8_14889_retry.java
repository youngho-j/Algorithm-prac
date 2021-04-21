package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_8_14889_retry {
	/*
		N���̼� �౸ - N���� ¦��
		���� �ΰ��� ���� - ��ŸƮ�� ��ũ
		S ij�� ���� �������� �ɷ�ġ
		�ɷ�ġ ���� �ּ� 
	*/
	// �� ���� ������ ���� �迭
	static int team[][];
	static boolean select[];
	static int N;
	static int differ = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// �ǹ��� - input ������Ŀ� ���� �ӵ��� � ���̰� ������?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���� �ο��� - �ݵ�� ¦���̴�.
		N = Integer.parseInt(br.readLine());
		
		// �迭 ũ�� �ʱ�ȭ
		team = new int[N][N];
		select = new boolean[N];
		// �ǹ��� - ���ڿ� �и��� split�� ���̴� �����ΰ�?
		
		// stat �Է�
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(differ);
	}
	
	public static void dfs(int idx, int depth) {
		if(depth == N/2) {
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
		
		for(int i = 0 ; i < N - 1 ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				if(select[i] == true && select[j] == true) {
					start += team[i][j];
					start += team[j][i];
				} else if(select[i] == false && select[j] == false) {
					link += team[i][j];
					link += team[j][i];
				}
			}
		}
		int diff = Math.abs(start - link);
		
		if(diff == 0) {
			System.out.println(diff);
			System.exit(0);
		}
		differ = Math.min(diff, differ);
	}
}
