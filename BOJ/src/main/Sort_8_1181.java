package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_8_1181 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		String[] list = new String[N];
		
		for(int i = 0 ; i < N ; i++) {
			list[i] = br.readLine();
		}
//		�͸� Ŭ������ ����߱⶧���� ������ �� (�ܺ�Ŭ������)$(����).class ������ ���� ���� ��
		Arrays.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
//				�ܾ� ���̰� ������
				if(o1.length() == o2.length()) {
//					���� ������(��������)
					return o1.compareTo(o2);
				} else {
//					���̰� ª�� �ͺ��� ���(���� ��������)
					return o1.length() - o2.length();
				}
			}
		});
//		�ߺ� �ܾ�� ������� ����
		sb.append(list[0] + "\n");
		
		for(int i = 1 ; i < N ; i++) {
			if(!list[i].equals(list[i-1])) {
				sb.append(list[i] + "\n");				
			}
		}
		System.out.println(sb);
	}
}
