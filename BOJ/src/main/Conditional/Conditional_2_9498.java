package main.Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Conditional_2_9498 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		
		if(a >= 90) {
			System.out.println("A");						
		} else if(a >= 80) {
			System.out.println("B");			
		} else if(a >= 70) {
			System.out.println("C");			
		} else if(a >= 60) {
			System.out.println("D");			
		} else {
			System.out.println("F");
		}
		br.close();
	}
}

/*
	���� : BufferedReader close() �޼ҵ� 
	close() �޼ҵ� ���� ���� �ʾƵ� Garbage Collector�� ���� �ڵ� ������ 
	������, BufferedWriter�� ��� close() �޼ҵ带 �����ϰ� ���� ���� ��� writing �ȵǴ� ��� ����
	���� �ڿ� ���� ���鿡�� close() ���ִ� ������ ���̴°� ����
 */