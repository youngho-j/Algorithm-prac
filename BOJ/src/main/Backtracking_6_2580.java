package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_6_2580 {
	public static int[][] sdokupan = new int[9][9];
	
	public static boolean checkCell(int row, int col, int value) {
		int startHori = (row/3)*3;
		int startVerti = (col/3)*3;
		for(int i = 0; i < 9 ; i++) {
			if(sdokupan[row][i] == value) {
				return false;
			}
		}
		for(int j = 0; j < 9 ; j++) {
			if(sdokupan[j][col] == value) {
				return false;
			}
		}
		for(int k = startHori ; k < startHori + 3 ; k++) {
			for(int l = startVerti ; l < startVerti + 3 ; l++) {
				if(sdokupan[k][l] == value) {
					return false;
				}
			}
		}
		return true;
	}
	public static void sdoku(int row, int col) {
		StringBuilder sb = new StringBuilder();
//		행의 열을 모두 찾았을 때 
		if(col == 9) {
			sdoku(row + 1, 0);
			return;
		}
//		완성 시 출력
		if(row == 9) {
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					sb.append(sdokupan[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if(sdokupan[row][col] == 0) {
//			1 ~ 9 중 들어갈 수 있는 값 찾기
			for(int i = 1 ; i <= 9 ; i++) {
				if(checkCell(row, col, i)) {
					sdokupan[row][col] = i;
//					다음 열의 값 찾기
					sdoku(row, col + 1);
				}
			}
//			빈칸이 많아 답을 못찾았을때 0으로 해 놓고 다른 것부터
			sdokupan[row][col] = 0;
			return;
		}
//		빈 값이 아닐 경우 다음 열 값 찾기
		sdoku(row, col + 1);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		입력
		for(int i = 0 ; i < 9 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 9 ; j++) {
				sdokupan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sdoku(0, 0);
	}
}
