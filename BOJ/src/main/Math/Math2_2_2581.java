package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_2_2581 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//�ּҰ��� ���ϱ����� ��ȿ������ ���� ū ������ ����
		int minPrime = 10000;
		// �Ҽ��� �������� ���� ��� -1�� ��°� �Ҽ��� ���� ���� 0���� �ʱ�ȭ
		int sumPrime = 0;
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		//�ش� ������ ���鼭 �Ҽ� �˻�
		for(int i = M ; i <= N ; i++) {
			boolean isPrime = true;
			//1�� �Ҽ��� �ƴϹǷ�
			if(i == 1) {
				continue;
			}
			
			for(int j = 2 ; j <= Math.sqrt(i) ; j++) {
				//����� ������ ���
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			//�Ҽ��϶� �Ҽ� �� �ּҰ��� ���� ����
			if(isPrime) {
				if(minPrime > i) {
					minPrime = i;
				}
				sumPrime += i;
			}
		}
		// �Ҽ��� ���� ��� -1, ������ ��� �Ҽ��� �հ� �ּ� �Ҽ� ���
		if(sumPrime == 0) {
			System.out.println(-1);
		} else {
			sb.append(sumPrime).append("\n").append(minPrime);
			System.out.println(sb);
		}
	}
}
