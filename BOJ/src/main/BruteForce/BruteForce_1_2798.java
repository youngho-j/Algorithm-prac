package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_1_2798 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int temp = 300000;
		
		int triple = 0;
		
		int result = 0;
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int[] card = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < N-2 ; i++) {
			for(int j = i + 1 ; j < N-1 ; j++) {
				for(int k = j + 1 ; k < N ; k++) {
					triple = sum(card[i], card[j], card[k]);
//					카드의 합이 M을 넘지 않아야함
					if(triple > M) {
						continue;
					} else if(temp > M - triple) {
						temp = M - triple;
						result = triple;
					}
				}
			}
		}
		
		System.out.println(result);
	}
	public static int sum(int a, int b, int c) {
		return a + b + c;
	}
}
