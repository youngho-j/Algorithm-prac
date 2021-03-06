package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_2_reBuild {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i = 1 ; i < N ; i++) {
			int decomposition = 0;
			int num = i;
			while(num != 0) {
				decomposition += num % 10;
				num /= 10;
			}
			if(decomposition + i == N) {
				result = i;
				break;
			} 
		}
		System.out.println(result);
	}
}
