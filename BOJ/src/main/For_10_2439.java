package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For_10_2439 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		
		//���� ����
		for(int i = 1 ; i <= a ; i++) {
			//��� ����
			for(int j = a ; j > 0 ; j--) {
				//j�� Ŭ��� ���� �ƴѰ�� * ���
				if(j > i) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

/*
 * ���� : ���� ���� / ���ҽ� ���� ���Ǻκ� ���� �� ��!
 * ���� �ִ� ������ ����, �� ��� ������ �ּҰ����� Ŀ����
 * 
 * ������� : �⺻������� ���������� ��� ������ ���� �ϳ���� ���ؼ��� ������ 4ĭ �ʿ��� 
 * �� �Ʒ����� ��� ���� 3ĭ �ʿ� ��, ���� ������������ ������ ��ĭ�� �پ��
 * 
 * 
 */