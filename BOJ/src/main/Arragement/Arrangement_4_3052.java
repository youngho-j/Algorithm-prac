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
//			System.out.println(arr[i] + " <- " + i + "��° ������");
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
 * ���� : ����� ���� ���� �����
 * ���� ���� : �������� ����ϸ� �������� �ִ밪�� ���� ���� -1 
 * ����! : �迭�� �ϳ��� �Ἥ �ٽ� Ǯ���!!
 */
