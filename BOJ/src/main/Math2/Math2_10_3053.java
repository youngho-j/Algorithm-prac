package main.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_10_3053 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double r = Double.parseDouble(br.readLine());
		System.out.println(r * r * Math.PI);
		System.out.println(2 * r * r);
	}
}

/*
 * ���� : 
 * �ý� ������ �� ���� : 1/2 * r * r * 4(4�и��̹Ƿ�) => 2 * r * r
 * ��Ŭ���� ������ �� ���� : r * r * PI
 */
