package main.For;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class For_6_2742 {
public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		br.close();
		
		for(int i = a ; i > 0 ; i--) {
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}
}

/*
 	원인 : for문 감소식 사용시 증가부분 --로 감소 형태로 바꾸기 / 부등호 조건 조심!
 	
 */
