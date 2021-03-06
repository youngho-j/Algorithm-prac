package main.Arragement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arragement_6_8958 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		String input = null;
		int sum = 0;
		
		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), "X");
			while(st.hasMoreTokens()){
                input = st.nextToken();
				for(int j = 1 ; j <= input.length() ; j++) {
					sum += j;
				}
            }
			sb.append(sum).append("\n");
			sum = 0;
		}
		System.out.println(sb);
	}
}

/*
 * ���� : ��Ÿ�� ���� - NoSuchElementException / ���� ��� do - while�� ���
 * ���� ������ ���� StringTokenizer�� X�� �����ڷ� ����߱⶧���� XXXXX..�ϰ�� nextToken�� �������� �ʾ� �߻��ϴ� ��
 * 
 * 
 		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), "X");
			do {
				input = st.nextToken();
				for(int j = 1 ; j <= input.length() ; j++) {
					sum += j;
				}
			} while (st.hasMoreTokens());
			sb.append(sum).append("\n");
			sum = 0;
		}
 * 
 * ���� ���� : do-while / while ����
 * do-while - do �߰�ȣ ����� �ѹ� ���� �� while �� ������ �˻��Ͽ� �ݺ� ���� -> ���๮ ���� �� ���� �˻�
 * while - while ������ true�� ��� �ش� ���๮�� �ݺ��Ͽ� ����
 * 
 * while�� ����ϴ� ���
 * ���� ������ Ư�� ���� �����ñ��� �ݺ� / �ַ� ���� �а� ����
 * 
 * for�� ����ϴ� ���
 * �ݺ�Ƚ�� ������ ��� / �迭�� �Բ� �ַ� ���
 */ 
