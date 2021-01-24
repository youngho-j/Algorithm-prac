package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_6_2775 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�� �渶�� ������� ���ϱ� ���� �迭, �� : 0~14, ȣ : 1~14
		int [][] arr = new int[15][15];
		
		for(int i = 1 ; i < 15 ; i++) {
			arr[i][1] = 1; // ������ 1ȣ�� 1���ۿ� ���� ����
			arr[0][i] = i; // 0���� iȣ���� i���� ��ٴ� ����
		}
		
		//k�� n-1ȣ + �ٷ� k-1�� n ȣ ���ϸ� �ش� ���� �ο��� ����
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
 *  ���� ���� : ������ �� ��ΰ� Ǯ��.. ������ ���� �ʾƼ� Ʋ���� ����
 *  
 *  �õ� 1. �ʹ� ����ȭ�ؼ� ���Ϸ��� �õ��ؼ� ��� ���� ��Ģ�� ã�ƾߵǴ��� �ð��� ���� �������.. 
 *  
 *  ���� : ���� �迭 ���� arr[i][j] i - �� / j - ��
 */
