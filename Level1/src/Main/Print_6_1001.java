package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Print_6_1001 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arg = br.readLine();
		// 문자열과 delim(구분문자)를 받아서 객체 생성
		StringTokenizer st = new StringTokenizer(arg, " ");
		// nextToken 메소드를 사용하여 변수를 꺼내옴(순서대로)
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(a-b);
	}
}
/*
	원인 : StringTokenizer를 처음 써보면서 어떻게 써야할지 감이 잘 안옴, split을 자주사용해서 그런지 손에 안익음.
	앞으로 단순 문자열 분리시 사용하면 좋을 것 같다. 
	주의사항 : nextToken(); 사용시 반환된 문자열은 해당 객체에서 사라진다고 함.
*/