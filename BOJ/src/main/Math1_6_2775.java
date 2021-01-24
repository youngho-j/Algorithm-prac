package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_6_2775 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//각 방마다 사람수를 구하기 위한 배열, 층 : 0~14, 호 : 1~14
		int [][] arr = new int[15][15];
		
		for(int i = 1 ; i < 15 ; i++) {
			arr[i][1] = 1; // 각층별 1호는 1명씩밖에 살지 않음
			arr[0][i] = i; // 0층의 i호에는 i명이 산다는 조건
		}
		
		//k층 n-1호 + 바로 k-1층 n 호 더하면 해당 층의 인원수 나옴
		for(int j = 1 ; j < 15 ; j++) {
			for(int k = 2 ; k < 15 ; k++) {
				arr[j][k] = arr[j][k-1] + arr[j-1][k]; 
			}
		}
		
		int count = Integer.parseInt(br.readLine());
		
		for(int l = 0 ; l < count ; l++) {
			int floor = Integer.parseInt(br.readLine());
			int room = Integer.parseInt(br.readLine());
			System.out.println(arr[floor][room]);
		}
	}
}

/*
 *  주의 사항 : 조건을 꼭 써두고 풀기.. 조건이 맞지 않아서 틀릴뻔 했음
 *  
 *  시도 1. 너무 세분화해서 더하려고 시도해서 어디서 부터 규칙을 찾아야되는지 시간을 많이 사용했음.. 
 *  
 *  참고 : 이중 배열 사용시 arr[i][j] i - 행 / j - 열
 */
