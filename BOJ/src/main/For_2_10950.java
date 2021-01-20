package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class For_2_10950 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
			sb.append('\n');
		}
		System.out.println(sb);
		br.close();
	}
}

/*
	원인 : 한번에 출력하기위해 append에 넣는것 까진 좋았으나, 개행문자를 붙이지 않아서 한줄로 출력됨.
	참고사항 : 
	String - 새로운 값을 할당할때 새로 생성됨 / 횟수가 많아질수록 주소값이 stack에 쌀이고 클래스는 heap에 지속적으로 쌓임 -> 메모리 관리측면에서 치명적임
	StringBuffer - memory에 append하는 방식 / 클래스 직접 생성하지 않음 
	/ 변경가능한 문자열, multiple thread환경에서 안전한 클래스 / web이나 소켓환경과 같이 비동기 동작이 많을 때 사용하면 좋음
	StringBuilder - 변경가능한 문자열이지만 sychronization 적용 x
*/