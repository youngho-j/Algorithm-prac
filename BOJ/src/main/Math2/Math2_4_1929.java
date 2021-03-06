package main.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_4_1929 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		//�ش� �������� �Ҽ��� �Ǻ��� ���� ��� �迭 ����
		boolean[] primeArr = new boolean[N+1];
		// 0, 1�� �Ҽ��� �ƴϹǷ� true�� �ʱ�ȭ
		primeArr[0] = primeArr[1] = true;
		// ������ ��Ÿ����� �ش� �ڿ���N�� ��Ʈ���� �������� ��Ī�� �̷�Ƿ� ��N���� ���� ���鸸 ���ص���
		for(int i = 2 ; i <= Math.sqrt(N); i++) {
			//�ش� �迭�� ���� true ��, �Ҽ��� �ƴϸ� �Ʒ� �ڵ带 �������� �ʰ� �ѱ�
			if(primeArr[i]) {
				continue;
			}
			//��� ����, i*i �̸��� �̹� ó�� j�� ���۰��� i*i�� ����ȭ
			for(int j = i * i ; j <= N ; j += i) {
				primeArr[j] = true;
			}
		}
		//���
		for(int k = M ; k <= N ; k++) {
			if(!primeArr[k]) {
				sb.append(k).append("\n");
			}
		}
		System.out.println(sb);
	}
}
/*
 * ���� : �����佺�׳׽��� ü
 * ��κ��� �Ҽ������� �� �ڵ�� ó�� ����!
 */
