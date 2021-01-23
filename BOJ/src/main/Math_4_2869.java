package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_4_2869 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// a : ���� �̵� �Ÿ�, b : �㿡 �̲������� �Ÿ�, v : ���� ����, day : �ϼ�
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		// ���� : ���� �̵� a �㿡 �̲������� b, ���� ������ �̲������� ����
		int day = (v-b) / (a-b);
		//�������� ���� -> �̵��Ÿ� ������ ���� �ϼ��� +1
		if((v-b) % (a-b) != 0) {
			day++;
		}
		System.out.println(day);
	}
}

/*
 * Ǯ�� 
 * �õ�1 : while�� ����Ͽ� Ǯ�� / ����� ������, �ð��ʰ�
 * �õ�2 : ���� / �̵� - �̲������� / ������� �ٸ��� ����.. 
 * �õ�3 : ���� ī����, ���� ������ ī���ü��� �ϳ� �� ����, ���� = �ϼ�(�̵�-�̲�)+�̲� -> �ϼ� = (����-�̲�)/(�̵�-�̲�)
 * �õ�1 �ڵ�
   // a : ���� �̵� �Ÿ�, b : �㿡 �̲������� �Ÿ�, v : ���� ����, h : ����ġ, day : �ϼ�
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int h = 0;
		int day = 0;
		while(true) {
			// ���� �ö󰡴� �Ÿ���ŭ �� ���ֱ�
			h += a;
			// ���� �ö��Ŀ� �̲������� �����Ƿ� ���� �������� Ȯ��
			if(h >= v) {
				day++;
				break;
			} else {
				// ���� �������ܿ� �ڴµ��� �̲����� �Ÿ��� ����, �׸��� �Ϸ縦 ī��Ʈ
				h -= b;
				day++;
			}
		}
		System.out.println(day);
 */
