package main.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_5_1157 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�޾ƿ� ���ڸ� �빮�ڷ� ����
		String str = br.readLine().toUpperCase();
		//���ĺ� ���� ������ ���� �迭
		int[] alpha = new int[26];
		//���ĺ� �ִ� ����
		int max = 0;
		//�ִ� ������ ���� ���ĺ� �ߺ�����
		int maxCount = 0;
		//���ĺ� �빮�� ����� ���� ����
		int alphabet = 0;
		
		//�迭�� ���ĺ� ������ ����
		for(int i = 0 ; i < str.length() ; i++) {
			int n = str.charAt(i) - 'A';
			alpha[n]++;
		}
		
		//���ĺ� �ִ밳���� ���ĺ� �빮�ڸ� ����
		for(int j = 0 ; j < alpha.length ; j++) {
			if(alpha[j] > max) {
				max = alpha[j];
				alphabet = j;
			}
		}
		//���ĺ� �ִ밳���� ��ġ���� Ȯ��
		for(int k = 0 ; k < alpha.length ; k++) {
			if(max == alpha[k]) {
				maxCount++;
			}
		}
		//���
		if(maxCount > 1) {
			System.out.println("?");
		} else if(maxCount == 1){
			System.out.println((char)(alphabet + 'A'));
		}
	}
}
/*
	�ڵ� �� �ٿ�����
*/