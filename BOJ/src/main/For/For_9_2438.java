package main.For;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For_9_2438 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= a ; i++) {
			for(int j = 1 ; j<=i ; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
