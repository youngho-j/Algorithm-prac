package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_2_2231 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int temp = 1000000;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= N ; i++) {
			int decomposition = 0;
			//���ڸ���
			if((i/10 == 0) && (i%10 < 10)) {
				decomposition = i + (i%10);
			//���ڸ���
			} else if((i/10 < 10) && (i%10 < 10)) {
				decomposition = i + (i/10) + (i%10);
			//���ڸ���
			} else if((i/10 < 100) && (i%10 < 10)) {
				decomposition = i + (i/100) + ((i%100)/10) + (i%10);
			//���ڸ���
			} else if((i/10 < 1000) && (i%10 < 10)) {
				decomposition = i + (i/1000) + ((i%1000)/100) + ((i%100)/10) + (i%10);				
			//�ټ��ڸ���
			} else if((i/10 < 10000) && (i%10 < 10)) {
				decomposition = i + (i/10000) + ((i%10000)/1000) + ((i%1000)/100) + ((i%100)/10) + (i%10);				
			//�����ڸ���				
			} else if((i/10 < 100000) && (i%10 < 10)) {
				decomposition = i + (i/100000) + ((i%100000)/10000) + ((i%10000)/1000) + ((i%1000)/100) + ((i%100)/10) + (i%10);				
			//�ִ�								
			} else {
				decomposition = i + (i/1000000)  + ((i%1000000)/100000) + ((i%100000)/10000) + ((i%10000)/1000) + ((i%1000)/100) + ((i%100)/10) + (i%10);								
			}
			if(decomposition < temp && decomposition == N) {
				temp = i;
			}
		}
		if(temp != 1000000) {
			System.out.println(temp);			
		} else {
			System.out.println(0);
		}
	}
}
