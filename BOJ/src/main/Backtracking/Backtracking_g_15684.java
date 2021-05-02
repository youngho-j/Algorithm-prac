package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_15684 {
	
	// ���μ� ����, ���μ� ����, ���μ� ���� ���μ��� ���� �� �ִ� ��ġ�� ����
	static int N, M, H;
	static int[][] ladder;
	static int ans;
	static boolean finish = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		
		ladder = new int[H+1][N+1];
		
		if(M > 0) {
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// ������ �̵��� 1, ���� �̵��� 2
				ladder[a][b] = 1;
				ladder[a][b+1] = 2;
			}
		}
		
		//��ٸ� ���μ� ����(�ѹ��� �ȳ��� ������ ~ �ִ� 3������)
		for(int i = 0 ; i <= 3 ; i++) {
			if(finish) {
				break;
			}
			ans = i;
			addLadder(1, 0);
		}
		
		// ���� ��½� 0 ~ 3 ���������� ���, ��ã�ų�, 3���� ū��� -1 ���
		if(ans > -1 && ans <= 3) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
		
	}
	static void addLadder(int row, int level) {
		if(finish) {
			return;
		}
		// ��ٸ� �߰� ������ ��ġ�� ��ü �˻�
		if(ans == level) {
			if(isPossible()) {
				finish = true;
				return;
			}
		}
		for(int i = row ; i < H+1 ; i++) {
			// ��ٸ��� ������ N��° ���ο��� ���� ��� N+1������ �ʿ� 
			// ���� N���� ��ٸ��� ���� ���ؼ��� N-1���� ��ٸ��� ���ƾ��� 
			// ��, j�� < N ���������� ���ƾ� �迭�ʰ������� ���� ���� 
			for(int j = 1 ; j < N ; j++) {
				if(ladder[i][j] == 0 && ladder[i][j+1] == 0) {
					// ��ٸ� ����
					ladder[i][j]=1;
					ladder[i][j+1]=2;
					addLadder(i,level+1);
					ladder[i][j]=0;
					ladder[i][j+1]=0;
				}
			}
		}
	}
	
	
	// i ��ٸ��� i������ ���������� �˻� 
	static boolean isPossible() {
		for(int i = 1 ; i <= N ; i++) {
			int row = i;
			int col = 1;
			
			while(true) {
				if(col == H+1) {
					break;
				}
				if(ladder[col][row] == 1) {
					row += 1;
				} else if(ladder[col][row] == 2) {
					row -= 1;
				}
				col++;
			}
			
			if(row != i) {
				return false;
			}
		}
		return true;
	}
}
