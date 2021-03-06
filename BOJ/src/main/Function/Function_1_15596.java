package main.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Function_1_15596 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr  = new int[st.countTokens()];
		int count = 0;
		while(st.hasMoreTokens()) {
			arr[count] = Integer.parseInt(st.nextToken());
			count++;
		}
		long result = sum(arr);
		System.out.println(result);
	}
	public static long sum(int[] a) {
		long sum = 0;
		for(int i = 0 ; i < a.length ; i++) {
			sum += a[i];
		}
		return sum;
	}
}

/*
 * 원인 : 메인 클래스가 겹쳐 duplicate(복제) class 에러 발생 - 한 파일에 같은 이름을 가진 클래스 2개 존재시 발생
 * class Main is public, should be declared in a file named Main.java - 클래스명이 public으로 선언되었는데 파일명과 다를 경우
 * 
 * 주의사항 : 함수 작성시 함수만 작성할것.. 문제 꼼꼼히 읽기.. 쉽다고 막 풀지 않기
 * 문제에 명시 됨.. 정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.
 * Java: long sum(int[] a); (클래스 이름: Test)
 * a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
 * 리턴값: a에 포함되어 있는 정수 n개의 합
 */ 
