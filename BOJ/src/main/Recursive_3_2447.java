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
		
//		���
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void printStar(int x, int y, int num, boolean blank) {
//		����ä���
		if(blank) {
			for(int i = x ; i < x + num ; i++) {
				for(int j = y ; j < y + num ; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
//		�����
		if(num == 1) {
			arr[x][y] = '*';
			return;
		}
//		�־��� ���� ����� ������ 
//		ex) num = 9 �� ��� size = 3  * * *
//									*   *
//									* * *
		int size = num / 3;
//		������ �� ��ġ ī��Ʈ
		int count = 0;
		
		for(int i = x ; i < x + num ; i += size) {
			for(int j = y ; j < y + num ; j += size) {
				count++;
//				����� �߽� ����� ��� 
				if(count == 5) {
					printStar(i, j, size, true);
				} else {
					printStar(i, j, size, false);					
				}
			}
		}
	}
}
