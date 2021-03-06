package main.Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Conditonal_5_2884 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if((h >= 0) && (m >= 45)) {
			System.out.println(h + " " + (m-45));
		} else if((h > 0) && (m < 45)) {
			System.out.println((h-1) + " " + (m-45+60));
		} else if((h == 0) && (m < 45)) {
			System.out.println((h-1+24) + " " + (m-45+60));			
		}
	}
}

/*
	���ǻ��� : ����Ǽ� üũ�ϱ�! 
	�ð� 0 <= h <= 23 / �� 0 <= m <= 59
 */
