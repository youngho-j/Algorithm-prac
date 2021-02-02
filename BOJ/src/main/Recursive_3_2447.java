package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_3_2447 {
	
	static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		printStar(0, 0, N, false);
		
//		출력
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void printStar(int x, int y, int num, boolean blank) {
//		공백채우기
		if(blank) {
			for(int i = x ; i < x + num ; i++) {
				for(int j = y ; j < y + num ; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
//		별찍기
		if(num == 1) {
			arr[x][y] = '*';
			return;
		}
//		주어진 수의 블록의 사이즈 
//		ex) num = 9 일 경우 size = 3  * * *
//									*   *
//									* * *
		int size = num / 3;
//		공백이 들어간 위치 카운트
		int count = 0;
		
		for(int i = x ; i < x + num ; i += size) {
			for(int j = y ; j < y + num ; j += size) {
				count++;
//				블록이 중심 블록일 경우 
				if(count == 5) {
					printStar(i, j, size, true);
				} else {
					printStar(i, j, size, false);					
				}
			}
		}
	}
}
