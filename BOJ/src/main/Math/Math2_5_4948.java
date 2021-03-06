package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_5_4948 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] primeArr;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			primeArr = new boolean[(2*n)+1]; 
			//0과 1은 소수가 아님
			primeArr[0] = primeArr[1] = true;
			
			for(int i = 2 ; i <= Math.sqrt((2*n)) ; i++) {
				if(primeArr[i]) {
					continue;
				}
				for(int j = i*i ; j <= (2*n) ; j += i) {
					primeArr[j] = true;
				}
			}
			int sum = 0;
			//n보다 크고 2n보다 작거나 같은 -> n < x <= 2n
			for(int k = n+1 ; k <= (2*n) ; k++){
				if(!primeArr[k]) {
					sum++;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
