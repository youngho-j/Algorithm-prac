package main.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Math1_1_1712 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// �������
		int fixed = Integer.parseInt(st.nextToken());
		// ������� - 1�� ���� 
		int variable = Integer.parseInt(st.nextToken());
		// �ǸŰ��� - 1�� �ǸŰ���
		int selling = Integer.parseInt(st.nextToken());
		
		if(variable >= selling) {
			System.out.println(-1);
		} else {
			System.out.println((fixed/(selling-variable))+1);
		}
	}
}
/*
 * ���� : �Ϲ����� ������ ���ð�� Ư��, ������ ������� �� ����ǳ� ���ж�� ��..
 * ����ó���� ���� ���� �־������� ������ ������.
 * ���� �� A,B,C�� 21�� ������ �ڿ����̴�. ��� ���� �־ 2000000000�� �ְ� �׽�Ʈ�� 1�� ��µ�
 * int ������ �ʰ��Ǿ� �ش� ������ Ʋ�ȴٰ� ��µǴ� �� ����
 * 
 * ���� ���� : n * selling = fixed + (n * variable) = ���ͺб���
 * �����̳��� ������ ã�ƾ��ϹǷ� +1�� ���־����! (�������� Ʋ��.. ���ٰ� �÷ȴٰ� �̰Ŷ����� �� Ʋ��.. ��)
 * 
 * ó�� Ǭ �ڵ�
 * 	public static int breakPoint(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		// �������
		int fixed = Integer.parseInt(st.nextToken());
		// ������� - 1�� ���� 
		int variable = Integer.parseInt(st.nextToken());
		// �Ѻ�� - ������� + �������(�����) 
		int total = fixed;
		// �ǸŰ��� - 1�� �ǸŰ���
		int selling = Integer.parseInt(st.nextToken());
		// �Ѽ��� 
		int revenue = 0;
		// ���ͺб���
		int count = 0;
		
		while(revenue <= total) {
			if(variable >= selling) {
				count = -1;
				break;
			} else {
				total += variable;
				revenue += selling;
				count++;				
			}
		}
		return count;
	}
 */
