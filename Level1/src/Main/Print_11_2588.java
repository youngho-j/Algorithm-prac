package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print_11_2588 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		char[] sp = b.toCharArray();
		
		for(int i = b.length()-1 ; i >= 0  ; i--) {
			System.out.println(a * (sp[i]-'0'));
		}
		System.out.println(a * Integer.parseInt(b));
	}
}
/*
	���� : ��¼���, 1�ڸ����� �߾���ߴµ� ū�ڸ������� ����� �ؼ� 
	������� : String ���ڿ��� charAt �޼ҵ�� �ϳ��� ���� ���� �ʿ� ���� / toCharArray �޼ҵ� ����ϸ� ����.
	for�� ���ҽ� ���� �ε�ȣ ��ȣ �� Ȯ���Ұ�.. �ڲ� �ٲٴ°� ���Գ� ����!!
	ó�� �õ��������� for������ String�� charAt() �޼ҵ带 ����Ͽ� �迭�� ��� temp�� ��� ���� ���� ����Ϸ��� �߾��µ� �ʹ� �ڵ尡 �����..

	char -> int ��ȯ
	1. Character.getNumericValue(char Ÿ�� ����)
	2. char Ÿ�� ���� - '0'�� �ϴ� ����� ����!! 
	����� ����!
 */
