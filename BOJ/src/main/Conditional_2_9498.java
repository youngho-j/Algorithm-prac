package main;

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
	참고 : BufferedReader close() 메소드 
	close() 메소드 명시 하지 않아도 Garbage Collector에 의해 자동 정리됨 
	하지만, BufferedWriter의 경우 close() 메소드를 적절하게 하지 않을 경우 writing 안되는 경우 많음
	따라서 자원 관리 측면에서 close() 해주는 습관을 들이는게 좋음
 */
