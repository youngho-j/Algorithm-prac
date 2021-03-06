package main.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Function_1_15596 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr  = new int[st.countTokens()];
		int count = 0;
		while(st.hasMoreTokens()) {
			arr[count] = Integer.parseInt(st.nextToken());
			count++;
		}
		long result = sum(arr);
		System.out.println(result);
	}
	public static long sum(int[] a) {
		long sum = 0;
		for(int i = 0 ; i < a.length ; i++) {
			sum += a[i];
		}
		return sum;
	}
}

/*
 * ���� : ���� Ŭ������ ���� duplicate(����) class ���� �߻� - �� ���Ͽ� ���� �̸��� ���� Ŭ���� 2�� ����� �߻�
 * class Main is public, should be declared in a file named Main.java - Ŭ�������� public���� ����Ǿ��µ� ���ϸ�� �ٸ� ���
 * 
 * ���ǻ��� : �Լ� �ۼ��� �Լ��� �ۼ��Ұ�.. ���� �Ĳ��� �б�.. ���ٰ� �� Ǯ�� �ʱ�
 * ������ ��� ��.. ���� n���� �־����� ��, n���� ���� ���ϴ� �Լ��� �ۼ��Ͻÿ�.
 * Java: long sum(int[] a); (Ŭ���� �̸�: Test)
 * a: ���� ���ؾ� �ϴ� ���� n���� ����Ǿ� �ִ� �迭 (0 �� a[i] �� 1,000,000, 1 �� n �� 3,000,000)
 * ���ϰ�: a�� ���ԵǾ� �ִ� ���� n���� ��
 */ 
