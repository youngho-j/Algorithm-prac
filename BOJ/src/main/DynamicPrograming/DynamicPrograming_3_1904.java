package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_3_1904 {
	//�Է� ���� ���� 
	static int[] memo = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// Ÿ�� �������� ���� �� �ִ� ����� �� memo�� �߰�
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		// 0�� �����ϱ� ���� ������ �𸣴� ���� -1�� �ʱ�ȭ
		for(int i = 3 ; i < memo.length ; i++) {
			memo[i] = -1;
		}
		System.out.println(count(N));
	}
	
	public static int count(int N) {
		// ���ռ��� �� ��� ��ȭ������ ���ϰ� �޸������̼�
		if(memo[N] == -1) {
			memo[N] = (count(N-1) + count(N-2)) % 15746;
		}
		// ���ռ��� �ƴ� ��� �迭���� ������
		return memo[N];
	}
}
