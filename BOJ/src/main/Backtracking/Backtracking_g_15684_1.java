package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_15684_1 {
	// ���μ�, ������ ���μ�, ���μ��� ���� �� �ִ� ��ġ�� ����
	static int n, m, h;
	// ��ٸ��� ������ �迭
	static int[][] ladder;
	
	static int result;
	static boolean isOk;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		ladder= new int[h+1][n+1];
		
		//���μ��� ����
		int a, b;
		while(m --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1;
			ladder[a][b+1] = 2;
		}
		
		// ��½� ������ 3���� ũ�ų� �Ұ����� ��� -1 ���
		for(int i = 0 ; i <= 3 ; i++) {
			result = i;
			dfs(1, 0, i);
			if(isOk) {
				break;
			}
		}
		System.out.println(isOk? result:-1);
	}
	// ���� ��, �׾��� ���� ����,�߰��� ���� ����
	static void dfs(int x, int pick, int cnt) {
		if(isOk) {
			return;
		}
		// ��ٸ��� �������� ���ϴ� ����� �������� üũ
		if(pick == cnt) {
			if(check()) {
				isOk = true;		
			}
			return;
		}
		//��ٸ� �߰��ϱ� 
		for(int i = x ; i < h+1 ; i++) {
			for(int j = 1 ; j < n ; j++) {
				if(ladder[i][j] == 0 && ladder[i][j+1] == 0) {
					ladder[i][j] = 1;
					ladder[i][j+1] = 2;
					dfs(x, pick+1, cnt);
					ladder[i][j] = 0;
					ladder[i][j+1] = 0;					
				}
			}
		}
	}
	// i��° ��ٸ��� ����� i�� �������� �˻� 
	static boolean check() {
		// 1�� ��ٸ� ���� �˻� ~ n����ٸ�����
		for(int i = 1 ; i <= n ; i++) {
			//i��° ��ٸ� 1�� ��ġ���� ����
			int mx = 1;
			// i��° ��ٸ� 
			int my = i;
			// i��° ��ٸ� ������ ���� �������鼭 ����
			for(int j = 0 ; j < h ; j++) {
				// 1�ϰ�� ���������� �̵�
				if(ladder[mx][my] == 1) {
					my++;
				} else if(ladder[mx][my] == 2) {
					my--;
				}
				mx++;
			}
			//������� i�� �������� my�� ���� ���� ��� 
			if(my != i) {
				return false;
			}
		}
		return true;
	}
}
