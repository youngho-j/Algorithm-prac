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
 *  ���ǻ��� :
 *  null if the end of thestream has been reached without reading any characters
 *  ���̻� ���� �� ���� ��� null�� ��ȯ�Ѵ�.
 *  �Է��ϰ� ������ŭ�� ������ �Է� �� ����Ű �Է� -> ctrl + z�� �ϸ� eof�߻�
 *  
 *  Scanner Ŭ������ ��� hasNext.. ������ boolean���� ��
 */
