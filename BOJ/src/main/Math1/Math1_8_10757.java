package main.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Math1_8_10757 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		System.out.println(new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken())));
	}
}

/*
 * 시도 1. 런타임 에러 발생
 * 
 * 원인 : 값을 받고 long type으로 변환시 입력받은 값이 long 타입 범위보다 커서 에러가 난듯
 */

