package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_5_1436 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		int count = 1;

		while(count != N) {
			num++;
			if(String.valueOf(num).contains("666")){
				count++;
			}
		}
		System.out.println(num);
	}
}
/*
 * String.contains("sd")
 * 해당 문자열에 sd라는 문자열이 있는지 없는지 boolean값 리턴
 */
