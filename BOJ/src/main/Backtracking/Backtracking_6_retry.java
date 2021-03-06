package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_6_retry {
//	������ ��
	public static int[][] board = new int[9][9];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		�Է�
		for(int i = 0 ; i < 9 ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 9 ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play(0, 0);
	}
	
	public static void play(int x, int y) {
		StringBuilder sb = new StringBuilder();
//		�������� ��� ä���� ���
		if(y == 9) {
			play(x + 1, 0);
			return;
		}
//		�������� ��� ä�� �������� �ϼ�
		if(x == 9) {
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
//			���� ó���� �ϼ���Ų ���� ����ϰ� ���� ����
			System.out.println(sb);
			System.exit(0);
		}
//		�ش� ĭ�� ���� ���
		if(board[x][y] == 0) {
			for(int i = 1 ; i <= 9 ; i++) {
				if(check(x, y, i)) {
					board[x][y] = i;
					play(x, y + 1);
				}
			}
			board[x][y] = 0;
			return;
		}
//		���� �ƴ� ���
		play(x, y + 1);
	}
	public static boolean check(int x, int y, int value) {
//		������ ����
		for(int i = 0 ; i < 9 ; i++) {
			if(board[x][i] == value) {
				return false;
			}
		}
//		������ ����
		for(int i = 0 ; i < 9 ; i++) {
			if(board[i][y] == value) {
				return false;
			}
		}
//		3��3 ���� ����
		int boxStartNumX = (x/3)*3;
		int boxStartNumY = (y/3)*3;
		for(int i = boxStartNumX ; i < boxStartNumX + 3 ; i++) {
			for(int j = boxStartNumY ; j < boxStartNumY + 3 ; j++) {
				if(board[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
