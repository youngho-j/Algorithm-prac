package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class For_1_2739 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		br.close();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1 ; i<=9 ; i++) {
//			System.out.println(a + " * " + i +  " = " + (a*i));
			bw.write(a + " * " + i +  " = " + (a*i));
			if(i != 9) {
				bw.newLine();				
			}
		}
		bw.flush();
		bw.close();
	}
}
