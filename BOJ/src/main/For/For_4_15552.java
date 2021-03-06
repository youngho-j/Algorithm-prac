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
 	���� : ����� ���� ����ǥ���
 	������� : 
 	���� ����ǥ - +�����ڿ� ���� Integer������ ����ȯ�Ͽ� ���ڷ� ǥ��
 	ū ����ǥ - ���ڿ��� �ν��Ͽ� �� ���ڰ� �������� ��� ǥ��
 	���� ���ڿ��� ��ĥ��� �ݵ�� ū����ǥ ����ϱ�!
 */
