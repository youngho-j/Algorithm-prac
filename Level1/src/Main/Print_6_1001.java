package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Print_6_1001 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arg = br.readLine();
		// ���ڿ��� delim(���й���)�� �޾Ƽ� ��ü ����
		StringTokenizer st = new StringTokenizer(arg, " ");
		// nextToken �޼ҵ带 ����Ͽ� ������ ������(�������)
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(a-b);
	}
}
/*
	���� : StringTokenizer�� ó�� �Ẹ�鼭 ��� ������� ���� �� �ȿ�, split�� ���ֻ���ؼ� �׷��� �տ� ������.
	������ �ܼ� ���ڿ� �и��� ����ϸ� ���� �� ����. 
	���ǻ��� : nextToken(); ���� ��ȯ�� ���ڿ��� �ش� ��ü���� ������ٰ� ��.
*/