package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_1_1003 {
	
	/*
	 * ����� ����� �����ϴ� �迭 
	 * arr[1][0]; -> N�� 1�϶� 0�� ���� Ƚ�� 
	 * arr[1][1]; -> N�� 1�϶� 1�� ���� Ƚ��
	 */
	public static Integer[][] arr = new Integer[41][2];	
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		//N�� 0�϶� 0, 1 ȣ�� Ƚ��
		arr[0][0] = 1;
		arr[0][1] = 0;
		
		//N�� 1�϶� 0, 1 ȣ�� Ƚ��
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(arr[N][0] + " " + arr[N][1]).append("\n");
		}
		System.out.println(sb);
	}
	public static Integer[] fibonacci(int N) {
//		���� ��� ���� ��� ��, Ž������ ���� ���
		if(arr[N][0] == null || arr[N][1] == null) {
//			N�� ���� 0�� 1 ȣ�� Ƚ���� ��͸� ���� ���� ������
			arr[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			arr[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
//		N�� ���� 0�� 1�� ȣ�� Ƚ���� ���� arr[N] ����
		return arr[N];
	}
}
