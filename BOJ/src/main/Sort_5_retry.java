package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_5_retry {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		���ڿ��� ī���� �迭 ���� - ī���� �迭�� �� �ڸ����� �� �� �ִ� ���� 0 ~ 9�̹Ƿ� 10���� ����
		String str = br.readLine();
		int[] check = new int[10];
//		�� �ڸ����ڿ� �ش��ϴ� �迭 �ε����� ī����
		for(int i = 0 ; i < str.length() ; i++) {
			check[str.charAt(i) - '0']++;
		}
//		�������� �����̹Ƿ� �迭�� �ִ���� -1���� 0�϶����� �����ϸ鼭 stringbuilder�� �߰�
		for(int i = check.length-1 ; i >= 0 ; i--) {
//			�迭�� ī���� ���ڰ� 0�϶����� �ش� �ε�����ȣ�� �߰�
			while(check[i] > 0) {
				sb.append(i);
				check[i]--;
			}
		}
		System.out.println(sb);
	}
}
