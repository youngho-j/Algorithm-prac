package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Print_5_1000 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//		System.out.println(A+B);
//		sc.close();
		
		//���ٷ� �о�� �� �ֵ��� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ �������� ���� �迭�� ����
		String[] str = br.readLine().split(" ");
		//parseInt �޼ҵ� ����Ͽ� ���ڿ��� ������ ��ȯ
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		
		System.out.println(a+b);
	}
}
/*
	���� : ���� �����ϱ�
	�� �� ���� �� Ư�� �Էºκп� A�� 0���� ũ��, B�� 10���� �۾ƾ��Ѵٰ� �ؼ� ������ �־��ٰ� Ʋ��..
	���� �Է�1 ���� ���1�κ��� ����� ���а� �ι� ����ؼ� Ʋ��.. ���� �ȹٷ� ���� Ǯ��
	
	���ǻ��� : Scanner Ŭ���� Sysetem.in ���°� ����� ����.. �׸��� ���� �����Ұ�!
	scanner Ŭ�������� BufferedReader�� ����ð��� �ξ� ����! 
*/