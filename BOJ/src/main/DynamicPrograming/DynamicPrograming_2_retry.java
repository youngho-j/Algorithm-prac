package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_2_retry {
	static int[][][] memo = new int[21][21][21];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str = "";
//		�޸������̼�
		setMemo();
//		�Ʒ� if�� �ڵ���� ���̱�
		while(!(str=br.readLine()).equals("-1 -1 -1")) {
//			str = br.readLine();
//			if(str.equals("-1 -1 -1")) {
//				break;
//			}
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
//	�������� �־��� �Լ�
	public static int w(int a, int b, int c) {
//		a, b, c �� 0���� �۰ų� ������ 1����
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
//		a, b, c �� 20 ���� ũ�� w(20, 20, 20)���� ���
		if(a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
//		�޸������̼ǵ� ���� �ҷ��ͼ� ���
		if(a < b && b < c) {
			return memo[a][b][c-1] + memo[a][b-1][c-1] - memo[a][b-1][c];
		}
		return memo[a-1][b][c] + memo[a-1][b-1][c] + memo[a-1][b][c-1] - memo[a-1][b-1][c-1];
	}
//	�迭�� �̸� �� �־�δ� �Լ� 
	public static void setMemo() {
		for(int i = 0 ; i < 21 ; i++) {
			for(int j = 0 ; j < 21 ; j++) {
				for(int k = 0 ; k < 21 ; k++) {
					memo[i][j][k] = w(i, j, k);
				}
			}
		}
	}
}
