package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sort_9_10814 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
//		����, �̸��� �־��� �迭 ����
		String[][] list = new String[N][2];
		
//		����, �̸��� " "���� �����Ͽ� �迭�� �߰�
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
		}
//		������ �ϸ鼭 ���̼����� ��, ���̰� ���� ���� �״�� ���(���� ������ ����� �տ� ��)
		Arrays.sort(list, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
					return 0;
				} else {
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
				}
			}
			
		});
//		���
		for(int i = 0 ; i < N ; i++) {
			sb.append(list[i][0] + " " + list[i][1] + "\n");
		}
		System.out.println(sb);
	}
}
