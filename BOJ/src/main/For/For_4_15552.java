package main.For;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class For_4_15552 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int a = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < a ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

/*
 	원인 : 개행시 작은 따옴표사용
 	참고사항 : 
 	작은 따옴표 - +연산자와 사용시 Integer형으로 형변환하여 숫자로 표기
 	큰 따옴표 - 문자열로 인식하여 두 문자가 합쳐져서 결과 표기
 	따라서 문자열을 합칠경우 반드시 큰따옴표 사용하기!
 */
