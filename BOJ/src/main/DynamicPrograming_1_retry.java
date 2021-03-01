package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_1_retry {
	/*
	 * �׽�Ʈ ���̽� ���� 
	 * �Ǻ���ġ ���� ���� �� 0�� 1�� ���� ���� 
	 * �ڿ����� ������ 0 ~ 40 
	 * ����� �������� �����Ͽ� ���
	 */
	public static int[][] fibo = new int[41][2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
//		�迭 -1�� �ʱ�ȭ(�⺻���� 0�̹Ƿ� �Լ��� 0�Է½� �߸��� �� ���� �� ����) 
		for(int i = 2 ; i < fibo.length ; i++) {
			for(int j = 0 ; j < fibo[i].length ; j++) {
				fibo[i][j] = -1;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(fibo[N][0] + " " + fibo[N][1] + "\n");
		}
		System.out.println(sb);
	}
	public static int[] fibonacci(int N) {
		if(fibo[N][0] == -1 || fibo[N][1] == -1) {
			fibo[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];
			fibo[N][1] = fibonacci(N-1)[1] + fibonacci(N-2)[1];
		}
		return fibo[N];
	}
}
