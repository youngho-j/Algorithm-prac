package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_6_2580 {
	public static int[][] sdokupan = new int[9][9];
//	빈 칸에 들어갈 값이 중복되는 경우 false를 리런함으로써 중복값이 없도록 검사
	public static boolean checkCell(int row, int col, int value) {
//		박스 3×3 조건의 가로 세로 시작값
		int startHori = (row/3)*3;
		int startVerti = (col/3)*3;
		
//		가로 조건
		for(int i = 0; i < 9 ; i++) {
			if(sdokupan[row][i] == value) {
				return false;
			}
		}
//		세로 조건
		for(int j = 0; j < 9 ; j++) {
			if(sdokupan[j][col] == value) {
				return false;
			}
		}
//		박스 3×3 조건
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
			
/*			 첫번째로 나온 스도쿠판을 출력하고 강제 종료!
 *			 System 클래스의 exit() 메소드를 사용하여 강제적으로 JVM을 종료 () 안에는 종료 상태값이 들어감
 * 			 일반적으로 0은 정상종료 / 비정상종료는 0이외의 다른값
 */
			System.exit(0);
		}
		if(sdokupan[row][col] == 0) {
//			1 ~ 9 중 들어갈 수 있는 값 찾기
			for(int i = 1 ; i <= 9 ; i++) {
				// 1 ~ 9 숫자 중 가능한 값인지 확인
				if(checkCell(row, col, i)) {
					// 가능한 경우 해당 값 대입
					sdokupan[row][col] = i;
//					다음 열의 값 찾기(재귀)
					sdoku(row, col + 1);
				}
			}
//			가능한 값이 없는 경우 0으로 변경 후 함수 종료
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
//		처음 시작이 x : 0, y : 0이므로
		sdoku(0, 0);
	}
}
