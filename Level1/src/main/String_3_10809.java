package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_3_10809 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alpha = new int[26];
		StringBuilder sb = new StringBuilder();
		//�迭 -1�� �ʱ�ȭ(���߿� ù ���� �־��ٶ� �˻��ϱ� ����)
		for(int i = 0 ; i < alpha.length ; i++) {
			alpha[i] = -1;
		}
		for(int i = 0 ; i < str.length() ; i++) {
			int n = (str.charAt(i) - 97);
			if(alpha[n] == -1) {
				alpha[n] = i;								
			} 
		}
		for(int j = 0 ; j < alpha.length ; j++) {
			sb.append(alpha[j]).append(" ");
		}
		System.out.println(sb);		
	}
}

/*
 * ���� : ��½� ���� -1�� �ʱ�ȭ�� �������� �ʰ� �����ߴ��� ���ڿ����� ó�� �����ϴ� ���ĺ� ��ġ�� �迭�� �ִ°��� �ƴ� ���߿� ���� �迭���� �ְԵ�
 * ������� : String class indexOf �޼ҵ� ����ؼ� �غ��� / ���� ������ �ش� ��ġ ���� ���� ��� -1 ����
 *  
 */
