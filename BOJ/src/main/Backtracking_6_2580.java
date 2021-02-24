package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_6_2580 {
	public static int[][] sdokupan = new int[9][9];
//	�� ĭ�� �� ���� �ߺ��Ǵ� ��� false�� ���������ν� �ߺ����� ������ �˻�
	public static boolean checkCell(int row, int col, int value) {
//		�ڽ� 3��3 ������ ���� ���� ���۰�
		int startHori = (row/3)*3;
		int startVerti = (col/3)*3;
		
//		���� ����
		for(int i = 0; i < 9 ; i++) {
			if(sdokupan[row][i] == value) {
				return false;
			}
		}
//		���� ����
		for(int j = 0; j < 9 ; j++) {
			if(sdokupan[j][col] == value) {
				return false;
			}
		}
//		�ڽ� 3��3 ����
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
//		���� ���� ��� ã���� �� 
		if(col == 9) {
			sdoku(row + 1, 0);
			return;
		}
//		�ϼ� �� ���
		if(row == 9) {
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					sb.append(sdokupan[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
/*			 ù��°�� ���� ���������� ����ϰ� ���� ����!
 *			 System Ŭ������ exit() �޼ҵ带 ����Ͽ� ���������� JVM�� ���� () �ȿ��� ���� ���°��� ��
 * 			 �Ϲ������� 0�� �������� / ����������� 0�̿��� �ٸ���
 */
			System.exit(0);
		}
		if(sdokupan[row][col] == 0) {
//			1 ~ 9 �� �� �� �ִ� �� ã��
			for(int i = 1 ; i <= 9 ; i++) {
				// 1 ~ 9 ���� �� ������ ������ Ȯ��
				if(checkCell(row, col, i)) {
					// ������ ��� �ش� �� ����
					sdokupan[row][col] = i;
//					���� ���� �� ã��(���)
					sdoku(row, col + 1);
				}
			}
//			������ ���� ���� ��� 0���� ���� �� �Լ� ����
			sdokupan[row][col] = 0;
			return;
		}
//		�� ���� �ƴ� ��� ���� �� �� ã��
		sdoku(row, col + 1);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		�Է�
		for(int i = 0 ; i < 9 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 9 ; j++) {
				sdokupan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		ó�� ������ x : 0, y : 0�̹Ƿ�
		sdoku(0, 0);
	}
}
