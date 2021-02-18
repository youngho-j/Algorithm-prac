package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backtracking_6_9663 {
	
	public static int[] arr;
	
	public static int N, count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		/*
		 * ü���� - �迭�� �ε��� ��ȣ�� ��, �ε��� ��ȣ�� �ش��ϴ� ���� ������ ���� 
		 * Ex) arr[1] = 2; -> 1���� 3��° ��
		 */
		arr = new int[N];
//		N �� N ü���ǿ� ���� �������� �ʵ��� N���� �� ����(���� �����¿�, �밢�� �Ÿ� ���� x)
		nQueen(0);
		
		System.out.println(count);
	}
	
	public static void nQueen(int depth) {
//		���� N���� �Ǿ�����
		if(depth == N) {
			count++;
			return;
		}
//		�� ���� 
		for(int i = 0 ; i < N ; i++) {
			arr[depth] = i;
//			���� ���� �� �ڸ� ã��
			if(doubleCheck(depth)) {
//				��͸� ���� ���� ���� ����
				nQueen(depth + 1);
			}
		}
	}
	
	public static boolean doubleCheck(int col) {
		for(int i = 0 ; i < col ; i++) {
//			���� ��� ���� ��ġ�� ���
			if(arr[col] == arr[i]) {
				return false;
//			�밢���� ��ġ�� ���
			} else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
