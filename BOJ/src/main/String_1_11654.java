package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1_11654 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pf = br.readLine().charAt(0);
		System.out.println(pf);
	}
}

/*
 * 참고 : String class CharAt(i)는 첫인덱스 번호는 0이다.
 */
