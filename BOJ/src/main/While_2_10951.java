package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class While_2_10951 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
	
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(a+b).append("\n");
		}
		System.out.println(sb);
	}
}

/*
 *  주의사항 :
 *  null if the end of thestream has been reached without reading any characters
 *  더이상 읽을 수 없을 경우 null을 반환한다.
 *  입력하고 싶은만큼의 데이터 입력 후 엔터키 입력 -> ctrl + z를 하면 eof발생
 *  
 *  Scanner 클래스의 경우 hasNext.. 리턴은 boolean으로 됨
 */
