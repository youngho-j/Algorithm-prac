package main.Arragement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrangement_4_3052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		int[] count = new int[42];
		int df = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(br.readLine()) % 42;
			for(int k = 0 ; k < 42 ; k++) {
				if(arr[i] == k) {
					count[k]++;
				}
			}
		}
		
		for(int l = 0 ; l < count.length ; l++) {
			if(count[l] != 0) {
				df++;
			}
		}
		System.out.println(df);
	}
}
		
//		for(int i = 0 ; i < arr.length ; i++) {
//			arr[i] = Integer.parseInt(br.readLine()) % 42;
//			System.out.println(arr[i] + " <- " + i + "번째 나머지");
//		}
//		
//		for(int j = 0 ; j < arr.length ; j++) {
//			for(int k = 0 ; k < 42 ; k++) {
//				if(arr[j] == k) {
//					count[k]++;
//				}
//			}
//		}

/*
 * 원인 : 경우의 수를 적게 잡았음
 * 주의 사항 : 나머지를 계산하면 나머지의 최대값은 나눈 값의 -1 
 * 참고! : 배열을 하나만 써서 다시 풀어보기!!
 */
