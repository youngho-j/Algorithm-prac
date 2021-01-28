package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_3_11653 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		//1�� �Ҽ��� �ƴϹǷ� 2���� ����
		//N�� ��� i�� ������ ���� �����Ƿ� ��N ���� ������ N�� ó���ϱ� �� ���� ���� i^2 
		for(int i = 2 ; i * i <= N ; i++) {
			while(N % i == 0) {
				sb.append(i).append("\n");
				N /= i;
			}
		}
		// N�� 1�� ��� �ƹ��͵� ������� ����, 1�� �ƴѰ��� ����ؾ��ϹǷ�, �� ���Ŀ��� ���� 1�̾ƴ� ������N�� ���
		if(N != 1) {
			sb.append(N);
		}
		System.out.println(sb);
	}
}
/*
	
	���� : ������ ���� N�� ���Ͽ� �������� �����ϸ� ��N�� �������� ��Ī�̵�.
	      Ex) 12 -> 1, 2, 3, ��12(3.4641016...), 4, 6, 12
	      ���� ��N ������ �������� ��(i)�� ���ϰ� �Ǹ� �ڿ������� ��Ī�Ǵ� ���� �� �� ���� N = i * X
	      ��, i^2 �� N ������ �� ������ Ž���ص� �ȴ�. 
	      
	���μ� ���� - �ڿ����� ���μ����� ������ ǥ�� 
	* �ڿ��� n�� ��� = �ڿ��� n�� �μ�
	* �μ� �� �Ҽ� -> ���μ�
*/