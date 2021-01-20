package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class For_2_10950 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
			sb.append('\n');
		}
		System.out.println(sb);
		br.close();
	}
}

/*
	���� : �ѹ��� ����ϱ����� append�� �ִ°� ���� ��������, ���๮�ڸ� ������ �ʾƼ� ���ٷ� ��µ�.
	������� : 
	String - ���ο� ���� �Ҵ��Ҷ� ���� ������ / Ƚ���� ���������� �ּҰ��� stack�� ���̰� Ŭ������ heap�� ���������� ���� -> �޸� �������鿡�� ġ������
	StringBuffer - memory�� append�ϴ� ��� / Ŭ���� ���� �������� ���� 
	/ ���氡���� ���ڿ�, multiple threadȯ�濡�� ������ Ŭ���� / web�̳� ����ȯ��� ���� �񵿱� ������ ���� �� ����ϸ� ����
	StringBuilder - ���氡���� ���ڿ������� sychronization ���� x
*/