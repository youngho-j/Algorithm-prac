package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrangement_3_2577 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int count = 0;
		
//		String result = String.valueOf(Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine()));
		String result = String.valueOf(a*b*c);
		for(int i = 0 ; i < 10 ; i++) {
			
			for(int j = 0 ; j < result.length() ; j++) {
				
				if(result.charAt(j)-'0' == i) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
			count = 0;
		}
		System.out.println(sb);
	}
}

/*
 * ������� : charAt(*��°�ڸ���)���� - '0' �Ǵ� -48�� �������� ���� ��� �ƽ�Ű�ڵ忡 �����ϴ� ���ڰ� ����
 * �迭�� ����� ��쵵 �ѹ� ������ �� ��!
*/
