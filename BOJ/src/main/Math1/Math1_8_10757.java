package main.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Math1_8_10757 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		System.out.println(new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken())));
	}
}

/*
 * �õ� 1. ��Ÿ�� ���� �߻�
 * 
 * ���� : ���� �ް� long type���� ��ȯ�� �Է¹��� ���� long Ÿ�� �������� Ŀ�� ������ ����
 */

