package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For_3_8393 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		br.close();
		
		int sum = 0;
		
		for(int i = 1 ; i <= a ; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
