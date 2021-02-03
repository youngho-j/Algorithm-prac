package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_4_11729 {	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ ��
		int N = Integer.parseInt(br.readLine());
		//�� �̵� Ƚ�� ���
		sb.append((int)(Math.pow(2, N) - 1)).append("\n");
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(sb);
	}
	public static void hanoi(int N, int start, int via, int end) {
		//���ݼ��� 1 �϶� (��������)
		if(N == 1) {
			sb.append(start + " " + end + "\n");
			System.out.println(start + " " + end + "�׽�Ʈ");
			return;
		}
		// N��° ����� ������ ����� A -> B�� �̵�
		hanoi(N-1, start, end, via);
		// N��° ������ A -> C�� �̵�
		sb.append(start + " " + end + "\n");
		System.out.println(start + " " + end + "�׽�Ʈ");
		// N��° ����� ������ ����� B -> C �̵�
		hanoi(N-1, via, start, end);
	}
}
