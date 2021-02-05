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
//		최대 변경 갯수
		int paint = 64;
//		자른 보드의 최소 변경 횟수
		int check = 0;
//		주어진 보드 
		char[][] board = new char[N][M];
		
//		주어진 보드 채우기
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				board[i][j] = str.charAt(j);
				System.out.println("배열 " + i +", " + j +" 체크체크 : " + str.charAt(j));
			}
		}
//		비교
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
