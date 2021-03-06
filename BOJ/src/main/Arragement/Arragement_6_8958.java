package main.Arragement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arragement_6_8958 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		String input = null;
		int sum = 0;
		
		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), "X");
			while(st.hasMoreTokens()){
                input = st.nextToken();
				for(int j = 1 ; j <= input.length() ; j++) {
					sum += j;
				}
            }
			sb.append(sum).append("\n");
			sum = 0;
		}
		System.out.println(sb);
	}
}

/*
 * 원인 : 런타임 에러 - NoSuchElementException / 제출 당시 do - while문 사용
 * 내가 생각한 원인 StringTokenizer로 X를 구분자로 사용했기때문에 XXXXX..일경우 nextToken이 존재하지 않아 발생하는 듯
 * 
 * 
 		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), "X");
			do {
				input = st.nextToken();
				for(int j = 1 ; j <= input.length() ; j++) {
					sum += j;
				}
			} while (st.hasMoreTokens());
			sb.append(sum).append("\n");
			sum = 0;
		}
 * 
 * 참고 사항 : do-while / while 차이
 * do-while - do 중괄호 블록을 한번 실행 후 while 옆 조건을 검사하여 반복 결정 -> 실행문 실행 후 조건 검사
 * while - while 조건이 true일 경우 해당 실행문을 반복하여 실행
 * 
 * while문 사용하는 경우
 * 무한 루프나 특정 조건 만족시까지 반복 / 주로 파일 읽고 쓰기
 * 
 * for문 사용하는 경우
 * 반복횟수 정해진 경우 / 배열과 함께 주로 사용
 */ 
