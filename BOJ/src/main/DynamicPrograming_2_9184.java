package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_2_9184 {
//	����Լ� ���� ��  <= 0, > 20 �̹Ƿ� 0~20�� ���� ���� �����صθ� ��
	public static int[][][] memo = new int[21][21][21];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
//			�Է¹��� ���� ��� -1�϶� ����
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int w(int a, int b, int c) {
//		üũ���ִ� ������ ���� ��� �ԷµǴ� ���� ������ -50 ~ 50�̱� ������ 0 ~ 20���� �����Ǿ��ִ� �迭�� �������� ũ�Ƿ� �迭�ʰ������߻�
		if(check(a, b, c) && memo[a][b][c] != 0) {
			return memo[a][b][c];
		}
//		�Է¹��� ���� <= 0 �̸� ������ 1 ����
		if(a <= 0 || b <= 0 || c <= 0 ) {
			return 1;			
		}
//		�Է¹��� ���� > 20 �̸� ������ memo[20][20][20]�� ���� ���� ����
		if(a > 20 || b > 20 || c > 20) {
			return memo[20][20][20] = w(20, 20, 20);
		}
		if(a < b && b < c) {
			return memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		return memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
//	�迭�� ������ �Ѿ�� ��츦 üũ, �� ������ 0 ~ 20 ���̿� ���;���
	public static boolean check(int a, int b, int c) {
		return  a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
	}
}
