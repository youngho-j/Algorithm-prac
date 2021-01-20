package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Print_8_1008 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Double c = Double.parseDouble(st.nextToken());
		Double d = Double.parseDouble(st.nextToken());
		System.out.println(c/d);
	}
}

/*
���ǻ��� : ���� ����� ��°��� ������� �Ǵ� �������� 10 -9�� �����̸� �����̴�.. 
ä���� �¾Ҵٰ�� ���Դµ� �̰� ���������� �� �𸣰ڴ�.
�ϴ� �Ҽ��� ��Ÿ�����ؼ� Double���� �ۼ����ֱ��ߴµ� �� �� �˾ƺ����ҵ�..

1) ������ Ǯ ���� float���ٴ� double�� ������ ���°� �����ϴ�.
double�� ���������� �ϵ����� ���Ǳ� ������ ���� �������� ������, ��Ȯ���� ��û���� �������� �����Դϴ�.

- float�� �������� �� 10^-7 ����
- double�� ��� ������ �� 10^-15 ����
- long double (12bit Ȥ�� 16bit)�� ����Ʈ������ ������ �ޱ� ������ �� ���� �������� ������ ���ٰ� �� ���� ���� �ƴմϴ�.

����) https://www.acmicpc.net/blog/view/37
 */
