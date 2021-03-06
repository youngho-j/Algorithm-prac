package main.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_7_2908 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String[] arr = new String[2];
		int cnt = 0;
		while(st.hasMoreTokens()) {
			int number = Integer.parseInt(st.nextToken());
			int h = number/100;
			int t = (number/10)%10;
			int u = number%10;
			arr[cnt] = String.valueOf(u) + String.valueOf(t) + String.valueOf(h);
			cnt++;
		}
		if(Integer.parseInt(arr[0]) > Integer.parseInt(arr[1])) {
			System.out.println(arr[0]);
		} else {
			System.out.println(arr[1]);			
		}
	}
}
/*
 * ������� : StringBuilder Ŭ������ reverse() �޼ҵ� - ����Ǿ��ִ� ���ڿ� ������.
 */
