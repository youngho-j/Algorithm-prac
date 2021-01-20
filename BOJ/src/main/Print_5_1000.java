package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Print_5_1000 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//		System.out.println(A+B);
//		sc.close();
		
		//한줄로 읽어올 수 있도록 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//공백을 기준으로 나눠 배열에 저장
		String[] str = br.readLine().split(" ");
		//parseInt 메소드 사용하여 문자열을 정수롤 변환
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		
		System.out.println(a+b);
	}
}
/*
	원인 : 공백 주의하기
	그 외 조건 중 특히 입력부분에 A가 0보다 크고, B가 10보다 작아야한다고 해서 조건을 넣었다가 틀림..
	예제 입력1 예제 출력1부분을 제대로 안읽고 두번 출력해서 틀림.. 문제 똑바로 보고 풀기
	
	주의사항 : Scanner 클래스 Sysetem.in 쓰는거 까먹지 말기.. 그리고 공백 주의할것!
	scanner 클래스보다 BufferedReader가 수행시간이 훨씬 빠름! 
*/