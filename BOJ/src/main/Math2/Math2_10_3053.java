package main.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_10_3053 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double r = Double.parseDouble(br.readLine());
		System.out.println(r * r * Math.PI);
		System.out.println(2 * r * r);
	}
}

/*
 * 참고 : 
 * 택시 기하학 원 넓이 : 1/2 * r * r * 4(4분면이므로) => 2 * r * r
 * 유클리드 기하학 원 넓이 : r * r * PI
 */
