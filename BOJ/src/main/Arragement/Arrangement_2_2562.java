package main.Arragement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrangement_2_2562 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int max = 0;
		int count = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) {
				max = arr[i];
				//�迭�� ù ������ 0�̹Ƿ� ������ ��Ÿ���� +1�� �ؾ���
				count = i+1;
			}
		}
		System.out.println(max + "\n" + count);
	}
}

/*
 * ������� :  �迭�� ���۹�ȣ�� 0���� ����!
 */
