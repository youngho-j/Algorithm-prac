package main.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Function_3_1065 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(check(Integer.parseInt(br.readLine())));
		
	}
	public static int check(int number) {
		//�Ѽ� ���� ī����
		int cnt = 0;
		// 1 ~ 99������ ��� �Ѽ�
		if(number < 100) {
			return number;
		// 101 �̻� ���ʹ� �˻� �ʿ�
		} else {
			// 1 ~ 99 ���� ��� �Ѽ��̹Ƿ� 99���� �ʱ�ȭ
			cnt = 99;
			// 1000�� ���� ��� ������ �Ѽ� �ƴ�.. ���� ���� 101 ~ 999�� ���ڸ����� ���ϸ� ��
			if(number == 1000) {
				number = 999;
			}
			//101���� �ش簪���� for�� �ݺ�
			for(int i = 100 ; i <= number ; i++) {
				int units = i%10;
				int tens = (i/10)%10;
				int hundreds = i/100;
				if((hundreds - tens) == (tens - units)) {
					cnt++;
				}
			}
			
		}
		return cnt;
	}
}
/*
 * ���� : �Ѽ� ������ �ľ��Ҷ� 1 ~ 99������ ��� �Ѽ��̹Ƿ� 99���� ��������� 
 * if(number < 101) { �� �κп��� 100�� ���ð�� �Ѽ��� ������ 100�� �ǹǷ� Ʋ�ȴٰ� ����..
 * ����, �Ѽ� �ľ��� �Ҷ� ������ 1 ~ 99 / 100 ~ 1000 (1000�� ���ð�� 999�� ���ڸ�ȭ)�� �����Ͽ� ����
 * 
 * ���� ���� : ���������� �����ϴ� �� ���� ���̰� ��� ������ ����
 * 			-> 1 ~ 9 ���� �ϳ� �� ��ü�� ������ ���� / 10 ~ 99 �� �ڸ����� ���� ����(����� ����)�̰� �� �� ��ü�� ������ ����
			� ���� ���� X�� �� �ڸ��� ���� ������ �̷� -> �Ѽ�
 */
