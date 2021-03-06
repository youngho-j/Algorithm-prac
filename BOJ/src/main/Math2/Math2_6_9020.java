package main.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_6_9020 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10001];
		
		prime[0] = prime[1] = true;
		
		for(int j = 2 ; j <= Math.sqrt(10000) ; j++) {
			if(prime[j]) {
				continue;
			}
			for(int k = j * j ; k <= 10000 ; k += j) {
				prime[k] =true;
			}
		}
		
		for(int i = 0 ; i < testCase ; i++) {
			int n = Integer.parseInt(br.readLine());
			
			//n������ �Ҽ��� ��� ����, ��Ģ�� �������� �տ� ��µǾ��ϹǷ� ������ ������ �˻�
			//�������� ũ�� Ŭ���� ū���� �۾��� -> ���̰� ���� �۾�����.
			//n-�������� �Ҽ��ϰ�� ���
			for(int l = (n/2) ; l > 1 ; l--) {
				if(prime[l]) {
					continue;
				}
				if(!prime[n-l]) {
					sb.append(l).append(" ").append((n-l)).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
/*
 * ���� : ��Ģ�� ã������ �ϻ��������� �ϴ� ��Ʈ�� ����������
 * �����佺�׳׽��� ü ���� 
 * �õ� 1. testCase Ƚ����ŭ �ش� �ڿ��� n �Ҽ��� ã�� ü�� ���� -> �׽�Ʈ���̽����� for���� �����ϴ� �ӵ��� ����..
 * �õ� 2. �������� ���������� �ش��ϴ� 10000���� ��ü �Ҽ��� ���� ã�� -> testCase���� ������ �����Ͽ� ���  
 */
