package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_4_1018 {
	static final char[][] white = {
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'}
	};
	static final char[][] black = { 
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		�ִ� ���� ����
		int paint = 64;
//		�ڸ� ������ �ּ� ���� Ƚ��
		int check = 0;
//		�־��� ���� 
		char[][] board = new char[N][M];
		
//		�־��� ���� ä���
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				board[i][j] = str.charAt(j);
				System.out.println("�迭 " + i +", " + j +" üũüũ : " + str.charAt(j));
			}
		}
//		��
		for(int i = 0 ; i < N-7 ; i++) {
			for(int j = 0 ; j < M-7 ; j++) {
				check = compare(board, i, j);
				if(paint > check) {
					paint = check;
				}
			}
		}
		System.out.println(paint);
	}
	public static int compare(char[][] board, int x, int y) {
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i = x ; i < x + 8 ; i++) {
			for(int j = y ; j < y + 8 ; j++) {
				if(board[i][j] != black[i - x][j - y]) {
					cnt1++;
				}
				if(board[i][j] != white[i - x][j - y]) {
					cnt2++;
				}
			}
		}
		return Math.min(cnt1, cnt2);
	}
}
