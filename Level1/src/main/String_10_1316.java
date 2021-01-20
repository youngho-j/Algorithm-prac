package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_10_1316 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int wordCount = Integer.parseInt(br.readLine());
		int result = 0;

		for(int i = 0 ; i < wordCount ; i++) {
			if(wordCheck(br.readLine())) {
				result++;
			}
		}
		System.out.println(result);
	}
	// �ܾ �޾Ƽ� �׷�ܾ����� üũ�ϴ� �Լ�
	public static boolean wordCheck(String word) {
		// ���ĺ� �ߺ� ���� üũ �迭, �⺻�� false
		boolean[] bl = new boolean[26];
		// ���� ���ĺ� ���� ���� ����
		int pre = 0;
		//�ܾ� ���̸�ŭ ���鼭 ������ ���� ���ĺ� üũ
		for(int i = 0 ; i < word.length() ; i++) {
			// ���� ���ĺ� ���� ���� ����
			int now = word.charAt(i);
			// ���� ���ĺ� ���� ���� ���ĺ��� ���� ���� ��� or for�� ó�� �����ϴ� ���
			if(now != pre) {
				// ó�� ���� ��� �ش� ���ĺ��� �ش��ϴ� �迭�� ���� true�� �����ϰ� ���� ���� pre�� �����
				if(bl[now-'a'] == false) {
					bl[now-'a'] = true;
					pre = now;
				// �̹� ���� ���
				} else {
					return false;
				}
			}
		}
		// for���� ���� ��������� �׷��Լ��̹Ƿ� 
		return true;
	}
}

/*
 * ���� : ó�� ���� Ǯ���� int �迭�� �ߺ�Ƚ���� ��� ���Ϸ��� ������, ����� Ʋ����.. ����ó���� �ȵ� ��..
 * boolean �迭�� ���� ���ĺ��� �ߺ� ���� �������� �����Ͽ� �ٽ� Ǯ����.
 * 
 * ���� : �׷��Լ��� ���ĺ� ������ ������� �ش���ĺ��� ���������� ������ �Ǵ� ��� ��, ������ ���� ���ĺ��� �ڿ� �ٽ� ���� ���� �׷��Լ� �ƴ�.
 * Ex) aaaavvvvs, sevrt -> �׷��Լ� / sssvregs -> �׷��Լ� X 
 */
