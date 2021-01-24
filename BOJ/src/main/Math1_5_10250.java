package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math1_5_10250 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		/*
		 * ����
		 * �������� �������� �Ÿ� ���� 
		 * ������ �� �� ������ �Ÿ��� 1 ����
		 * ���� �̵��Ÿ� �Ű�x
		 * �ȴ°Ÿ� ������ �Ʒ����� ��ȣ
		 */
		//�׽�Ʈ ������ Ƚ��
		int count = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// h : ����, w : ���� ���� ��, n : ���° �մ�����
			int h = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken()); 
			int n = Integer.parseInt(st.nextToken()); 
			
			// ���� ����
			if(n % h == 0) {
				sb.append((h*100) + (n/h)).append("\n");
			} else {
				sb.append(((n%h)*100) + ((n/h)+1)).append("\n");
			}			
		}
		System.out.println(sb);
	}
}

/*
 * ���� : ���� ��½� roomNumber�� ���ڸ����� ���ڸ����� ������ �� �ʿ� ���µ�.. 
 * ������ 101, 201, 301, ..., 1201, .. ó�� 100������ ����
 * ���� �ڵ�
 * // ���� ����
			if(n % h == 0) {
				floor = h;
				roomNumber = n/h;
			} else {
				floor = n % h;
				roomNumber = (n/h)+1;
			}
			//���
			if(roomNumber / 10 == 0) {
				sb.append(floor).append(0).append(roomNumber).append("\n");
			} else {
				sb.append(floor).append(roomNumber).append("\n");					
			}
		}
		System.out.println(sb);
 */
