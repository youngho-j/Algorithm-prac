package main.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_9_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int len = str.length();
		int count = 0;

		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'c' && i < len - 1) {
				if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
					i++;
				}
			} else if (str.charAt(i) == 'd' && i < len - 1) {
				if (str.charAt(i + 1) == '-') {
					i++;
				} else if (str.charAt(i + 1) == 'z' && i < len - 2) {
					if (str.charAt(i + 2) == '=') {
						i += 2;
					}
				}
			} else if ((str.charAt(i) == 'l' || str.charAt(i) == 'n') && i < len - 1) {
				if (str.charAt(i + 1) == 'j') {
					i++;
				}
			} else if ((str.charAt(i) == 's' || str.charAt(i) == 'z') && i < len - 1) {
				if (str.charAt(i + 1) == '=') {
					i++;
				}
			}
			count++;
		}
		System.out.println(count);
	}
}

/*
 * ���� : StringIndexOutBounds - ���ڿ��� ������� ū ��� �߻�
 * �� �� �ڵ���� ���̴ٰ� ��Ÿ�� ����('-' �����ϴ� ������ '=' ���� �ΰ�����... ��) ����
 * �����ҽ� ������ߴµ��� �ȳ��Դµ�.. ��Ż�� �� ����!
 *
 *
 */
