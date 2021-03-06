package main.While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class While_3_1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �ݺ�Ƚ�� üũ
		int count = 0;
		// ��ó�� ���� ���� ���� ����
		int input = Integer.parseInt(br.readLine());
		// ���ϱ� ���� ���� ���� ������ ����
		int copy = input;

		while (true) {
			input = ((input % 10) * 10) + (((input / 10) + (input % 10)) % 10);
			count++;
			if (copy == input)
				break;
		}
		System.out.println(count);
	}
}

/*
 * ���ǻ��� : ������ ���� �ѹ��� �����Ϸ��� ���� ����!
 * �κ����� ������ ��Ģ�� ã�ƺ���!!
 * �ش� ������ ���� �Է¹��� ���� ���ڸ��� or ���ڸ���
 * ���ڸ����� ��� ���� �ڸ��� 0�� �ٿ��� ���ѵ� ���������� �Ѱ��ְ�, ������ ���� �ڸ����� �������� �����ڸ����� �������� �����ڸ����� ��ģ���� ��ȯ
 * ���ڸ����� ��� ���� �ڸ��� �����ڸ��� ���ѵ� ���������� �Ѱ��ְ�, ������ ���� �ڸ����� �������� �����ڸ����� �������� �����ڸ����� ��ģ���� ��ȯ
 * 
 * ����, �������� ���� �ڸ����� ���ϱ� ���ؼ��� �Է¹��� ���� �������� ���� -> input%10
 * �� ���� ������ �����ڸ��� ��ȯ -> (input%10)*10
 * 
 * ������ ���� �ڸ����� ���ϱ� ���ؼ��� �ڸ������� ���� ���� ���������, �����ڸ��ϰ�� /10�� �ϰ�, �����ڸ��ϰ�� %10�� ���� ���������� ���� �˼�����
 * -> (input/10 + input%10)
 * ���� ���� �������� �� ���� ���ڸ��ϼ��� �ְ�, ���ڸ��ϼ��� �����Ƿ� %10�� ���� ���� ���� �ڸ����� ��Ÿ�� -> (input/10 + input%10)%10
 * 
 * �̷��� ���� ������ �� �� ����Ŭ ���� while�� �ۿ� �����س��� count ������ ++�� ���� Ƚ�� �߰�
 * 
 * �̷��� ������ ó������ ���� ��ȯ�� ���� ���������� �ݺ��Ǿ��ϹǷ� if���� ����Ͽ� ������ ������ ����Ȱ��� ������ while���� �������� �� �ֵ��� ��
 */