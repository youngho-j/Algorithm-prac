package main.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_6_1152 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		int cnt = 0;
//		String str = null; 
//		while(st.hasMoreTokens()) {
//			str = st.nextToken();
//			if(str != null) {
//				cnt++;				
//			}
//		}
//		System.out.println(cnt);
		System.out.println(st.countTokens());
	}
}

/*
 * ������� : StringTokenizer Ŭ������ countTokens() �޼ҵ� ���� ��� ��ū�� �����ϴ��� �� �� ����
 */
