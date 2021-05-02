package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_15684 {
	
	// ���μ� ����(��), ���μ� ����, ���μ� ���� ���μ��� ���� �� �ִ� ��ġ�� ����(��)
	static int N, M, H;
	static int[][] ladder;
	static int ans;
	static boolean isCheck;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		
		ladder = new int[H+1][N+1];
		
		int a, b;
		while(M --> 0) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				// ������ �̵��� 1, ���� �̵��� 2
				ladder[a][b] = 1;
				ladder[a][b+1] = 2;
		}
		
		//��ٸ� ���μ� ���� ����� ��(�ѹ��� �ȳ��� ������ ~ �ִ� 3������)
		for(int i = 0 ; i <= 3 ; i++) {
			// ���� ���� ���� ��ٸ� ����
			ans = i;
			addLadder(1, 0, i);
			if(isCheck) {
				break;
			}
		}
		
		// ������ ���̸� ans, �����ΰ�� -1 ���
		System.out.println(isCheck ? ans : -1);
		
	}
	//���� ���μ�, ���õ� ����, ���� ���μ��� ����� ��
	static void addLadder(int row, int cnt, int len) {
		// i�� ���� ���� ����� i���� ��� ��� ����!
		if(isCheck) {
			return;
		}
		// ��ٸ� �߰� ������ ����� �� ��ġ�� ������ �� �Ǿ����� �˻�
		if(cnt == len) {
			if(isPossible()) {
				isCheck = true;
			}
			return;
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
					addLadder(i,cnt+1, len);
					ladder[i][j]=0;
					ladder[i][j+1]=0;
				}
			}
		}
	}
	
	
	// i ��ٸ��� i������ ���������� �˻� 
	static boolean isPossible() {
		// 1�� ���μ� ���� Ȯ���ϸ鼭 ����
		for(int i = 1 ; i <= N ; i++) {
			// 1�� ���μ� Ȯ���� ���� ���μ����� �̵��ϹǷ�(���ι���)
			int row = i;
			// �������� �����ϹǷ� 1�� ������
			int col = 1;
			// ���������� �������鼭 ����
			for(int j = 0 ; j < H ; j++) {
				// �ش������� ���� 1�̸� ���������� �̵�(row �� �߰�)
				if(ladder[col][row] == 1) {
					row++;
				// �ش������� ���� 2�̸� �������� �̵�(row �� ����)
				} else if(ladder[col][row] == 2) {
					row--;
				}
				//�¿��� �̵��� �� �����Ƿ� ����(��)�� ������
				col++;
			}
			// ������� i�� �������� row�� ���� ������
			if(row != i) {
				return false;
			}
		}
		return true;
	}
}
// ���� - https://gwanhyeon.github.io/Samsung-20210422-ladder-fake/
// ���� ���� - https://covenant.tistory.com/224