package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backtracking_g_2661_1 {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �Է� - ���� N �ϳ��� �̷����, ������ 1 <= N <= 80
		N = Integer.parseInt(br.readLine());
		// ���� ���� �߿��� �������� ã�ƾ� �ϹǷ�, 1�� �����Ҷ� ���� ������ ���� ���� �� �� ����
		find("1");
	}
	
	static void find(String str) {
		// 1�� ������ �Ͽ� ���� ������ ã���Ƿ�, ���� ó���� ���� ���� ���� ����
		// ����, �ش� ���� ������ ��¼� ����
		if(str.length() == N) {
			System.out.println(str);
			System.exit(0);
		} else {
			// ���� ������ ã���� for���� ���� �����ڸ����� ���� ������ �־� �˻��� �� �ֵ��� ��
			for(int i = 1 ; i <= 3 ; i++) {
				// ������ ���̰� �������� �˻� �� �������� ���� ��� ���� �ڸ����� ���ϱ� ���� ���
				if(check(str + i)) {
					find(str + i);
				}
			}
		}
	}
	
	static boolean check(String str) {
		int len = str.length();
		String front = "";
		String back = "";
		
		for(int i = 1 ; i <= len/2 ; i++) {
			front = str.substring(len - i * 2, len - i);
			back = str.substring(len - i, len);
			// �ѹ��̶� ��ġ�� �ȵǹǷ� for���� ���鼭 �� �ڸ������� �������� ���� �� �ֵ�����
			if(front.equals(back)) {
				return false;
			}
		}
		return true;
	}
}
