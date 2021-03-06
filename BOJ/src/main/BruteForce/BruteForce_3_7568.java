package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_3_7568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
//		������ Ű ������ ���� �迭
		int[][] arr = new int[3][N];
//		�����Կ� Ű�� �� �� 0,1 ��ġ�� �����
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 2 ; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
//		�����Կ� Ű �� ������ ��
		for(int i = 0 ; i < N-1 ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				if(arr[0][i] > arr[0][j] && arr[1][i] > arr[1][j]) {
					arr[2][j] += 1;
				} else if(arr[0][i] < arr[0][j] && arr[1][i] < arr[1][j]) {
					arr[2][i] += 1;
				}
			}
		}
//		���Ͽ� ���� ���� +1�Ͽ� ���� ���
		for(int i = 0 ; i < N ; i++) {
			sb.append(arr[2][i] + 1).append(" ");
		}
		System.out.println(sb);
	}
}
